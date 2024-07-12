package net.bi4vmr.study;

/**
 * 测试类 - Java文档注释
 *
 * @author BI4VMR
 */
public class TestVariable {

    public static void main(String[] args) {
        example02();
    }

    /*
     * 示例：变量
     */
    static void example01() {
        // 声明变量“姓名”
        String name = "张三";
        // 声明变量“年龄”
        int age = 20;

        // 使用变量：将变量的值输出到控制台
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
