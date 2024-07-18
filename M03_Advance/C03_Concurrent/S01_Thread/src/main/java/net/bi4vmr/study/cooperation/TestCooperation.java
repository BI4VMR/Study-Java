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
        example05();
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
     * 示例：等待其他任务完成。
     */
    static void example03() {
        System.out.println("Task root start.");
        // 定义线程A并启动它
        Thread threadA = new Thread(() -> {
            task("A", 2000L);
        });
        threadA.start();

        try {
            // 在当前线程中调用线程A的"join()"方法，等待线程A结束再继续运行。
            threadA.join();
            System.out.println("Task root end.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 示例：获取其他任务的结果。
     */
    static void example04() {
        System.out.println("Task Root start.");
        // 定义FutureTask
        FutureTask<Integer> task = new FutureTask<Integer>(new Callable() {
            @Override
            public Integer call() throws Exception {
                task("A", 2000);
                return 114514;
            }
        });
        // 通过FutureTask创建线程
        Thread threadA = new Thread(task);
        // 启动线程，开始执行任务。
        threadA.start();

        try {
            // 异步等待任务结束，并接收返回值。
            int result = task.get();
            System.out.println("Task Root end, task A result is " + result + ".");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 定义MyTask类，以便创建多个Task对象。
     */
    static class MyTask implements Callable<Integer> {

        private final String name;

        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public Integer call() {
            task(name, 2000);
            return 114514;
        }
    }

    /**
     * 示例：合并多个任务的结果。
     */
    static void example05() {
        // 创建两个FutureTask实例
        FutureTask<Integer> taskA = new FutureTask<>(new MyTask("A"));
        FutureTask<Integer> taskB = new FutureTask<>(new MyTask("B"));

        // 创建两个线程，分别关联上述的两个FutureTask实例。
        Thread threadA = new Thread(taskA);
        Thread threadB = new Thread(taskB);

        // 启动线程，开始执行任务。
        threadA.start();
        threadB.start();

        try {
            // 异步等待任务结束，并接收返回值。
            int result = taskA.get() + taskB.get();
            System.out.println("All task is end, summary is " + result + ".");
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
