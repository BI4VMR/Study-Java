package net.bi4vmr.study.sync;

/**
 * 示例代码：等待与唤醒机制。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class TestWaitNotify {

    // 全局变量，表示商品库存数量。
    static int count = 0;

    // 锁对象，生产者和消费者线程都需要通过它进行同步。
    final static Object lock = new Object();

    /**
     * 示例五：等待与唤醒。
     */
    public static void main(String[] args) {

        // 生产者任务（模拟进货的过程）
        Runnable producerTask = () -> {
            while (true) {
                // 每次补货之前休眠3秒，模拟进货的间隔。
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    System.err.println("线程被中断！");
                }

                synchronized (lock) {
                    // 补货
                    count++;
                    System.out.println(Thread.currentThread().getName() + " -> 已补货1件，当前库存: " + count);
                    // 唤醒所有等待的消费者线程，让它们开始抢购。
                    lock.notifyAll();
                }
            }
        };

        // 消费者任务（模拟抢购的过程）
        Runnable consumerTask = () -> {
            while (true) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " -> 当前库存: " + count);
                    if (count > 0) {
                        /* 有库存，购买1件。 */
                        System.out.println(Thread.currentThread().getName() + " -> 购买1件。");
                        count--;
                    } else {
                        /* 无库存，阻塞等待。 */
                        System.out.println(Thread.currentThread().getName() + " -> 等待补货...");
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            System.err.println("线程被中断！");
                        }
                    }
                }
            }
        };


        // 创建商家线程与客户线程，并开始执行任务。
        Thread producerThread = new Thread(producerTask);
        producerThread.setName("商家");
        Thread consumerThread1 = new Thread(consumerTask);
        consumerThread1.setName("客户A");
        Thread consumerThread2 = new Thread(consumerTask);
        consumerThread2.setName("客户B");

        producerThread.start();
        consumerThread1.start();
        consumerThread2.start();
    }
}
