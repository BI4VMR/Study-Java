package net.bi4vmr.study.sync;

/**
 * Name        : BuyThread
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@outlook.com
 * <p>
 * Date        : 2023-09-24 13:52
 * <p>
 * Description : 线程：购买商品（未同步）。
 */
public class BuyThread extends Thread {

    // 静态全局变量，表示商品的剩余数量，初始为10件。
    static int count = 10;

    @Override
    public void run() {
        while (true) {
            // 判断如果商品仍有存货，则进行购买。（动作一）
            if (count > 0) {
                // 商品剩余数量-1，模拟该商品已被当前线程持有。（动作二）
                count--;
                // 输出日志（动作三）
                System.out.println(getName() + ": Buy good with index: " + (count + 1));
            } else {
                break;
            }
        }
    }
}
