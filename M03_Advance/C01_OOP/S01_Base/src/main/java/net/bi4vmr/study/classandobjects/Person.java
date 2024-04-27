package net.bi4vmr.study.classandobjects;

/**
 * 类的示例 - 人类。
 *
 * @author BI4VMR
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
