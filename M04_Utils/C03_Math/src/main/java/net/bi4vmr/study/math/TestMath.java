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
        example02();
    }

    /**
     * 示例一：访问Math类的静态常量。
     * <p>
     * 在本示例中，我们访问Math类的静态常量。
     */
    static void example01() {
        System.out.println("π: " + Math.PI);
        System.out.println("e: " + Math.E);
    }

    /**
     * 示例二：Math类的基本应用。
     * <p>
     * 在本示例中，我们使用Math类进行科学运算。
     */
    static void example02() {
        // 绝对值
        int a = Math.abs(-100);
        System.out.println("'-100'的绝对值：" + a);

        // 三角函数
        double b = Math.sin(90);
        System.out.println("'sin(90)'的绝对值：" + b);

        // 生成随机数(0, 1]
        double c = Math.random();
        System.out.println("生成随机数：" + c);
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
