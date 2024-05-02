package net.bi4vmr.study.base;

import java.util.ArrayList;
import java.util.List;

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
     * 示例：接口的基本应用。
     */
    static void example01() {
        // 定义集合，元素需要满足“动物”接口
        List<Animal> animals = new ArrayList<>();

        // 创建Animal接口实现类的实例
        Dog dog = new Dog();
        Cat cat = new Cat();

        // 将实例添加至集合
        animals.add(dog);
        animals.add(cat);

        // 调用接口中定义的抽象方法
        for (Animal animal : animals) {
            animal.eat();
        }
    }
}
