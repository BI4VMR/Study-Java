package net.bi4vmr.study.thread;

/**
 * 自定义线程。
 *
 * @author bi4vmr@outlook.com
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        // 此处放置自定义语句，本示例为向控制台输出消息。
        for (int i = 1; i <= 10000; i++) {
            System.out.println("Thread:[" + getName() + "] Index:[" + i + "]");
        }
    }
}
