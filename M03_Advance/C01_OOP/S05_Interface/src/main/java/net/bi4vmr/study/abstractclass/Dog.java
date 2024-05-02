package net.bi4vmr.study.abstractclass;

/**
 * 动物抽象类的子类：狗。
 */
public class Dog extends Animal {

    @Override
    public void eat() {
        // 实现"eat()"方法的逻辑
        System.out.println("狗吃狗粮");
    }
}
