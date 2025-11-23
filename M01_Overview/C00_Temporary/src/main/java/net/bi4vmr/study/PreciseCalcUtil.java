package net.bi4vmr.study;

import java.math.BigDecimal;

/**
 * 数学计算工具
 *
 * @author BI4VMR
 * @version 1.0
 */
public class PreciseCalcUtil {

    //除法运算默认精度
    private static final int DIVIDE_SCALE = 10;

    /**
     * 精确的浮点加法运算
     *
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数之和
     */
    public static double accurateAdd(double v1, double v2) {
        BigDecimal d1 = new BigDecimal(String.valueOf(v1));
        BigDecimal d2 = new BigDecimal(String.valueOf(v2));
        return d1.add(d2).doubleValue();
    }

    /**
     * 精确的浮点减法运算
     *
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的之差
     */
    public static double accurateSub(double v1, double v2) {
        BigDecimal d1 = new BigDecimal(String.valueOf(v1));
        BigDecimal d2 = new BigDecimal(String.valueOf(v2));
        return d1.subtract(d2).doubleValue();
    }

    /**
     * 精确的浮点乘法运算
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数之积
     */
    public static double accurateMtp(double v1, double v2) {
        BigDecimal d1 = new BigDecimal(String.valueOf(v1));
        BigDecimal d2 = new BigDecimal(String.valueOf(v2));
        return d1.multiply(d2).doubleValue();
    }

    /**
     * 精确的浮点乘法运算
     * <p>
     * 精确到小数点后指定位数，其余数字四舍五入。
     *
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数之商
     */
    public static double accurateDiv(double v1, double v2) {
        //使用默认精度计算
        return accurateDiv(v1, v2, DIVIDE_SCALE);
    }

    /**
     * 精确的浮点乘法运算
     * <p>
     * 精确到小数点后指定位数，其余数字四舍五入。
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 精确度，表示精确到小数点以后第scale位。
     * @return 两个参数之商
     */
    public static double accurateDiv(double v1, double v2, int scale) {
        //输入参数不合法时，使用默认精度计算。
        if (scale < 0) {
            scale = DIVIDE_SCALE;
        }

        BigDecimal d1 = new BigDecimal(String.valueOf(v1));
        BigDecimal d2 = new BigDecimal(String.valueOf(v2));
        return d1.divide(d2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
