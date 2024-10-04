package net.bi4vmr.study.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 测试类：概述。
 *
 * @author BI4VMR@outlook.com
 * @since 1.0.0
 */
public class TestMath {

    public static void main(String[] args) {
        example07();
    }

    static void example01() {
        System.out.println("π: " + Math.PI);
        System.out.println("e: " + Math.E);
    }

    static void example02() {
        // 非0正数除以0，结果为正无穷。
        double a = 100 / 0.0;
        System.out.println("100除以0.0：" + a);

        // 非0负数除以0，结果为负无穷。
        double b = -100 / 0.0;
        System.out.println("-100除以0.0：" + b);
    }

    static void example03() {
        // 比较两个正无穷值
        float x = 1 / 0.0F;
        double y = 2 / 0.0;
        System.out.println(x == y);
        System.out.println(x == Double.POSITIVE_INFINITY);

        // 将正无穷强制转换为整数
        System.out.println((int) x);
        System.out.println((long) x);
    }

    static void example04() {
        // 浮点型0除以0结果为"NaN"
        double a = 0.0 / 0.0;
        System.out.println(a);

        // 负数的平方根结果为"NaN"
        double b = Math.sqrt(-2);
        System.out.println(b);

        // 比较两个NaN值是否相等
        System.out.println(a == a);
        System.out.println(a == b);
        System.out.println(Double.isNaN(a));
    }

    /**
     * 使用正确的方式初始化BigDecimal对象。
     */
    static void example05() {
        // 将"0.1"使用BigDecimal对象表示
        float a = 0.1F;
        BigDecimal decimal1 = new BigDecimal(a);
        BigDecimal decimal2 = new BigDecimal(String.valueOf(a));
        System.out.println(decimal1);
        System.out.println(decimal2);
    }

    /**
     * 尝试使用BigDecimal进行基本的四则运算。
     */
    static void example06() {
        BigDecimal a = new BigDecimal("0.2");
        BigDecimal b = new BigDecimal("0.5");
        System.out.println("a+b=" + a.add(b));
        System.out.println("a-b=" + a.subtract(b));
        System.out.println("a*b=" + a.multiply(b));
        System.out.println("a/b=" + a.divide(b, RoundingMode.UP));
    }

    static void example07() {
        BigDecimal a = new BigDecimal("0.2");
        BigDecimal b = new BigDecimal("0.5");
        BigDecimal c = new BigDecimal("-0.4");
        System.out.println("a<b:" + a.compareTo(b));
        System.out.println("a>c:" + a.compareTo(c));
        System.out.println("a=a:" + a.compareTo(a));
    }
}
