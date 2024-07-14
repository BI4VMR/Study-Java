package net.bi4vmr.study.thread;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Name        : TestExecutor
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@outlook.com
 * <p>
 * Date        : 2024-04-14 14:36
 * <p>
 * Description : 测试类 - Executor。
 */
public class TestExecutor {

    public static void main(String[] args) {
        example05();
    }

    /*
     * 测试任务
     */
    private static class Task implements Runnable {

        private final String name;

        public Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("Task [" + name + "] start. Time:[" + LocalTime.now() + "]");
            // 阻塞当前线程2秒，模拟任务耗时。
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task [" + name + "] end.");
        }
    }

    /*
     * 预设线程池：SingleThreadExecutor
     */
    static void example01() {
        // 使用预设配置SingleThreadExecutor创建线程池实例
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new Task("A"));
        executor.execute(new Task("B"));
        // 关闭线程池
        executor.shutdown();
    }

    /*
     * 预设线程池：FixedThreadPool
     */
    static void example02() {
        // 使用预设配置FixedThreadPool创建线程池实例
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new Task("A"));
        executor.execute(new Task("B"));
        executor.execute(new Task("C"));
        // 关闭线程池
        executor.shutdown();
    }

    /*
     * 预设线程池：FixedThreadPool
     */
    static void example03() {
        // 使用预设配置CachedThreadPool创建线程池实例
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(new Task("A"));
        executor.execute(new Task("B"));
        executor.execute(new Task("C"));
        // 关闭线程池
        // executor.shutdown();
    }

    /*
     * 预设线程池：ScheduledExecutorService
     */
    static void example04() {
        // 使用预设配置SingleThreadScheduledExecutor创建线程池实例
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

        // 延时2秒后执行任务
        // executor.schedule(new Task("A"), 2, TimeUnit.SECONDS);

        // 延时2秒后执行任务，且每隔2秒重复执行一次任务。
        executor.scheduleAtFixedRate(new Task("B"), 2, 2, TimeUnit.SECONDS);

        // 关闭线程池
        // executor.shutdown();
    }

    /*
     * 预设线程池：ScheduledThreadPool
     */
    static void example05() {
        // 使用预设配置ScheduledExecutor创建线程池实例
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        // 延时2秒后执行任务
        // executor.schedule(new Task("A"), 2, TimeUnit.SECONDS);

        // 延时2秒后执行任务，且每隔2秒重复执行一次任务。
        executor.scheduleAtFixedRate(new Task("B"), 2, 2, TimeUnit.SECONDS);

        // 关闭线程池
        // executor.shutdown();
    }
}
