package net.bi4vmr.study.abstractclass;

/**
 * 抽象类示例 - 动物。
 */
public abstract class Animal {

    // 定义变量
    private String name = "Animal";

    // 定义抽象方法
    public abstract void eat();

    // 定义普通方法
    public void speak() {
        System.out.println("这是一个" + name);
    }
}
