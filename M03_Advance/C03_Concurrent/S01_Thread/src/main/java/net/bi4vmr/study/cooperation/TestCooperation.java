package net.bi4vmr.study.cooperation;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 测试代码 - 线程。
 *
 * @author bi4vmr@outlook.com
 */
public class TestCooperation {

    public static void main(String[] args) {
        example02();
    }

    static void task(String name, long time) {
        try {
            System.out.println("Task " + name + " start. Thread:[" + getName() + "] Time:[" + getTime() + "]");
            Thread.sleep(time);
            System.out.println("Task " + name + " end. Thread:[" + getName() + "] Time:[" + getTime() + "]");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 示例：顺序执行任务。
     */
    static void example01() {
        Thread thread = new Thread(() -> {
            // 先执行第一个任务
            task("A", 2000L);
            // 第一个任务执行完毕后，再执行第二个任务。
            task("B", 2000L);
        });
        thread.start();
    }

    /**
     * 示例：并发执行任务。
     */
    static void example02() {
        // 定义线程A并启动它
        Thread threadA = new Thread(() -> {
            task("A", 2000L);
        });
        threadA.start();

        // 定义线程B并启动它
        Thread threadB = new Thread(() -> {
            task("B", 2000L);
        });
        threadB.start();
    }

    /**
     * 示例：基本应用 - 继承Thread类。
     */
    static void example0111() {
        FutureTask<Integer> task = new FutureTask<Integer>(new Callable() {
            @Override
            public Integer call() throws Exception {
                // 当前线程休眠2秒，模拟耗时操作。
                Thread.sleep(2000L);
                String name = Thread.currentThread().getName();
                System.out.println("Thread:[" + name + "]");
                return 100;
            }
        });

        Thread thread = new Thread(task);
        thread.start();
        // 启动线程，开始执行任务。
        try {
            int result = task.get();
            System.out.println("Get result " + result);
            System.out.println("Thread main end.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取线程名称。
     *
     * @return 线程名称。
     */
    private static String getName() {
        return Thread.currentThread().getName();
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
