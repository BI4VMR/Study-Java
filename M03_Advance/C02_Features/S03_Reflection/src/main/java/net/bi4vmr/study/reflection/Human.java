package net.bi4vmr.study.reflection;

/**
 * 测试类 - 子类。
 *
 * @author bi4vmr@outlook.com
 */
@SuppressWarnings("Test")
class Human extends Animal {

    // 公开属性：名称
    public String name;
    // 私有属性：年龄
    private int age;

    // 构造方法：无参
    public Human() {
    }

    // 构造方法：有参
    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 公开方法：显示信息
    @Override
    public void printInfo() {
        System.out.println("This is Human. Name:[" + name + "] Age:[" + age + "]");
    }

    // 私有方法：说话
    private void speak(String text) {
        System.out.println("Speek. Content:[" + text + "]");
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
