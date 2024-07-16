package net.bi4vmr.study.thread;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 测试代码 - 线程。
 *
 * @author bi4vmr@outlook.com
 */
public class TestThread {

    public static void main(String[] args) {
        example06();
    }

    /**
     * 示例：基本应用 - 继承Thread类。
     */
    static void example01() {
        // 构造MyThread对象，每个MyThread对象都是一个独立的线程。
        MyThread thread = new MyThread();
        // 启动线程，执行"run()"方法中的任务。
        thread.start();

        // 使用主线程向控制台输出消息
        for (int i = 1; i <= 10; i++) {
            String name = Thread.currentThread().getName();
            System.out.println("Thread:[" + name + "]");
        }
    }

    /**
     * 示例：基本应用 - 实现Runnable接口。
     */
    static void example02() {
        // 构造Thread对象，并通过构造方法传入任务。
        Thread thread = new Thread(
                // 创建匿名内部类，实现Runnable接口。
                new Runnable() {
                    @Override
                    public void run() {
                        // 此处放置自定义语句，本示例为向控制台输出消息。
                        for (int i = 1; i <= 10; i++) {
                            String name = Thread.currentThread().getName();
                            System.out.println("Thread:[" + name + "] Index:[" + i + "]");
                        }
                    }
                }
        );
        // 启动线程，开始执行任务。
        thread.start();

        // 使用主线程向控制台输出消息
        for (int i = 1; i <= 10; i++) {
            String name = Thread.currentThread().getName();
            System.out.println("Thread:[" + name + "]");
        }
    }

    /**
     * 示例：守护线程。
     */
    static void example03() {
        System.out.println("Main thread starded.");

        MyThread subThread = new MyThread();
        // 将子线程设置为守护线程
        subThread.setDaemon(true);
        // 启动子线程
        subThread.start();

        System.out.println("Main thread finished.");
    }

    /**
     * 示例：线程休眠。
     */
    static void example04() {
        // 构造Thread实例，并通过构造方法传入任务。
        Thread thread = new Thread(() -> {
            System.out.println("Thread start. Time:[" + getTime() + "]");
            try {
                // 休眠3秒后再继续执行
                Thread.sleep(3000L);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Thread end. Time:[" + getTime() + "]");
        });
        // 启动线程，执行构造方法传入的任务。
        thread.start();
    }

    // /*
    //  * 线程的调度：插队
    //  */
    // static void example04() {
    //     MyThread subThread = new MyThread();
    //     // 启动子线程
    //     subThread.start();
    //
    //     try {
    //         // 使子线程插队至主线程前执行。
    //         subThread.join();
    //     } catch (InterruptedException e) {
    //         throw new RuntimeException(e);
    //     }
    //
    //     // 此处放置线程需要执行的操作，本示例将向控制台输出消息。
    //     for (int i = 0; i <= 100; i++) {
    //         System.out.println("Print some messages in thread:Main, index:" + i);
    //     }
    // }

    /**
     * 示例：中断任务 - 中断未阻塞的任务。
     */
    static void example05() {
        Thread subThread = new Thread(() -> {
            // 模拟需要反复执行的任务
            for (int i = 1; i <= 1000; i++) {
                // 每轮循环开始前，先判断当前任务是否已被取消。
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("SubThread has been interrupted!");
                    // 退出"run()"方法，结束当前任务。
                    return;
                }

                // 继续执行任务
                System.out.println("Subthread is running. Index:[" + i + "]");
            }
        });

        try {
            // 启动子线程
            subThread.start();

            // 主线程休眠10毫秒，让子线程运行一会儿。
            Thread.sleep(10L);
            // 向子线程发出中断信号
            subThread.interrupt();
            System.out.println("Send interrupt signal in Main Thread.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 示例：中断任务 - 中断已阻塞的任务。
     */
    static void example06() {
        Thread subThread = new Thread(() -> {
            try {
                System.out.println("SubThread start.");
                // 进入休眠状态
                Thread.sleep(1000L);
                System.out.println("SubThread end.");
            } catch (InterruptedException e) {
                /* 捕获中断异常 */
                System.out.println("SubThread is waiting and be interrupted.");
            } finally {
                /* 清理资源 */
                System.out.println("SubThread clean.");
            }
        });

        // 启动子线程
        subThread.start();
        // 向子线程发出中断信号
        subThread.interrupt();
    }

    /**
     * 获取当前时间。
     *
     * @return 时间字符串（HH:mm:ss.SSS）。
     */
    private static String getTime() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        return LocalTime.now().format(dateFormatter);
    }
}
