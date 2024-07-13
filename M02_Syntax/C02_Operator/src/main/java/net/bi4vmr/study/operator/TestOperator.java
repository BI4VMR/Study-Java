package net.bi4vmr.study.operator;

/**
 * 测试代码 - 运算符。
 *
 * @author bi4vmr@outlook.com
 */
public class TestOperator {

    public static void main(String[] args) {
        example08();
    }

    /**
     * 示例：四则运算。
     */
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

    /**
     * 示例：自增与自减运算。
     */
    static void example02() {
        int a = 5;
        int b = 5;

        System.out.println("自增符号在前：" + (++a));
        System.out.println("自增符号在后：" + (b++));
        System.out.println("a = " + a + " ;b = " + b);
    }

    /**
     * 示例：自增与自减运算。
     */
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

    static void example06() {
        int a = 0x25;        // 25H	-> 0010 0101B
        int b = 0xCE;        // CEH	-> 1100 1110B
        int m = a & b;        // 4D	-> 0000 0100B
        int n = a | b;        // 239D	-> 1110 1111B
        int o = ~a;            // -38D	-> 1101 1010B
        int p = a ^ b;        // 235D	-> 1110 1011B
        int x = a << 2;        // 148D	-> 1001 0100B
        int y = a >> 2;        // 9D	-> 0000 1001B

        System.out.println("a    = " + a);
        System.out.println("b    = " + b);
        System.out.println("a&b  = " + m);
        System.out.println("a|b  = " + n);
        System.out.println("~a   = " + o);
        System.out.println("a^b  = " + p);
        System.out.println("a<<2 = " + x);
        System.out.println("a>>2 = " + y);
    }

    /**
     * 示例：条件运算符。
     */
    static void example07() {
        int a = 1;
        int b = 2;

        int c = (a >= b) ? (a * 100) : (b * 100);
        System.out.println("c = " + c);
    }

    /**
     * 示例：条件运算符。
     */
    static void example08() {
        int a = 1;
        int b = 2;
        int c;

        if (a >= b) {
            c = a * 100;
        } else {
            c = b * 100;
        }
        System.out.println("c = " + c);
    }
}
