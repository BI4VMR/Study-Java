package net.bi4vmr.study.base.ch01;

import java.math.BigDecimal;

/**
 * Name        : JavadocDemo
 * <p>
 * Description : Java文档注释示例。
 *
 * @author BI4VMR
 * @version 1.0
 */
public class JavadocDemo {

    /**
     * Name        : 计算两数之和
     * <p>
     * Description : 计算两数之和，功能类似于{@link java.math.BigDecimal#add(BigDecimal)}。
     *
     * @param a 运算数1
     * @param b 运算数2
     * @return 两个运算数的和。
     */
    public static int sum(int a, int b) {
        // 返回两个参数之和
        return a + b;
    }
}
