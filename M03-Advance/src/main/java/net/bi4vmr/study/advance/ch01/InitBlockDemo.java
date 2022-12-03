package net.bi4vmr.study.advance.ch01;

/**
 * Name        : InitBlockDemo
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@qq.com
 * <p>
 * Date        : 2022-12-03 19:44
 * <p>
 * Description : 初始化块示例
 */
public class InitBlockDemo {

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
    public InitBlockDemo() {
        System.out.println("构造方法执行了...");
    }

    // 测试方法
    public static void main(String[] args) {
        // 连续构建两个本类的对象，观察各模块的执行次数。
        new InitBlockDemo();
        new InitBlockDemo();
    }
}
