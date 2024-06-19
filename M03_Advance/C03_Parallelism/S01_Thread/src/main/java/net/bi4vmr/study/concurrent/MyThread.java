package net.bi4vmr.study.concurrent;

/**
 * Name        : MyThread
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@outlook.com
 * <p>
 * Date        : 2023-08-27 23:27
 * <p>
 * Description : 线程实现类。
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        // 此处放置线程需要执行的操作，本示例将向控制台输出消息。
        for (int i = 0; i <= 10; i++) {
            System.out.println("Print some messages in thread:" + getName() + ", index:" + i);
        }
    }
}
