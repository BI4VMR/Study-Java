package net.bi4vmr.study.base;

/**
 * 测试类 - 接口。
 *
 * @author BI4VMR
 */
public class TestInterface {

    public static void main(String[] args) {
        example01();
    }

    /*
     * 示例：使用接口的实现类创建对象。
     */
    static void example01() {
        Dog dog = new Dog();
        dog.eat();

        Cat cat = new Cat();
        cat.eat();
    }
}
