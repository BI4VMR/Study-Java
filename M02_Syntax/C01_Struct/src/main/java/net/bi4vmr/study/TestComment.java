package net.bi4vmr.study;

import java.math.BigDecimal;

/**
 * Name        : TestComment
 * <p>
 * Description : 测试类 - Java文档注释。
 *
 * @author BI4VMR
 * @version 1.0
 */
public class TestComment {

    /**
     * Name        : 计算两数之和
     * <p>
     * Description : 功能类似于{@link BigDecimal#add(BigDecimal)}。
     *
     * @param a 运算数1。
     * @param b 运算数2。
     * @return 两个运算数的商。
     * @throws IllegalArgumentException 除数为"0"。
     * @see java.math.BigDecimal#add(BigDecimal)
     * @since 1.0
     */
    public static int divide(int a, int b) throws IllegalArgumentException {
        if (b == 0) {
            throw new IllegalArgumentException("除数不能为0！");
        }

        // 返回两个参数之商
        return a / b;
    }
}
