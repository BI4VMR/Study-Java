package net.bi4vmr.study.base;

/**
 * 动物接口的实现类：狗。
 */
public class Dog implements Animal {

    @Override
    public void eat() {
        // 访问接口中的常量
        System.out.println("类型：" + TYPE_NAME);

        // 实现"eat()"方法的逻辑
        System.out.println("狗吃狗粮");
    }
}
