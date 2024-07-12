package net.bi4vmr.study.reflection;

class Child extends Father {

    // 公开属性：姓名
    public String name;
    // 公开属性：性别
    public char sex;
    // 私有属性：年龄
    private int age;

    // 构造方法：无参
    public Child() {
    }

    // 构造方法：有参
    public Child(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    // 公开方法：自我介绍
    public void summary() {
        System.out.println("这是一个父类。");
        System.out.println("我是" + name + "，年龄" + age + "岁，性别为" + sex);
    }

    // 公开方法：说话
    private void speak(String text) {
        System.out.println("父类：" + text);
    }
}
