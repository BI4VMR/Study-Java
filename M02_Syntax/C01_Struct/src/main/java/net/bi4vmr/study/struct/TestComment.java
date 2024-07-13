package net.bi4vmr.study.struct;

import java.math.BigDecimal;

/**
 * 测试代码 - Java文档注释。
 *
 * @author bi4vmr@outlook.com
 * @version 1.0
 */
public class TestComment {

    /**
     * 计算两数之和
     * <p>
     * 功能类似于{@link BigDecimal#add(BigDecimal)}。
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
