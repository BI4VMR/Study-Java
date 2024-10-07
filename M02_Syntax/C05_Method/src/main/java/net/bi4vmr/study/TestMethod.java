package net.bi4vmr.study;

import java.util.*;

/**
 * 测试代码：方法。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class TestMethod {

    public static void main(String[] args) {
        example05();
    }

    /**
     * 定义方法：计算两数之和。
     *
     * @param a 运算数A。
     * @param b 运算数B。
     */
    static void plus(int a, int b) {
        int sum = a + b;
        System.out.println(a + " + " + b + " = " + sum);
    }

    /**
     * 示例一：参数的基本应用。
     * <p>
     * 在本示例中，我们定义一个方法，接收两个整型参数，功能是将它们的值累加求和，并将结果输出到控制台上。
     */
    static void example01() {
        int x = 8;
        int y = 6;

        // 调用带参数无返回值方法，依次传入各参数。
        plus(x, y);
    }

    /**
     * 改变基本类型与引用类型的参数值。
     * <p>
     * 测试改变基本类型与引用类型的参数值，是否会影响原始参数的值。
     *
     * @param a 基本类型参数。
     * @param b 引用类型参数。
     */
    static void parameterType(int a, StringBuilder b) {
        a = a + 1;
        b.append(" HelloWorld!");
        System.out.println("[参数值] a: " + a + " b: " + b);
    }

    /**
     * 示例二：基本与引用数据类型参数的区别。
     * <p>
     * 在本示例中，我们定义一个方法，分别接收基本数据类型与引用数据类型参数，然后在方法内部改变它们，最后在方法外部访问它们。
     */
    static void example02() {
        // 基本数据类型
        int x = 8;
        // 引用数据类型
        StringBuilder y = new StringBuilder("Test");
        System.out.println("[操作前] x: " + x + " y: " + y);

        // 调用测试方法，在其中改变参数的值。
        parameterType(x, y);
        System.out.println("[操作后] x: " + x + " y: " + y);
    }

    /**
     * 计算两数之和。
     *
     * @param a 运算数A。
     * @param b 运算数B。
     * @return 两数之和。
     */
    static int plus2(int a, int b) {
        int sum = a + b;
        return sum;
    }

    /**
     * 示例三：返回值的基本应用。
     * <p>
     * 在本示例中，我们对前文“示例一”中的 `plus()` 方法进行修改，通过返回值汇报计算结果。
     */
    static void example03() {
        int x = 8;
        int y = 6;

        // 调用带返回值方法"plus2()"，使用一个变量接收返回值。
        int summary = plus2(x, y);
        // 将接收到的参数显示在控制台上
        System.out.println("两数之和：" + summary);
    }

    /**
     * 计算三数之和。
     *
     * @param a 运算数A。
     * @param b 运算数B。
     * @param c 运算数C。
     * @return 三数之和。
     */
    static int plus2(int a, int b, int c) {
        int sum = a + b + c;
        return sum;
    }


    /**
     * 示例四：方法的重载。
     * <p>
     * 在本示例中，我们对前文“示例三”进行扩充，新增计算三个数之和的方法。
     */
    static void example04() {
        int x = 8;
        int y = 6;
        int z = 10;

        // 调用具有两个参数的"plus()"方法
        int sum1 = plus2(x, y);
        System.out.println("两数之和：" + sum1);
        // 调用具有三个参数的"plus()"方法
        int sum2 = plus2(x, y, z);
        System.out.println("三数之和：" + sum2);
    }

    /**
     * 计算若干整数之和。
     *
     * @param args 运算数。
     * @return 所有运算数之和。
     */
    static long calculateSum(Integer... args) {
        // 可变参数本质上是数组
        Integer[] type = args;
        System.out.println("输入参数为：" + Arrays.toString(type));

        long sum = 0;
        // 遍历可变参数
        for (Integer arg : args) {
            // 累加求和
            sum += arg;
        }

        return sum;
    }

    /**
     * 示例五：可变参数的基本应用。
     * <p>
     * 在本示例中，我们对前文“示例四”进行优化，通过可变参数实现整数求和方法。
     */
    static void example05() {
        // 传递可变参数（通常用法）
        long result1 = calculateSum(1, 2, 3);
        System.out.println("Summary is " + result1 + ".");

        // 传递可变参数（使用数组）
        long result2 = calculateSum(new Integer[]{1, 2, 3});
        System.out.println("Summary is " + result2 + ".");

        // 传递可变参数（0个参数）
        long result3 = calculateSum();
        System.out.println("Summary is " + result3 + ".");
    }

    /**
     * 回调接口。
     */
    interface Callback {

        /**
         * 回调方法。
         *
         * @param result  执行结果。
         * @param message 消息。
         */
        void onResult(boolean result, String message);
    }

    /**
     * 保存文件。
     *
     * @param callback 回调接口实现。
     */
    static void saveFile(Callback callback) {
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                // 异步操作完成，调用回调接口实现中的方法，通知调用者。
                callback.onResult(true, "OK.");
                // 清除Timer，终止当前程序。
                System.gc();
            }
        };
        // 延迟2秒再执行上述任务，模拟异步操作。
        new Timer().schedule(task, 2000L);
    }

    /**
     * 示例六：回调方法的基本应用。
     * <p>
     * 在本示例中，我们定义一个接口，将其作为方法的参数，并在方法中回调接口的方法。
     */
    static void example06() {
        System.out.println("Test method start.");
        // 调用回调方法，传入Callback接口的实现。
        saveFile(new Callback() {

            @Override
            public void onResult(boolean result, String message) {
                // 回调被触发后的动作
                System.out.println("Callback method was triggered. Result: " + result + ", Message: " + message);
            }
        });
        System.out.println("Test method end.");
    }

    /**
     * 示例七：管理多个回调实现。
     * <p>
     * 在本示例中，我们编写一个FileHelper类，使其能够管理多个回调。
     */
    static class FileHelper {

        // 声明集合，存储调用者传入的回调实现对象。
        private final List<Callback> callbacks = new ArrayList<>();

        // 回调接口
        interface Callback {
            void onResult(boolean result, String message);
        }

        // 注册回调
        public void addCallback(Callback cb) {
            // 防止多线程调用导致集合不一致
            synchronized (callbacks) {
                // 防止重复注册回调
                if (!callbacks.contains(cb)) {
                    callbacks.add(cb);
                }
            }
        }

        // 注销回调
        public void removeCallback(Callback cb) {
            synchronized (callbacks) {
                callbacks.remove(cb);
            }
        }

        // 通知执行结果
        private void notifyResult(boolean result, String message) {
            // 遍历回调实现集合，通知所有调用者。
            for (Callback item : callbacks) {
                item.onResult(result, message);
            }
        }

        // 业务逻辑
        public void saveFile() {
            TimerTask task = new TimerTask() {

                @Override
                public void run() {
                    notifyResult(true, "OK");
                    // 清除Timer，终止当前程序。
                    System.gc();
                }
            };
            // 延迟2秒再执行上述任务，模拟异步操作。
            new Timer().schedule(task, 2000L);
        }
    }
}
