package net.bi4vmr.study.base;

/**
 * Name        : InitBlockDemo
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@qq.com
 * <p>
 * Date        : 2022-12-03 19:44
 * <p>
 * Description : 测试类：初始化块。
 */
public class TestInitBlock {

    static int a;
    int b;

    // 静态初始化块，用于初始化静态成员变量。
    static {
        System.out.println("静态初始化块执行了...");
        a = 100;
    }

    // 初始化块，用于初始化静态成员变量。
    {
        System.out.println("初始化块执行了...");
        b = 200;
    }

    // 构造方法
    public TestInitBlock() {
        System.out.println("构造方法执行了...");
    }

    // 测试方法
    public static void main(String[] args) {
        // 连续构建两个本类的对象，观察各模块的执行次数。
        System.out.println("开始创建第一个对象：");
        new TestInitBlock();
        System.out.println();
        System.out.println("开始创建第二个对象：");
        new TestInitBlock();
    }
}
