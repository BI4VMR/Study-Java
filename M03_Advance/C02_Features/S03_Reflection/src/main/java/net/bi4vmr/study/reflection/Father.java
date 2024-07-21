package net.bi4vmr.study.reflection;

/**
 * 测试类 - 父类。
 *
 * @author bi4vmr@outlook.com
 */
public class Father {

    // 私有属性：名称
    private String name = "父类";
    // 公开属性：性别
    public char sex;
    // 私有属性：年龄
    private int age;

    // 公开方法：自我介绍
    public void summary() {
        System.out.println("这是一个父类。");
        System.out.println("我是" + name + "，年龄" + age + "岁，性别为" + sex);
    }

    // 私有方法：说话
    private void speak(String text) {
        System.out.println("父类：" + text);
    }
}
