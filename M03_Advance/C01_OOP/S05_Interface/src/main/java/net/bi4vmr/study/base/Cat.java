package net.bi4vmr.study.base;

/**
 * 动物接口的实现类：猫。
 */
public class Cat implements Animal {

    @Override
    public void eat() {
        // 实现"eat()"方法的逻辑
        System.out.println("猫吃猫粮");
    }
}
