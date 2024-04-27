package net.bi4vmr.study.encapsulation;

import java.sql.Timestamp;

/**
 * Name        : Person
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@outlook.com
 * <p>
 * Date        : 2022-12-03 13:59
 * <p>
 * Description : 学生类。
 */
public class Student {

    /* 通过"private"属性隐藏变量 */
    private String id;
    private String name;
    private Timestamp birthDay;

    /* 定义获取变量"id"值的方法 */
    public String getId() {
        return id;
    }

    /* 定义设置变量"id"值的方法 */
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Timestamp birthDay) {
        this.birthDay = birthDay;
    }
}
