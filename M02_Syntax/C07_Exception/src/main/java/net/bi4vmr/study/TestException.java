package net.bi4vmr.study;

/**
 * Name        : ExceptionDemo
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@qq.com
 * <p>
 * Date        : 2022-11-24 22:51
 * <p>
 * Description : 异常的捕获与处理示例。
 */
public class TestException {

    public static void main(String[] args) {
        example07();
    }

    /*
     * 示例：异常的捕获与处理
     */
    static void example01() {
        try {
            int i = 10 / 0;
            System.out.println("i=" + i);
        } catch (Exception e) {
            System.out.println("发生异常！");
        } finally {
            System.out.println("善后工作完成！");
        }
        System.out.println("整个程序已结束！");
    }

    /*
     * 示例：获取异常的详细信息
     */
    static void example02() {
        try {
            int i = 10 / 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * 示例：捕获多种类型的异常
     */
    static void example03() {
        try {
            int i = 10 / 0;
            System.out.println("i=" + i);
        } catch (ArithmeticException ae) {
            System.out.println("除数不能为0！");
        } catch (Exception e) {
            System.out.println("其它错误。");
        }
    }

    /*
     * 示例：异常处理中的返回语句
     */
    static void example04() {
        String result = returnInTryCatch();
        System.out.println(result);
    }

    static String returnInTryCatch() {
        try {
            int i = 10 / 0;
            // 正常执行完毕的返回值
            return "try块中的return生效了。";
        } catch (Exception e) {
            // 出现异常情况的返回值
            return "catch块中的return生效了。";
        } finally {
            return "finally块中的return生效了。";
        }
    }

    /*
     * 示例：主动抛出异常
     */
    static void example05() {
        try {
            System.out.println("tan(45) = " + tan(45));
            System.out.println("tan(90) = " + tan(90));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static double tan(int deg) throws ArithmeticException {
        if (deg % 90 == 0) {
            throw new ArithmeticException();
        } else {
            return Math.tan(Math.toRadians(deg));
        }
    }

    /*
     * 示例：自定义异常
     */
    static void example06() {
        try {
            raiseException();
        } catch (CustomException e) {
            System.out.println("遇到异常：" + e.getMessage());
            System.out.println("错误码：" + e.getCode());
        }
    }

    private static void raiseException() throws CustomException {
        throw new CustomException(100, "自定义异常");
    }

    /*
     * 示例：异常链
     */
    static void example07() {
        try {
            convertException();
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }

    private static void convertException() throws CustomException {
        try {
            int i = 10 / 0;
        } catch (ArithmeticException ae) {
            System.out.println("捕获算术异常，将其转换为自定义异常再向上层抛出。");
            CustomException customException = new CustomException(99, ae.getMessage());
            // 使用"initCause()"方法指明引起CustomException的原始异常
            customException.initCause(ae);
            // 抛出新建的CustomException
            throw customException;
        }
    }
}
