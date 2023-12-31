package net.bi4vmr.study.base;

/**
 * Name        : TestScope
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@outlook.com
 * <p>
 * Date        : 2023-12-29 22:31
 * <p>
 * Description : 测试类：变量的作用域。
 */
public class TestScope {

    short a;
    int b;
    float c;
    double d;
    boolean e;
    String f;
    Object g;

    public static void main(String[] args) {
        example01();
    }

    /*
     * 示例：全局变量
     */
    static void example01() {
        TestScope test = new TestScope();
        System.out.println("a: " + test.a);
        System.out.println("b: " + test.b);
        System.out.println("c: " + test.c);
        System.out.println("d: " + test.d);
        System.out.println("e: " + test.e);
        System.out.println("f: " + test.f);
        System.out.println("g: " + test.g);
    }

    /*
     * 示例：局部变量
     */
    public void function1() {
        // 声明局部变量"x"
        int x = 0;
    }

    public void function2() {
        // 此方法无法访问"function1()"方法中的局部变量"x"，编译器会提示错误。
        // System.out.println(x);
    }
}
