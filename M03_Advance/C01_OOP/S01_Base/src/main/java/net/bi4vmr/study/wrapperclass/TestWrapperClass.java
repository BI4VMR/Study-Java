package net.bi4vmr.study.wrapperclass;

/**
 * Name        : TestWrapperClass
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@outlook.com
 * <p>
 * Date        : 2023-12-10 14:15
 * <p>
 * Description : 测试类：包装类。
 */
public class TestWrapperClass {

    public static void main(String[] args) {
        example02();
    }

    /*
     * 示例：基本应用
     */
    static void example01() {
        // 定义基本类型的变量
        int num = 100;

        // 将基本类型转为包装类型
        Integer integer1 = Integer.valueOf(num);
        System.out.println("将基本类型数值转为Integer对象：" + integer1);
        // 将包装类型转为基本类型
        int base = integer1.intValue();
        System.out.println("将Integer对象转为基本类型数值：" + base);

        // 将字符串转为数值类型（输入值有效）
        int integer2 = Integer.parseInt("-1");
        System.out.println("将字符串转为数值类型：" + integer2);

        // 将字符串转为数值类型（输入值无效）
        int integer3 = Integer.parseInt("ABC");
        System.out.println("将字符串转为数值类型：" + integer3);
    }

    /*
     * 示例：自动装箱与拆箱
     */
    static void example02() {
        // 使用自动装箱机制创建Double类
        Double i = 91.5;
        System.out.println("装箱后的结果：" + i);

        // 定义一个Float对象，值为"87.3"。
        Float j = Float.valueOf(87.3F);
        // 自动拆箱
        float k = j;
        System.out.println("拆箱后的结果为：" + k);
    }
}
