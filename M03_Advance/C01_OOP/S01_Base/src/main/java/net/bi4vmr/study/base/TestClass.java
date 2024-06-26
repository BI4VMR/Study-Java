package net.bi4vmr.study.base;

/**
 * 测试类 - 类与对象。
 *
 * @author BI4VMR
 */
public class TestClass {

    public static void main(String[] args) {
        example02();
    }

    /*
     * 示例：由类创建对象，并访问对象的属性与方法。
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
     * 示例：使用构造方法初始化对象。
     */
    static void example02() {
        // 使用三个参数的构造方法创建对象
        Person2 zhangsan = new Person2("张三", 18, '男');
        zhangsan.speak();
    }
}
