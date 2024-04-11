package net.bi4vmr.study.concurrent;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Name        : TestTimer
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@outlook.com
 * <p>
 * Date        : 2023-09-25 22:28
 * <p>
 * Description : 测试类 - Timer。
 */
public class TestTimer {

    public static void main(String[] args) {
        example01();
    }

    /*
     * Timer
     */
    static void example01() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Time: " + LocalDateTime.now());
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask, 1000L, 1000L);
        timer.schedule(timerTask, 1000L, 1000L);
        timer.schedule(timerTask, 1000L, 1000L);
        // timer.schedule();
        // timer.scheduleAtFixedRate(timerTask, 1000L, 1000L);
    }

    /*
     * Timer
     */
    static void example02() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time: " + LocalTime.now());
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
     * Timer
     */
    static void example03() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time: " + LocalTime.now());
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
        timer.scheduleAtFixedRate(timerTask, date, 1000L);
    }
}
