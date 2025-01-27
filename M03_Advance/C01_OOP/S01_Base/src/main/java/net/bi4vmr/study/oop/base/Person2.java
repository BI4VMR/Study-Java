package net.bi4vmr.study.oop.base;

/**
 * 示例类：人类。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class Person2 {

    /* 属性 */
    String name;
    int age;
    char sex;

    /* 构造方法 */
    public Person2() {
    }

    /* 构造方法 */
    public Person2(String name, int age, char sex) {
        System.out.println("使用有参构造方法初始化对象...");
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    /* 方法 */
    public void speak() {
        System.out.println("我是" + name + "，年龄" + age + "岁，性别为" + sex);
    }
}
