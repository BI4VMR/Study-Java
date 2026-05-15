package net.bi4vmr.study.base;

/**
 * 实体类：学生。
 */
public class Student {

    /**
     * ID。
     */
    private long id;

    /**
     * 姓名。
     */
    private String name;

    /**
     * 年龄。
     */
    private int age;

    // 构造方法
    public Student(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
