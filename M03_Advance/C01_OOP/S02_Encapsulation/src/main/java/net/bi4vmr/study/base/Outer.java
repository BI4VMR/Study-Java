package net.bi4vmr.study.base;

/**
 * Name        : Outer
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@outlook.com
 * <p>
 * Date        : 2024-01-01 22:54
 * <p>
 * Description : 内部类示例。
 */
public class Outer {
    // 外部类的私有属性name
    private String name = "外部类";
    // 外部类的成员属性
    int age = 20;

    // 成员内部类Inner
    class Inner {
        String name = "内部类";

        // 内部类中的方法
        public void show() {
            System.out.println("外部类中的name：" + Outer.this.name);
            System.out.println("内部类中的name：" + name);
            System.out.println("外部类中的age：" + age);
        }
    }

    // 静态内部类StaticInner
    static class StaticInner {
        // 内部类中的方法
        public void show() {
            // 此处会导致编译错误，因为静态内部类中无法访问外部类的非静态成员。
            // System.out.println("外部类中的name：" + Outer.this.name);
        }
    }
}
