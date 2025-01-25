package net.bi4vmr.study.base;

/**
 * 示例类：人类。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class Person {

    /* 属性 */
    String name;
    int age;
    char sex;

    /* 方法 */
    public void speak() {
        System.out.println("我是" + name + "，年龄" + age + "岁，性别为" + sex);
    }
}
