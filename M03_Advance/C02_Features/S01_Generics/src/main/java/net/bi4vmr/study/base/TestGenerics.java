package net.bi4vmr.study.base;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 示例代码：泛型。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class TestGenerics {

    public static void main(String[] args) {
        // example03();

        /* 数组是协变的 */
        // 声明String数组
        String[] array = {"A", "B", "C"};
        // Object是String的父类，因此可以将String数组赋值给Object数组。
        Object[] array2 = array;
        // 但仍不可写入非String数据，JVM会检查传入元素是否与数组匹配，并抛出ArrayStoreException异常。
        array2[0] = 100;


        /* 泛型是非协变的 */
        // 声明字符串列表
        List<String> list = new ArrayList<>();
        // Object是String的父类，但不能将List<String>赋值给List<Object>，编译器会提示错误。
        // List<Object> list2 = list;

        // 加入通配符后，泛型列表是协变的，可以将字符串列表赋值给Object列表。
        List<? extends Object> list3 = list;
        list3.get(0); // 读取元素时可以正常获取到字符串数据
        // list3.add("string"); // 编译时将会报错，无法添加元素到列表中
    }


    /**
     * 示例一：表示二维坐标。
     * <p>
     * 在本示例中，我们定义一个类表示二维坐标，允许调用者传入整数、小数等多种形式的原始数据。
     */
    static void example01() {
        // 创建实例并设置初始坐标
        Location1 location = new Location1();
        location.setXY(100, 25.1082);

        // 读取数据时需要判断具体的类型
        Object xRaw = location.getX();
        if (xRaw instanceof Integer) {
            // 将数据转换为具体类型再操作
            boolean resultX = ((Integer) xRaw).compareTo(100) == 0;
            System.out.println("x = 100? " + resultX);
        } else if (xRaw instanceof Double) {
            boolean resultX = ((Double) xRaw).compareTo(100.0) == 0;
            System.out.println("x = 100? " + resultX);
        } else {
            throw new IllegalArgumentException("参数类型错误！");
        }

        // 比较Y轴的数据时也需要判断类型，此处省略相关代码。


        // 随便传入一些非法数据也不会报错，直到读取数据时才能发现错误。
        location.setXY("这是一些文本", new BigDecimal("0.01"));
    }


    /**
     * 示例二：表示二维坐标（基于泛型）。
     * <p>
     * 在本示例中，我们定义一个类表示二维坐标，允许调用者传入整数、小数等多种形式的原始数据。
     */
    static void example02() {
        // 创建实例并设置初始坐标
        Location2<Integer, Double> location = new Location2<>();
        location.setXY(100, 25.1082);

        // 读取数据时无需判断类型，与创建实例时的类型一致。
        Integer x = location.getX();
        boolean resultX = x.compareTo(100) == 0;
        System.out.println("x = 100? " + resultX);

        // 比较Y轴的数据时无需判断类型，此处省略相关代码。


        // 参数类型与声明实例时的泛型类型不一致，编译阶段将会报错。
        // location.setXY("这是一些文本", new BigDecimal("0.01"));
    }


    /**
     * 示例三：泛型方法。
     * <p>
     * 在本示例中，我们定义一个泛型方法，将数组转换为对应类型的列表。
     */
    static void example03() {
        // 待转换的数组
        Integer[] array = {1, 2, 3, 4, 5};

        // 调用泛型方法，类型由参数或返回值推断得出，此处为Integer。
        List<Integer> list = arrayToList(array);

        System.out.println(list);
    }

    /**
     * 将数组转换为列表。
     * <p>
     * 该方法提供了一种将泛型数组转换为泛型列表的便捷方式。它避免了直接操作数组可能带来的局限性，比如数组长度不可变。
     * 使用列表可以使元素的添加、删除等操作更加灵活。
     *
     * @param <F>   泛型类型，表示数组和列表中元素的类型。
     * @param array 输入的泛型数组，将被转换为列表。
     * @return 返回一个新的列表，包含与输入数组相同的元素。
     */
    public static <F> List<F> arrayToList(F[] array) {
        List<F> list = new ArrayList<>();
        for (F item : array) {
            list.add(item);
        }
        return list;
    }


    /**
     * 示例四：类型擦除。
     * <p>
     * 在本示例中，我们通过反射获取泛型变量的类型，观察类型擦除的效果。
     */
    static void example04() {
        // 创建实例并设置初始坐标
        Location2<Integer, Double> location = new Location2<>();
        location.setXY(100, 25.1082);

        // 尝试获取变量的类型
        Field[] fields = location.getClass().getDeclaredFields();
        for (Field f : fields) {
            System.out.println("变量名称：" + f.getName());
            System.out.println("变量类型：" + f.getType());
        }
    }

    /**
     * 获取文本。
     *
     * @param num 数字。
     */
    private static <T extends Number & Serializable> String getText(T num) {
        // 调用Number类中的方法
        double d = num.doubleValue();
        return Double.toString(d);
    }

    /**
     * 示例：上下界。
     */
    static void example05() {
        Integer integer = 100;
        // 泛型参数类型为Integer，没有错误。
        String text = getText(integer);
        System.out.println(text);

        // 泛型参数类型为String，编译时将会报错。
        // String text1 = getText("TEXT");
    }

    /**
     * 示例：上下界。
     */
    static void example06() {
        Integer integer = 100;
        String text = getText(integer);
        System.out.println(text);

        // 泛型参数类型为String，编译时将会报错。
        // String text1 = getText("TEXT");
    }
}
