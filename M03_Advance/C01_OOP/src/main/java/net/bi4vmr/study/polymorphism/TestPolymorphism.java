package net.bi4vmr.study.polymorphism;

/**
 * Name        : TestPolymorphism
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@outlook.com
 * <p>
 * Date        : 2023-12-28 22:35
 * <p>
 * Description : 测试类：多态。
 */
public class TestPolymorphism {

    public static void main(String[] args) {
        example01();
    }

    /*
     * 示例：使用常量表示季节
     */
    static void example01() {
        // 声明Father变量"t1"，指向父类的引用。
        Father t1 = new Father();
        // 声明Father变量"t2"，指向子类的引用。
        Father t2 = new Child();

        // 分别执行两个变量的"show()"方法
        t1.show();
        t2.show();
    }
}
