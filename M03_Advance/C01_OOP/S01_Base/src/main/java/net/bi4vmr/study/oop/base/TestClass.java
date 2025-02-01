package net.bi4vmr.study.oop.base;

/**
 * 测试代码：类与对象。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class TestClass {

    public static void main(String[] args) {
        example01();
    }

    /**
     * 示例一：面向对象的基本应用。
     * <p>
     * 在本示例中，我们定义Person类描述“人类”，并创建一些对象。
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
}
