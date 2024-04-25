package net.bi4vmr.study;

/**
 * Name        : TestVariable
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@outlook.com
 * <p>
 * Date        : 2022-11-25 23:47
 * <p>
 * Description : 测试类 - 变量与常量。
 */
public class TestVariable {

    public static void main(String[] args) {
        example02();
    }

    /*
     * 变量
     */
    static void example01() {
        // 声明变量“姓名”
        String name = "张三";
        // 声明变量“年龄”
        int age = 20;

        System.out.print(name);
        System.out.print(age);
    }

    /*
     * 常量
     */
    static void example02() {
        // 示例：常量"PI"
        final double PI = 3.141592653;

        System.out.print(PI);
    }
}
