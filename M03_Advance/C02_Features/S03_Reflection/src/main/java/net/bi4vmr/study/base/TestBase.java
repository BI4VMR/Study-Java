package net.bi4vmr.study.base;

import java.util.Arrays;

/**
 * 测试代码：反射。
 *
 * @author BI4VMR
 */
public class TestBase {

    public static void main(String[] args) {
        example01();
    }

    /*
     * 示例：使用常量表示季节
     */
    static void example01() {
        System.out.println("Test:" + Arrays.toString(Child.class.getFields()));
        System.out.println("Test:" + Arrays.toString(Child.class.getDeclaredFields()));
        // System.out.println("Test2:" + Child.class.getFie));
    }
}

class Father {

    // 公开属性
    public String name = "Father";
    // 私有属性
    public int age = 50;

    // 公开方法
    public void show() {
        System.out.println("This is Father.");
    }
}

class Child extends Father {

    // 公开属性
    public String name = "Child";
    // 私有属性
    public int age = 25;

    // 公开方法
    public void show() {
        System.out.println("This is Child.");
    }
}
