package net.bi4vmr.study;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Name        : ConsoleDemo
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@qq.com
 * <p>
 * Date        : 2022-11-30 22:56
 * <p>
 * Description : 控制台交互示例。
 */
public class TestConsole {

    public static void main(String[] args) {
        example05();
    }

    /*
     * 从控制台输入两个数字，并将它们的和输出到控制台上。
     */
    static void example01() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("请输入第一个数字，按回车确认：");
            double num1 = scanner.nextDouble();
            System.out.println("请输入第二个数字，按回车确认：");
            double num2 = scanner.nextDouble();
            System.out.print(num1 + " + " + num2 + " = " + (num1 + num2));
        } catch (InputMismatchException e) {
            System.err.println("输入参数格式错误，请重新输入。");
            // 遇到错误时，调用自身，重启程序。
            example01();
        } finally {
            // 释放资源
            scanner.close();
        }
    }

    /*
     * 尝试使用"print()"方法输出数值与文本信息。
     */
    static void example02() {
        int i = 100;
        String s = "Hello";

        // 输出整型值
        System.out.println(i);
        // 输出字符串
        System.out.println(s);
        // 输出组合后的字符串
        System.out.println("i = " + i);
    }

    /*
     * 尝试使用格式化输出方法向控制台输出文本信息。
     */
    static void example03() {
        int i = 127;
        char c = 65;
        String s = "ABC";

        // 将i输出为十进制
        System.out.printf("%d ", i);
        // 将i输出为八进制
        System.out.printf("%o ", i);
        // 将i输出为十六进制
        System.out.printf("%x ", i);
        // 将i输出为十六进制，并附加0x前缀。
        System.out.printf("%#x ", i);
        // 换行
        System.out.printf("%n");
        // 输入多个参数
        System.out.printf("i = %d; c = %c; s = %s", i, c, s);
    }

    /*
     * 尝试使用格式化输出控制小数的位数。
     */
    static void example04() {
        double d = 12.3456789;

        // 默认情况下保留6位小数
        System.out.printf("%f", d);
        System.out.println();

        // 保留两位小数
        System.out.printf("%.2f", d);
        System.out.println();

        // 保留两位后长度为5，所以左侧补一个空格
        System.out.printf("%6.2f", d);
    }

    /*
     * 尝试使用制表符和换行符输入三行四列的字母表。
     */
    static void example05() {
        String s = "A\tB\tC\tD\nE\tF\tG\tH\nI\tJ\tK\tL";
        System.out.println(s);
    }
}
