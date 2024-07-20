package net.bi4vmr.study.sync;

/**
 * 测试代码 - 线程：购买商品（未同步）。
 *
 * @author bi4vmr@outlook.com
 */
public class BuyThread extends Thread {

    // 静态全局变量，表示已售出的商品数量。
    static int count = 0;

    @Override
    public void run() {
        while (true) {
            // 如果仍有存货，则进行购买。（动作一）
            if (count < 10) {
                // 商品数量+1。（动作二）
                count++;
                // 输出日志（动作三）
                System.out.println(getName() + " -> Buy good with index: " + count);
            } else {
                break;
            }
        }
    }
}
