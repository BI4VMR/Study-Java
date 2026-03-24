package net.bi4vmr.study.sync;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

/**
 * 测试代码 - 数据同步。
 *
 * @author bi4vmr@outlook.com
 */
public class TestThreadSync {

    public static void main(String[] args) {
        example03();
    }

    // 全局变量，表示商品库存数量。
    static int count = 10;

    /**
     * 示例一：竞态条件。
     * <p>
     * 在本示例中，我们以“多人购买同一款商品”场景为例，展示竞态条件造成的问题。
     */
    static void example01() {
        // 定义任务：循环购买商品。
        Runnable task = () -> {
            while (true) {
                // 如果仍有存货，则进行购买。（动作一）
                if (count > 0) {
                    // 更新库存数量。（动作二）
                    count--;
                    // 输出日志（动作三）
                    System.out.println(Thread.currentThread().getName() + " -> Buy one good, remain count is: " + count);
                } else {
                    break;
                }
            }
        };

        // 定义三个线程，模拟三个客户。
        Thread thread1 = new Thread(task);
        thread1.setName("客户A");
        Thread thread2 = new Thread(task);
        thread2.setName("客户B");
        Thread thread3 = new Thread(task);
        thread3.setName("客户C");

        // 所有客户开始购买商品
        thread1.start();
        thread2.start();
        thread3.start();
    }

    /**
     * 示例二：同步代码块。
     * <p>
     * 在本示例中，我们通过同步代码块解决前文示例中的竞态条件问题。
     */
    static void example02() {
        // 定义任务：循环购买商品。
        Runnable task = () -> {
            while (true) {
                // 加锁，确保以下三个操作一次性执行完毕，中途不会被其他线程打断。
                synchronized (TestThreadSync.class) {
                    if (count > 0) {
                        count--;
                        System.out.println(Thread.currentThread().getName() + " -> Buy one good, remain count is: " + count);
                    } else {
                        break;
                    }
                }
            }
        };

        // 定义三个线程，模拟三个客户。
        Thread thread1 = new Thread(task);
        thread1.setName("客户A");
        Thread thread2 = new Thread(task);
        thread2.setName("客户B");
        Thread thread3 = new Thread(task);
        thread3.setName("客户C");

        // 开启三个任务
        thread1.start();
        thread2.start();
        thread3.start();
    }

    /**
     * 示例三：同步方法。
     * <p>
     * 在本示例中，我们通过同步方法解决前文示例中的竞态条件问题。
     */
    static void example03() {
        // 定义任务：循环购买商品。
        Runnable task = () -> {
            while (buy()) ;
        };

        // 定义三个线程，模拟三个客户，它们的任务都是循环购买商品。
        Thread thread1 = new Thread(task);
        thread1.setName("客户A");
        Thread thread2 = new Thread(task);
        thread2.setName("客户B");
        Thread thread3 = new Thread(task);
        thread3.setName("客户C");

        // 依次开启三个任务，模拟三个客户的购买行为。
        thread1.start();
        thread2.start();
        thread3.start();
    }

    // 同步方法，整段方法体都需要同步。
    synchronized static boolean buy() {
        if (count <= 0) {
            // 库存售空，返回 `false` 。
            return false;
        } else {
            // 库存非空，购买一件商品并返回 `true` 。
            count--;
            System.out.println(Thread.currentThread().getName() + " -> Buy one good, remain count is: " + count);
            return true;
        }
    }


    /**
     * 示例四：选择合适的同步对象。
     * <p>
     * 在本示例中，我们通过同步方法解决前文示例中的竞态条件问题。
     */
    static class BusinessManager {

        private int sum = 0;

        private final List<EventListener> listeners = new ArrayList<>();

        // 注册监听器
        public synchronized void addListener(EventListener l) {
            if (!listeners.contains(l)) {
                listeners.add(l);
            }
        }

        // 注销监听器
        public synchronized void removeListener(EventListener l) {
            listeners.remove(l);
        }

        // 计数业务
        public synchronized void counting() {
            sum++;
            System.out.println("New count is: " + sum);
        }
    }


    static class BusinessManager2 {

        private int sum = 0;

        // 创建对象，作为计数业务的锁。
        private final Object lock = new Object();

        private final List<EventListener> listeners = new ArrayList<>();

        // 注册监听器
        public void addListener(EventListener l) {
            synchronized (listeners) {
                if (!listeners.contains(l)) {
                    listeners.add(l);
                }
            }
        }

        // 注销监听器
        public void removeListener(EventListener l) {
            synchronized (listeners) {
                listeners.remove(l);
            }
        }

        // 计数业务
        public void counting() {
            synchronized (lock) {
                sum++;
                System.out.println("New count is: " + sum);
            }
        }
    }
}
