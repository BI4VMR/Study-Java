package net.bi4vmr.study.base;

/**
 * 数学运算工具类。
 *
 * @author BI4VMR@outlook.com
 * @since 1.0.0
 */
public class MathUtil {

    public static Integer divideSafe(int a, int b) {
        if (b == 0) {
            return null;
        } else {
            return a / b;
        }
    }

    public static int divide(int a, int b) {
        return a / b;
    }
}
