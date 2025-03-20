package net.bi4vmr.study;

/**
 * 数学运算工具类。
 *
 * @author BI4VMR@outlook.com
 * @since 1.0.0
 */
public class MathUtil {

    public static Integer divide(int a, int b) {
        if (b == 0) {
            return null;
        } else {
            return a / b;
        }
    }
}
