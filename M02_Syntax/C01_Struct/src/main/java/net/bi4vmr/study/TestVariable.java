package net.bi4vmr.study;

/**
 * 测试代码：变量。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class TestVariable {

    public static void main(String[] args) {
        example03();
    }

    /**
     * 示例二：变量的基本应用。
     * <p>
     * 在本示例中，我们定义一些变量，并访问它们。
     */
    static void example02() {
        // 声明变量“姓名”
        String name = "张三";
        // 声明变量“年龄”
        int age = 20;

        // 访问变量：将变量的值输出到控制台
        System.out.println("姓名：" + name);
        System.out.println("年龄：" + age);
    }

    /**
     * 示例三：扩展转换和窄化转换。
     * <p>
     * 在本示例中，我们定义一些数值型变量，并将它们转换为其他类型。
     */
    static void example03() {
        // 定义整型变量
        int x = 128;

        // 扩展转换：将范围较小的值转换为范围较大的值
        long a = x;

        // 窄化转换：将范围较大的值转换为范围较小的值
        byte b = (byte) x;

        System.out.println("原始Int值：" + x + ", 转换为Long类型：" + a + ", 转换为Byte类型：" + b);
    }

    /**
     * 示例四：常量的基本应用。
     * <p>
     * 在本示例中，我们定义一些常量，并访问它们。
     */
    static void example04() {
        // 示例：常量"PI"
        final double PI = 3.141592653;

        // 访问常量：将常量的值输出到控制台
        System.out.print("圆周率：" + PI);
    }

    /**
     * 示例五：变量的作用域。
     * <p>
     * 在本示例中，我们定义一些变量，并在不同的作用域中访问它们。
     */
    static void example05() {
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
