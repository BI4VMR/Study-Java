package net.bi4vmr.study;

/**
 * Name        : BuyThread
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@outlook.com
 * <p>
 * Date        : 2023-09-24 13:52
 * <p>
 * Description : 线程：购买商品（同步方法）。
 */
public class BuyThread3 extends Thread {

    // 静态全局变量，表示商品的剩余数量，初始为10件。
    static int count = 10;

    @Override
    public void run() {
        while (true) {
            boolean hasNext = buy();
            // 若无剩余商品，则退出循环。
            if (!hasNext) {
                break;
            }
        }
    }

    /**
     * 购买商品
     *
     * @return 是否还有剩余商品
     */
    private static synchronized boolean buy() {
        // 判断如果商品仍有存货，则进行购买。（动作一）
        if (count > 0) {
            // 商品剩余数量-1，模拟该商品已被当前线程持有。（动作二）
            count--;
            // 输出日志（动作三）
            String thName = Thread.currentThread().getName();
            System.out.println(thName + ": Buy good with index: " + (count + 1));
        } else {
            // 没有剩余商品，返回"false"。
            return false;
        }
        return true;
    }
}
