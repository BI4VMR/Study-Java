package net.bi4vmr.study.oop.base;

/**
 * 测试代码：构造方法。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class TestConstruct {

    public static void main(String[] args) {
        example04();
    }

    /**
     * 示例四：构造方法。
     * <p>
     * 在本示例中，我们对前文“示例一”中的Person类进行修改，为其添加新的构造方法，并在测试代码中使用该构造方法创建对象。
     */
    static void example04() {
        // 使用三个参数的构造方法创建对象
        Person2 zhangsan = new Person2("张三", 18, '男');
        zhangsan.speak();
    }
}
