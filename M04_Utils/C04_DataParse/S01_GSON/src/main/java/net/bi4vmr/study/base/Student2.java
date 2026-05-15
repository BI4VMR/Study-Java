package net.bi4vmr.study.base;

import com.google.gson.annotations.SerializedName;

/**
 * 实体类：学生。
 */
public class Student2 {

    /**
     * ID
     */
    private long id;

    /**
     * 姓名。
     * <p>
     * `@SerializedName`注解用于指定JSON字段名称和Java字段名称之间的映射关系。
     * `value` 属性指定的名称对序列化（Java对象转换为JSON）和反序列化都有效，而 `alternate` 属性指定的名称只对反序列化（JSON转换为Java对象）有效。
     */
    @SerializedName(value = "s_name", alternate = {"fullName", "studentName"})
    private String name;

    /**
     * 年龄。
     */
    private int age;

    // 构造方法
    public Student2(long id, String name, int age) {
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
