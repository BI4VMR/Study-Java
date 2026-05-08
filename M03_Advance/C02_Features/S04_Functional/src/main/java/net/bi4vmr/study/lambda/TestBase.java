package net.bi4vmr.study.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * 示例代码：基本应用。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class TestBase {

    public static void main(String[] args) {
        example03();
    }


    /**
     * 示例一：将整数列表中的元素倒序排列。
     * <p>
     * 在本示例中，我们定义一个整数列表，并将其中的元素倒序排列。
     */
    static void example01() {
        // 创建测试列表
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);


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
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);


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
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);


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
     * 在本示例中，我们使用方法引用简化Lambda表达式。
     */
    static void example04() {
        // 将Lambda表达式保存为函数式接口类型的变量
        Runnable task = () -> System.out.println("Thread is running. Name: " + Thread.currentThread().getName());


        // 创建多个线程，复用同一个任务
        Thread thread1 = new Thread(task);
        thread1.start();
        Thread thread2 = new Thread(task);
        thread2.start();
    }


    /**
     * 示例五：定义数据转换接口。
     * <p>
     * 在本示例中，我们定义一个函数式接口 `Transformer`，将一种类型的数据转换为另一种类型。
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
     * 在本示例中，我们使用方法引用简化Lambda表达式。
     */
    static void example06() {
        new TestBase().test();
    }

    void test() {
        // Lambda表达式中的 `this` 关键字指向包含它的实例，即 `TestBase` 的实例。
        Consumer<String> c = s -> System.out.println(this);
        c.accept("Hello, World!");

        Consumer<String> c2 = new Consumer<>() {

            // 匿名内部类可以拥有属性
            private String name = "Consumer";

            @Override
            public void accept(String s) {
                // `this` 指向匿名内部类实例，可以访问其属性。
                System.out.println(this.name);
            }
        };
        c2.accept("Hello, World!");
    }
}
