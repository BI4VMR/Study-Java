package net.bi4vmr.study.oop.base;

/**
 * 测试代码：变量的作用域。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class TestScope {

    // 声明全局变量
    short a;
    int b;
    float c;
    double d;
    boolean e;
    String f;
    Object g;

    public static void main(String[] args) {
        example02();
    }

    /**
     * 示例二：全局变量与默认值。
     * <p>
     * 在本示例中，我们定义一个测试类并声明若干全局变量，并在控制台上输出它们的值。
     */
    static void example02() {
        // 创建测试类的对象
        TestScope test = new TestScope();
        // 访问全局变量
        System.out.println("a: " + test.a);
        System.out.println("b: " + test.b);
        System.out.println("c: " + test.c);
        System.out.println("d: " + test.d);
        System.out.println("e: " + test.e);
        System.out.println("f: " + test.f);
        System.out.println("g: " + test.g);
    }

    /**
     * 示例三：局部变量。
     * <p>
     * 在本示例中，我们在一个方法内定义变量，并尝试在另一个方法中访问它。
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
