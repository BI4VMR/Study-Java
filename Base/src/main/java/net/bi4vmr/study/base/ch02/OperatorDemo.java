package net.bi4vmr.study.base.ch02;

/**
 * Name        : OperatorDemo
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@qq.com
 * <p>
 * Date        : 2022-11-27 13:55
 * <p>
 * Description : 运算符示例。
 */
public class OperatorDemo {

    public static void main(String[] args) {
        example05();
    }

    static void example01() {
        int a = 5 + 12;
        int b = 25 - 10;
        int c = 3 * 8;
        int d = 24 / 7;
        int e = 24 % 7;
        double f = 24.0 / 7;

        System.out.println("5 + 12 = " + a);
        System.out.println("25 - 10 = " + b);
        System.out.println("3 * 8 = " + c);
        System.out.println("24 / 7 = " + d);
        System.out.println("24 % 7 = " + e);
        System.out.println("24.0 % 7 = " + f);
    }

    static void example02() {
        int a = 5;
        int b = 5;

        System.out.println("自增符号在前：" + (++a));
        System.out.println("自增符号在后：" + (b++));
        System.out.println("a = " + a + " ;b = " + b);
    }

    static void example03() {
        int a = 5;
        int b = a;

        // 使用普通表达式
        a = a + 2;
        System.out.println("a:" + a);

        // 使用"加等于"符号
        b += 2;
        System.out.println("b:" + b);
    }

    static void example04() {
        int a = 5;
        int b = 1;

        System.out.println("a>b: " + (a > b));
        System.out.println("a<b: " + (a < b));

        String s1 = "Test";
        String s2 = "Test";
        String s3 = new String("Test");
        System.out.println("s1内容是否与s2相同：" + (s1 == s2));
        System.out.println("s1内容是否与s3相同：" + (s1 == s3));
    }

    static void example05() {
        int a = 5;

        boolean b1 = false && (a++) == 6;
        System.out.println("a = " + a);

        boolean b2 = false & (a++) == 6;
        System.out.println("a = " + a);
    }
}
