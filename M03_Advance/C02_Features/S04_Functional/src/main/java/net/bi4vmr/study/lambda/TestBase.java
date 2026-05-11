package net.bi4vmr.study.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 示例代码：基本应用。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class TestBase {

    public static void main(String[] args) {
        example07();
    }


    /**
     * 示例一：将整数列表中的元素倒序排列。
     * <p>
     * 在本示例中，我们定义一个整数列表，并将其中的元素倒序排列。
     */
    static void example01() {
        // 创建测试列表
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        // 设置排序规则，将所有元素降序排列。
        list.sort(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                // 返回当前两个数值的比较结果
                return o2.compareTo(o1);
            }
        });

        // 输出排序后的结果
        System.out.println(list);
    }


    /**
     * 示例二：将整数列表中的元素倒序排列（使用Lambda表达式）。
     * <p>
     * 在本示例中，我们定义一个整数列表，并将其中的元素倒序排列。
     */
    static void example02() {
        // 创建测试列表
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        // 设置排序规则，将所有元素降序排列。
        list.sort((o1, o2) -> o2.compareTo(o1));

        // 输出排序后的结果
        System.out.println(list);
    }


    /**
     * 示例三：方法引用。
     * <p>
     * 在本示例中，我们使用方法引用简化Lambda表达式。
     */
    static void example03() {
        // 创建测试列表
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));


        // 将Lambda参数传递给 `reverse()` 方法，并返回其结果。
        list.sort((o1, o2) -> reverse(o1, o2));

        // 此时可以简化为方法引用形式： `<类名>::<方法名称>` 。
        list.sort(TestBase::reverse);

        // 如果是引用对象的方法，则需要使用 `<对象名称>::<方法名称>` 或 `this::<方法名称>` 的形式。


        // 输出排序后的结果
        System.out.println(list);
    }

    /**
     * 比较两个整数的大小，返回倒序排列的结果。
     *
     * @param a 第一个整数。
     * @param b 第二个整数。
     * @return 比较结果。
     */
    static int reverse(Integer a, Integer b) {
        return b.compareTo(a);
    }


    /**
     * 示例四：引用Lambda表达式。
     * <p>
     * 在本示例中，我们使用Lambda表达式声明线程任务，并创建多个线程执行该任务。
     */
    static void example04() {
        // 将Lambda表达式保存为函数式接口类型的变量
        Runnable task = () -> System.out.println("Thread Name: " + Thread.currentThread().getName());

        // 创建多个线程，复用同一个任务
        new Thread(task).start();
        new Thread(task).start();
    }


    /**
     * 示例五：定义数据转换接口。
     * <p>
     * 在本示例中，我们定义一个函数式接口，表示将一种类型的数据转换为另一种类型。
     *
     * @param <I> 原始类型。
     * @param <O> 转换后的类型。
     */
    @FunctionalInterface
    interface Transformer<I, O> {

        // 唯一抽象方法：转换逻辑。
        O transform(I input);
    }


    /**
     * 示例六： `this` 关键字。
     * <p>
     * 在本示例中，我们辨析Lambda表达式与匿名内部类中 `this` 关键字的区别。
     */
    static void example06() {
        new TestBase().testThis();
    }

    void testThis() {
        // 测试类实例的 `this` 引用
        System.out.println("this in test class: " + this);


        // Lambda表达式中的 `this` 指向包含它的实例，即 `TestBase` 的实例。
        Runnable lambda = () -> System.out.println("this in lambda: " + this);
        lambda.run();


        // 匿名内部类中的 `this` 指向类的实例，可以访问其属性。
        Runnable object = new Runnable() {

            // 匿名内部类可以拥有属性
            private String name = "Consumer";

            @Override
            public void run() {
                System.out.println("this in annonymous class: " + this);
                // `this` 可以访问匿名内部类的属性
                System.out.println("get name by this: " + this.name);
            }
        };
        object.run();
    }


    /**
     * 示例七：捕获外部变量。
     * <p>
     * 在本示例中，我们尝试在Lambda表达式中访问和修改外部变量，并分析限制条件。
     */
    static void example07() {
        new TestBase().testCapture();
    }

    void testCapture() {
        // 定义一个局部变量
        String s = "-";

        // 定义Lambda表达式，尝试访问和修改外部变量。
        Runnable task = () -> {
            // 允许读取外部变量
            System.out.println("读取外部变量：" + s);

            // 禁止修改外部变量，该语句无法通过编译。
            // s = "modify";
        };
    }
}
