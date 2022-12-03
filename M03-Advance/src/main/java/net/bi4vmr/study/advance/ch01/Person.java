package net.bi4vmr.study.advance.ch01;

/**
 * Name        : Person
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@qq.com
 * <p>
 * Date        : 2022-12-03 13:59
 * <p>
 * Description : 人类。
 */
public class Person {

    /* 属性 */
    String name;
    int age;
    char sex;

    /* 构造方法 */
    public Person() {}

    public Person(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    /* 方法 */
    public void speak() {
        System.out.println("我是" + name + "，年龄" + age + "岁，性别为" + sex);
    }
}
