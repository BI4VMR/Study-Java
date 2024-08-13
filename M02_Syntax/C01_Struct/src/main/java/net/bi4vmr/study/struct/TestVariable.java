package net.bi4vmr.study.struct;

/**
 * 测试代码 - 变量。
 *
 * @author bi4vmr@outlook.com
 */
public class TestVariable {

    public static void main(String[] args) {
        example02();
    }

    /**
     * 示例：变量的基本应用。
     * <p>
     * 在本示例中，我们定义一些变量，并访问它们。
     */
    static void example01() {
        // 声明变量“姓名”
        String name = "张三";
        // 声明变量“年龄”
        int age = 20;

        // 访问变量：将变量的值输出到控制台
        System.out.println("姓名：" + name);
        System.out.println("年龄：" + age);
    }

    /**
     * 示例：常量的基本应用。
     * <p>
     * 在本示例中，我们定义一些常量，并访问它们。
     */
    static void example02() {
        // 示例：常量"PI"
        final double PI = 3.141592653;

        // 访问常量：将常量的值输出到控制台
        System.out.print("圆周率：" + PI);
    }

    /**
     * 示例：变量的作用域。
     * <p>
     * 在本示例中，我们定义一些变量，并在不同的作用域中访问它们。
     */
    static void example03() {
        int i = 1;

        // 定义一个“块”
        {
            int x = 5;
            // 块的内部可以访问自己的变量与父级块的变量
            System.out.println("i:" + i + "; x:" + x);
        }
        // 块的外部不能访问块内部的变量
        System.out.println("i:" + i + "; x:can not be accessed!");
    }
}
