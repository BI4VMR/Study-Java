package net.bi4vmr.study.base;

/**
 * Name        : ClassDemo
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@qq.com
 * <p>
 * Date        : 2022-11-21 21:22
 * <p>
 * Description : 类与对象示例。
 */
public class TestClass {

    public static void main(String[] args) {
        example04();
    }

    /*
     * 示例：创建类的对象，并访问对象的属性与方法。
     */
    static void example01() {
        // 从模板“人类”创建实体“张三”
        Person zhangsan = new Person();
        // 设置属性
        zhangsan.name = "张三";
        zhangsan.age = 18;
        zhangsan.sex = '男';
        // 调用方法
        zhangsan.speak();

        // 从模板“人类”创建实体“李四”
        Person lisi = new Person();
        lisi.name = "李四";
        lisi.age = 20;
        lisi.sex = '女';
        lisi.speak();
    }

    /*
     * 示例：访问空值对象中的变量或方法
     */
    static void example02() {
        // 创建一个值为空的对象"zhangsan"
        Person zhangsan = null;
        // 访问该对象的属性
        System.out.println(zhangsan.name);
        // 调用该对象的方法
        zhangsan.speak();
    }

    /*
     * 示例：判断可空变量
     */
    static void example03() {
        // 创建一个值为空的对象"zhangsan"
        Person zhangsan = null;

        // 判断对象是否为空
        if (zhangsan != null) {
            // 访问该对象的属性
            System.out.println(zhangsan.name);
            // 调用该对象的方法
            zhangsan.speak();
        } else {
            System.out.println("对象为空，放弃操作！");
        }
    }

    /*
     * 示例：使用构造方法初始化对象
     */
    static void example04() {
        // 使用"new"关键字创建对象
        Person zhangsan = new Person("张三", 18, '男');
        zhangsan.speak();

        // 使用"new"关键字创建对象
        Person lisi = new Person("李四", 20, '女');
        lisi.speak();
    }

}
