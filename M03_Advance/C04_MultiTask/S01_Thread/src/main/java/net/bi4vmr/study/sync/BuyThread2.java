package net.bi4vmr.study.sync;

/**
 * 测试代码 - 线程：购买商品（同步代码块）。
 *
 * @author bi4vmr@outlook.com
 */
public class BuyThread2 extends Thread {

    // 静态全局变量，表示已售出的商品数量。
    private static int count = 0;

    @Override
    public void run() {
        while (true) {
            // 加锁，确保以下三个操作一次性执行完毕，中途不会被其他线程打断。
            synchronized (BuyThread2.class) {
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
}
