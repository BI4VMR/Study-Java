package net.bi4vmr.study.thread;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 示例代码：线程。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class TestThread {

    public static void main(String[] args) {
        example06();
    }

    /**
     * 示例一：创建线程（继承Thread类）。
     * <p>
     * 在本示例中，我们继承Thread类并重写 `run()` 方法，创建自定义线程。
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
     * 示例二：创建线程（实现Runnable接口）。
     * <p>
     * 在本示例中，我们实现Runnable接口并构造Thread实例，创建自定义线程。
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
     * 示例三：守护线程。
     * <p>
     * 在本示例中，我们创建前文“示例一”中的MyThread线程，并将其设置为守护线程。
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
     * 示例四：线程休眠。
     * <p>
     * 在本示例中，我们创建一个线程，使其休眠3秒后再恢复运行。
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

    /**
     * 示例五：中断未阻塞的任务。
     * <p>
     * 在本示例中，我们编写一个支持中断请求的线程，并从外部发出中断指令，观察其行为。
     */
    static void example05() {
        Thread subThread = new Thread(() -> {
            // 模拟需要反复执行的任务
            for (int i = 1; i <= 1000; i++) {
                // 每轮循环开始前，先判断当前任务是否已被取消。
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("SubThread has been interrupted!");
                    // 退出 `run()` 方法，结束当前任务。
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
     * 示例六：中断已阻塞的任务。
     * <p>
     * 在本示例中，我们对阻塞状态的线程发送中断指令，观察其行为。
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
