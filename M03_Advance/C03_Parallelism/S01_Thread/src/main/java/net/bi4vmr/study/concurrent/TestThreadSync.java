package net.bi4vmr.study.concurrent;

/**
 * Name        : TestThreadSync
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@outlook.com
 * <p>
 * Date        : 2023-09-24 12:56
 * <p>
 * Description : 测试类 - 线程间的同步。
 */
public class TestThreadSync {

    public static void main(String[] args) {
        example03();
    }

    /*
     * 竞态条件
     */
    static void example01() {
        // 定义三个线程，模拟三个客户，它们的任务都是循环购买商品。
        Thread thread1 = new BuyThread();
        thread1.setName("客户1");
        Thread thread2 = new BuyThread();
        thread2.setName("客户2");
        Thread thread3 = new BuyThread();
        thread3.setName("客户3");

        // 依次开启三个任务，模拟三个客户的购买行为。
        thread1.start();
        thread2.start();
        thread3.start();
    }

    /*
     * 同步代码块
     */
    static void example02() {
        // 定义三个线程，模拟三个客户，它们的任务都是循环购买商品。
        Thread thread1 = new BuyThread2();
        thread1.setName("客户1");
        Thread thread2 = new BuyThread2();
        thread2.setName("客户2");
        Thread thread3 = new BuyThread2();
        thread3.setName("客户3");

        // 依次开启三个任务，模拟三个客户的购买行为。
        thread1.start();
        thread2.start();
        thread3.start();
    }

    /*
     * 同步方法
     */
    static void example03() {
        // 定义三个线程，模拟三个客户，它们的任务都是循环购买商品。
        Thread thread1 = new BuyThread3();
        thread1.setName("客户1");
        Thread thread2 = new BuyThread3();
        thread2.setName("客户2");
        Thread thread3 = new BuyThread3();
        thread3.setName("客户3");

        // 依次开启三个任务，模拟三个客户的购买行为。
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
