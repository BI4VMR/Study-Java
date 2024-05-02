package net.bi4vmr.study.abstractclass;

/**
 * 测试类 - 抽象类。
 *
 * @author BI4VMR
 */
public class TestAbstractClass {

    public static void main(String[] args) {
        example01();
    }

    /*
     * 示例：使用抽象类及其实现类。
     */
    static void example01() {
        // 创建抽象类的实例
        Dog dog = new Dog();
        // 调用Animal类中的普通方法
        dog.speak();
        // 调用Dog类实现的抽象方法
        dog.eat();
    }
}
