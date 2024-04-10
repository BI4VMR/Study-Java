package net.bi4vmr.study.concurrent;

import java.time.LocalDateTime;
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
                System.out.println("Time:" + LocalDateTime.now());
            }
        };
        Timer timer = new Timer();
//        timer.schedule(timerTask,1000L,1000L);
        timer.scheduleAtFixedRate(timerTask, 1000L, 1000L);
    }
}
