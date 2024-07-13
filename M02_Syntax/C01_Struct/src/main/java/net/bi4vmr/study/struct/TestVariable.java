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
     * 示例：变量。
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
     * 示例：常量。
     */
    static void example02() {
        // 示例：常量"PI"
        final double PI = 3.141592653;

        // 访问常量：将常量的值输出到控制台
        System.out.print("圆周率：" + PI);
    }
}
