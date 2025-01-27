package net.bi4vmr.study.oop.objects;

import java.util.Objects;

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

    /* 构造方法 */
    public Person() {
    }

    public Person(String name, int age, char sex) {
        System.out.println("使用有参构造方法初始化对象...");
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    /* 方法 */
    public void speak() {
        System.out.println("我是" + name + "，年龄" + age + "岁，性别为" + sex);
    }

    /**
     * Name        : 显示对象信息
     * <p>
     * Description : 显示对象信息。
     *
     * @return 对象信息
     */
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    /**
     * Name        : 判断两个对象是否相等
     * <p>
     * Description : 判断两个对象是否相等。
     *
     * @param o 待比较的对象
     * @return 比较结果，如果两个对象是相同的则为"true"，否则为"false"。
     */
    @Override
    public boolean equals(Object o) {
        // 如果两个对象的内存地址相同，则可以直接判定相等。
        if (this == o) {
            return true;
        }

        // 如果传入对象为空，或对象类型与当前类不一致，则可以直接判定不等。
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        // 比较对象的哈希值是否相等
        if (hashCode() != o.hashCode()) {
            return false;
        }

        // 比较对象的每个属性是否相等
        Person person = (Person) o;
        return age == person.age &&
                sex == person.sex &&
                Objects.equals(name, person.name);
    }

    /**
     * Name        : 获取对象的哈希值
     * <p>
     * Description : 获取对象的哈希值。
     *
     * @return 哈希值
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }
}
