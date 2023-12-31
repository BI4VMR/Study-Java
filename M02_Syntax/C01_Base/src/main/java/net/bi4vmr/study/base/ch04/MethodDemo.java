package net.bi4vmr.study.base.ch04;

/**
 * Name        : MethodDemo
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@qq.com
 * <p>
 * Date        : 2022-11-30 19:55
 * <p>
 * Description : 方法示例。
 */
public class MethodDemo {

    public static void main(String[] args) {
        example02();
    }

    /*
     * 参数的简单使用。
     */
    static void example01() {
        int x = 8;
        int y = 6;

        // 调用带参数无返回值方法，依次传入各参数。
        plus(x, y);
    }

    /**
     * Name        : 计算两数之和
     * <p>
     * Description : 计算两数之和并将结果显示在控制台上。
     *
     * @param a 被加数
     * @param b 加数
     */
    static void plus(int a, int b) {
        int sum = a + b;
        System.out.println(a + "+" + b + "=" + sum);
    }

    /*
     * 基本类型与引用类型参数的区别。
     */
    static void example02() {
        // 基本数据类型
        int x = 8;
        // 引用数据类型
        StringBuilder y = new StringBuilder("Test");
        System.out.println("[操作前] x: " + x + " y: " + y);

        // 调用测试方法，在其中改变参数的值。
        parameterType(x, y);
        System.out.println("[操作后] x: " + x + " y: " + y);
    }

    /**
     * Name        : 改变基本类型与引用类型的参数值
     * <p>
     * Description : 测试改变基本类型与引用类型的参数值，是否会影响原始参数的值。
     *
     * @param a 基本类型参数
     * @param b 引用类型参数
     */
    static void parameterType(int a, StringBuilder b) {
        a = a + 1;
        b.append(" HelloWorld!");
        System.out.println("[参数值] a: " + a + " b: " + b);
    }

    /*
     * 返回值的简单使用。
     */
    static void example03() {
        int x = 8;
        int y = 6;

        // 调用带返回值方法，使用一个变量接收返回值。
        int sum = plus2(x, y);
        // 将接收到的参数显示在控制台上
        System.out.println("两数之和：" + sum);
    }

    /**
     * Name        : 计算两数之和
     * <p>
     * Description : 计算两数之和并将结果显示在控制台上。
     *
     * @param a 被加数
     * @param b 加数
     * @return 两数之和
     */
    static int plus2(int a, int b) {
        int sum = a + b;
        return sum;
    }

    /*
     * 方法的重载
     */
    static void example04() {
        int x = 8;
        int y = 6;
        int z = 10;

        // 调用具有两个参数的"plus()"方法
        plus(x, y);
        // 调用具有三个参数的"plus()"方法
        int sum = plus(x, y, z);
        System.out.println("三个数之和：" + sum);
    }

    static int plus(int a, int b, int c) {
        int sum = a + b + c;
        return sum;
    }
}
