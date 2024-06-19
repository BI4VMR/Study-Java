package net.bi4vmr.study.concurrent;

/**
 * Name        : BuyThread2
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@outlook.com
 * <p>
 * Date        : 2023-09-24 13:52
 * <p>
 * Description : 线程：购买商品（同步代码块）。
 */
public class BuyThread2 extends Thread {

    // 静态全局变量，表示商品的剩余数量，初始为10件。
    static int count = 10;

    @Override
    public void run() {
        while (true) {
            // 加锁，确保当前线程的一次循环执行完毕后，再进行下一次操作。
            synchronized (BuyThread2.class) {
                // 判断如果商品仍有存货，则进行购买。（动作一）
                if (count > 0) {
                    // 商品剩余数量-1，模拟该商品已被当前线程持有。（动作二）
                    count--;
                    // 输出日志（动作三）
                    String thName = Thread.currentThread().getName();
                    System.out.println(thName + ": Buy good with index: " + (count + 1));
                } else {
                    break;
                }
            }
        }
    }
}
