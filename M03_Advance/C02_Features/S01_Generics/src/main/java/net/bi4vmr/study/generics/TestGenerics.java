package net.bi4vmr.study.generics;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

/**
 * 测试代码：泛型。
 *
 * @author BI4VMR
 */
public class TestGenerics {

    public static void main(String[] args) {
        example05();
    }

    /*
     * 示例：简介 - 不使用泛型实现坐标类。
     */
    static void example01() {
        // 使用数字类型数据创建实例
        Location1 l1 = new Location1(100, 25.1082);

        // 读取数据时需要判断具体的类型
        Object xRaw = l1.getX();
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

        // 创建实例时随便传入非法数据也不会出错，只在读取数据时才能发现错误。
        Location1 l2 = new Location1(TestGenerics.class, Thread.currentThread());
    }

    /*
     * 示例：基本应用 - 使用泛型实现坐标类。
     */
    static void example02() {
        // 使用数字类型数据创建实例
        Location2<Integer, Double> l1 = new Location2<>(100, 25.1082);

        // 读取数据时无需判断类型，与创建实例时的类型一致。
        Integer x = l1.getX();
        boolean resultX = x.compareTo(100) == 0;
        System.out.println("x = 100? " + resultX);
        // 比较Y轴的数据时无需判断类型，此处省略相关代码。

        // 构造方法参数与声明实例时的泛型类型不一致，编译时将会报错。
        // Location2<Integer, Double> l2 = new Location2<>(TestBase.class, Thread.currentThread());
    }

    /**
     * 示例：泛型方法。
     */
    static void example03() {
        Integer[] array = {1, 2, 3, 4, 5};
        // 使用泛型方法
        List<Integer> list = Location3.arrayToList(array);
        System.out.println(list);
    }

    /**
     * 示例：类型擦除。
     */
    static void example04() {
        // 创建实例并指定类型
        Location2<Integer, Double> location = new Location2<>(100, 25.1082);
        // 尝试获取变量的类型
        Field[] fields = location.getClass().getDeclaredFields();
        for (Field f : fields) {
            System.out.println("变量名称：" + f.getName());
            System.out.println("变量类型：" + f.getType());
        }
        System.out.println("变量类型：" + fields[0].getGenericType());
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
