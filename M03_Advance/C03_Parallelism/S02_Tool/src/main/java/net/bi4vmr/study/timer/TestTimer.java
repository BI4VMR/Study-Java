package net.bi4vmr.study.timer;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 测试代码 - Timer。
 *
 * @author bi4vmr@outlook.com
 */
public class TestTimer {

    public static void main(String[] args) {
        example01();
    }

    /**
     * 示例：基本应用。
     */
    static void example01() {
        // 创建任务
        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
                System.out.println("Task Executed. Time:[" + getTime() + "]");
            }
        };

        // 创建Timer对象
        Timer timer = new Timer();

        // 以当前时刻为参考点，在1000毫秒之后执行任务TimerTask。
        // timer.schedule(timerTask, 1000L);

        // 以当前时刻为参考点，在1秒之后执行任务TimerTask，且每隔1秒重复执行一次。
        // timer.schedule(timerTask, 1000L, 1000L);

        // 在”当前时刻+3秒“执行任务TimerTask。
        // Date date = new Date();
        // date.setTime(System.currentTimeMillis() + 3000L);
        // timer.schedule(timerTask, date);

        // 在”当前时刻+3秒“执行任务TimerTask，且每隔1秒重复执行一次。
        // Date date = new Date();
        // date.setTime(System.currentTimeMillis() + 3000L);
        // timer.schedule(timerTask, date, 1000L);

        // 以当前时刻为参考点，在1秒之后执行任务TimerTask，且每隔1秒重复执行一次。
        // timer.scheduleAtFixedRate(timerTask, 1000L, 1000L);

        // 在”当前时刻+3秒“执行任务TimerTask，在1秒之后执行任务TimerTask，且每隔1秒重复执行一次。
        Date date = new Date();
        date.setTime(System.currentTimeMillis() + 3000L);
        timer.scheduleAtFixedRate(timerTask, date, 1000L);
    }

    /*
     * 取消任务
     */
    static void example02() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Exec start. Time: " + LocalDateTime.now());
                System.out.println("Exec end. Time: " + LocalDateTime.now());
            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask, 1000L, 1000L);

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
    }

    /*
     * "schedule"方法
     */
    static void example03() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Exec Time: " + LocalTime.now());
            }
        };

        // 获取当前时间
        Date date = new Date();
        System.out.println("Reference Time: " + date);

        // 阻塞当前线程3秒，不处理任何任务。
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 创建Timer并开启任务，参考时间点设置为3秒前。
        Timer timer = new Timer();
        timer.schedule(timerTask, date, 1000L);
    }

    /*
     * "scheduleAtFixedRate"方法
     */
    static void example04() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Exec Time: " + LocalTime.now());
            }
        };

        // 获取当前时间
        Date date = new Date();
        System.out.println("Reference Time: " + date);

        // 阻塞当前线程3秒，不处理任何任务。
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 创建Timer并开启任务，参考时间点设置为3秒前。
        Timer timer = new Timer();
        timer.cancel();
        timer.scheduleAtFixedRate(timerTask, date, 1000L);
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
