package net.bi4vmr.study.sync;

/**
 * 示例代码："Wait"和"Notify"机制。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class TestWaitNotify {

    public static void main(String[] args) {
        example05();
    }

    // 全局变量，表示商品库存数量。
    static int count = 0;

    final static Object lock = new Object();

    /**
     * 示例：等待与唤醒。
     */
    static void example05() {

        // 生产者线程（模拟进货的过程）
        Thread thread = new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(3000L); // 先休眠，再加锁生产
                    synchronized (lock) {
                        count++;
                        System.out.println(Thread.currentThread().getName() + " -> count added");
                        lock.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread.setName("商家");

        // 消费者线程（模拟抢购的过程）
        Thread buyThread = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " -> count is: " + count);
                    if (count > 0) {
                        count--;
                        System.out.println(Thread.currentThread().getName() + " -> Buy one good, remain count is: " + count);
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });
        buyThread.setName("客户");

        thread.start();
        buyThread.start();
    }
}
