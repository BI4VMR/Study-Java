package net.bi4vmr.study.sync;

/**
 * 测试代码 - 数据同步。
 *
 * @author bi4vmr@outlook.com
 */
public class TestThreadSync {

    public static void main(String[] args) {
        example01();
    }

    // 静态全局变量，表示商品库存数量。
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

        // 开启三个任务
        thread1.start();
        thread2.start();
        thread3.start();
    }

    /**
     * 示例：同步代码块。
     */
    static void example02() {
        // 定义三个线程，模拟三个客户，它们的任务都是循环购买商品。
        Thread thread1 = new BuyThread2();
        thread1.setName("客户A");
        Thread thread2 = new BuyThread2();
        thread2.setName("客户B");
        Thread thread3 = new BuyThread2();
        thread3.setName("客户C");

        // 依次开启三个任务，模拟三个客户的购买行为。
        thread1.start();
        thread2.start();
        thread3.start();
    }

    /**
     * 示例：同步方法。
     */
    static void example03() {
        // 定义三个线程，模拟三个客户，它们的任务都是循环购买商品。
        Thread thread1 = new BuyThread3();
        thread1.setName("客户A");
        Thread thread2 = new BuyThread3();
        thread2.setName("客户B");
        Thread thread3 = new BuyThread3();
        thread3.setName("客户C");

        // 依次开启三个任务，模拟三个客户的购买行为。
        thread1.start();
        thread2.start();
        thread3.start();
    }

    /**
     * 示例：等待与唤醒。
     */
    static void example04() {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public synchronized void run() {
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                this.notify();
            }
        });
        thread1.setName("客户1");

        synchronized (thread1) {
            // 定义三个线程，模拟三个客户，它们的任务都是循环购买商品。
            thread1.start();

            try {
                thread1.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
