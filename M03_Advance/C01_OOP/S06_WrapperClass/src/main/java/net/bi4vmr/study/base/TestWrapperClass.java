package net.bi4vmr.study.base;

/**
 * 测试类：包装类。
 *
 * @author BI4VMR@outlook.com
 * @since 1.0.0
 */
public class TestWrapperClass {

    public static void main(String[] args) {
        example02();
    }

    /**
     * 示例一：基本数据类型与包装类之间的转换方法。
     * <p>
     * 在本示例中，我们使用包装类提供的方法，实现基本数据类型与包装类之间的相互转换。
     */
    static void example01() {
        // 定义基本类型的变量
        int num = 100;

        // 将基本类型转为包装类型
        Integer integer = Integer.valueOf(num);
        System.out.println("将基本类型数值转为Integer对象：" + integer);

        // 将包装类型转为基本类型
        int base = integer.intValue();
        System.out.println("将Integer对象转为基本类型数值：" + base);
    }

    /**
     * 示例二：文本与数值类型之间的转换方法。
     * <p>
     * 在本示例中，我们使用包装类提供的方法，实现文本类型与数值类型之间的相互转换。
     */
    static void example02() {
        // 将字符串转为数值类型（输入值有效）
        int integer1 = Integer.parseInt("-1");
        System.out.println("将字符串转为数值类型：" + integer1);

        // 将字符串转为数值类型（输入值无效）
        int integer2 = Integer.parseInt("ABC");
        System.out.println("将字符串转为数值类型：" + integer2);
    }

    /**
     * 示例三：自动装箱与拆箱。
     * <p>
     * 在本示例中，我们使用自动装箱和拆箱机制实现基本数据类型与包装类之间的相互转换。
     */
    static void example03() {
        // 使用自动装箱机制创建Double类
        Double i = 91.5;
        System.out.println("装箱后的结果为：" + i);

        // 定义一个Float对象，值为"87.3"。
        Float j = Float.valueOf(87.3F);
        // 自动拆箱
        float k = j;
        System.out.println("拆箱后的结果为：" + k);
    }
}
