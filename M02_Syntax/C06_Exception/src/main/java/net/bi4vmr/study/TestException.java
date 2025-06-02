package net.bi4vmr.study;

import net.bi4vmr.study.exception.CustomException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 测试代码：异常。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class TestException {

    public static void main(String[] args) {
        example05_2();
    }

    /**
     * 示例一：异常捕获语句的基本应用。
     * <p>
     * 在本示例中，我们将两个整数相除的语句放置在 `try-catch-finally` 语句中，使用不同的值多次运行程序，对比程序的行为。
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

    /**
     * 示例二：在控制台上显示异常详情。
     * <p>
     * 在本示例中，我们故意制造一个异常，捕获异常后使用 `printStackTrace()` 方法将详情输出到控制台上。
     */
    static void example02() {
        try {
            int i = 10 / 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 示例三：捕获多种类型的异常。
     * <p>
     * 在本示例中，我们使用多个 `catch` 块，分别捕获不同类型的异常。
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

    /**
     * 示例四：异常与 `return` 语句。
     * <p>
     * 在本示例中，我们故意制造一个异常，然后在 `try-catch-finally` 语句中添加 `return` 语句，测试跳转规则。
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

    /**
     * 示例五： `try-with-resources` 语法的基本应用。
     * <p>
     * 在本示例中，我们从控制台读取一行文本，并将其写入文件。
     */
    static void example05_1() {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter writer = null;
        try {
            System.out.println("请输入文本，按回车键确认：");
            String text = scanner.nextLine();
            writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write(text);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 手动释放资源
            scanner.close();
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 示例五： `try-with-resources` 语法的基本应用。
     * <p>
     * 在本示例中，我们从控制台读取一行文本，并将其写入文件。
     */
    static void example05_2() {
        // 在 `try` 后的括号内声明资源变量
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
             Scanner scanner = new Scanner(System.in)
        ) {
            System.out.println("请输入文本，按回车键确认：");
            String text = scanner.nextLine();
            writer.write(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 上述代码执行完毕后，所有的资源都会被释放，先声明的后被释放。
    }

    /**
     * 示例六：主动抛出异常。
     * <p>
     * 在本示例中，我们编写一个方法用于计算整数角度的正切值，当输入值为90度的倍数时，向调用者抛出算术异常。
     */
    static void example06() {
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

    /**
     * 示例七：定义并使用自定义异常。
     * <p>
     * 在本示例中，我们创建一个自定义异常类，在测试方法中抛出并捕获该异常。
     */
    static void example07() {
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

    /**
     * 示例八：异常链的基本应用。
     * <p>
     * 在本示例中，我们故意制造一个算术异常，并将其捕获后转为前文“示例七”中的CustomException，再向调用者抛出。
     */
    static void example08() {
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
            CustomException customException = new CustomException(99, "自定义异常");
            // 使用 `initCause()` 方法指明引起CustomException的原始异常
            customException.initCause(ae);
            // 抛出新建的CustomException
            throw customException;
        }
    }
}
