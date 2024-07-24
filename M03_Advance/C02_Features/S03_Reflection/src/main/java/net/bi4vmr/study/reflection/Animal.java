package net.bi4vmr.study.reflection;

/**
 * 测试类 - 父类。
 *
 * @author bi4vmr@outlook.com
 */
public class Animal {

    // 公开属性：名称
    public String name = "动物";
    // 私有属性：年龄
    private int age;

    // 公开方法：显示信息
    public void printInfo() {
        System.out.println("This is Animal. Name:[" + name + "] Age:[" + age + "]");
    }
}
