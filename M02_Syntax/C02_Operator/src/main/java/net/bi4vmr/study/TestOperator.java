package net.bi4vmr.study;

/**
 * 测试代码：运算符号。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class TestOperator {

    public static void main(String[] args) {
        example06();
    }

    /**
     * 示例一：赋值运算符的基本应用。
     * <p>
     * 在本示例中，我们使用赋值运算符操作变量。
     */
    static void example01() {
        int a = 5;
        int b = a;

        // 使用普通表达式
        a = a + 2;
        System.out.println("a:" + a);

        // 使用"加等于"符号
        b += 2;
        System.out.println("b:" + b);
    }

    /**
     * 示例二：基本的四则运算。
     * <p>
     * 在本示例中，我们使用算术运算符进行基本的四则运算。
     */
    static void example02() {
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
     * 示例三：自增运算符的基本应用。
     * <p>
     * 在本示例中，我们使用自增运算符操作变量。
     */
    static void example03() {
        int a = 5;
        int b = 5;

        System.out.println("自增符号在前：" + (++a));
        System.out.println("自增符号在后：" + (b++));
        System.out.println("a = " + a + " ;b = " + b);
    }

    /**
     * 示例四：结果为“无穷大”的表达式。
     * <p>
     * 在本示例中，我们使用某个数除以浮点数的"0"，并观察计算结果。
     */
    static void example04() {
        // 非0正数除以0，结果为正无穷。
        double a = 100 / 0.0;
        System.out.println("100除以0.0：" + a);

        // 非0负数除以0，结果为负无穷。
        double b = -100 / 0.0;
        System.out.println("-100除以0.0：" + b);
    }

    /**
     * 示例五：理解“无穷大”的含义。
     * <p>
     * 在本示例中，我们对无穷大数值进行判等操作与类型转换。
     */
    static void example05() {
        // 比较两个正无穷值
        float x = 1 / 0.0F;
        double y = -2 / 0.0;
        System.out.println(x == y);
        System.out.println(x == Double.POSITIVE_INFINITY);

        // 将正无穷强制转换为整数
        System.out.println((int) x);
        System.out.println((long) x);
    }

    /**
     * 示例六：理解"NaN"的含义。
     * <p>
     * 在本示例中，我们列举一些结果为"NaN"的表达式，并对"NaN"数值进行判等操作。
     */
    static void example06() {
        // 浮点型0除以0结果为"NaN"
        double a = 0.0 / 0.0;
        System.out.println("a = 0.0 / 0.0 = " + a);

        // 负数的平方根结果为"NaN"
        double b = Math.sqrt(-2);
        System.out.println("b = sqrt(-2) = " + b);

        // 比较两个NaN值是否相等
        System.out.println("a == a ? " + (a == a));
        System.out.println("a == b ? " + (a == b));
        System.out.println("a is NaN ? " + Double.isNaN(a));
    }

    /**
     * 示例七：比较运算符的基本应用。
     * <p>
     * 在本示例中，我们使用比较运算符操作变量。
     */
    static void example07() {
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

    /**
     * 示例八：普通运算与短路运算的区别。
     * <p>
     * 在本示例中，我们比较普通运算与短路运算的区别。
     */
    static void example08() {
        int a = 5;

        boolean b1 = false && (a++) == 6;
        System.out.println("a = " + a);

        boolean b2 = false & (a++) == 6;
        System.out.println("a = " + a);
    }

    /**
     * 示例九：位运算符的基本应用。
     * <p>
     * 在本示例中，我们使用位运算符进行位运算。
     */
    static void example09() {
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
     * 示例十：条件运算符的基本应用。
     * <p>
     * 在本示例中，我们定义两个变量 `a` 与 `b` ，如果 `a` 大于 `b` 则将 `a` 的100倍赋值给变量 `c` ；反之将 `b` 的100倍赋值给 `c` 。
     */
    static void example10_1() {
        int a = 1;
        int b = 2;

        int c = (a >= b) ? (a * 100) : (b * 100);
        System.out.println("c = " + c);
    }

    /**
     * 示例十：条件运算符的等价写法。
     */
    static void example10_2() {
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
