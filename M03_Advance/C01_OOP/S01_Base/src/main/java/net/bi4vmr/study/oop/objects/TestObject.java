package net.bi4vmr.study.oop.objects;

/**
 * 测试类 - Object类。
 *
 * @author BI4VMR
 */
public class TestObject {

    public static void main(String[] args) {
        example03();
    }

    /*
     * 示例：输出对象信息
     */
    static void example01() {
        // 构建对象
        Person person = new Person("张三", 22, '男');
        // 打印对象信息
        System.out.println("对象信息：" + person);
    }

    /*
     * 示例：对象之间的判等
     */
    static void example02() {
        Person person1 = new Person("张三", 22, '男');
        Person person2 = new Person("张三", 22, '男');

        System.out.println("使用等号比较两个对象：" + (person1 == person2));
        System.out.println("使用\"equals()\"比较两个对象：" + (person1.equals(person2)));
    }

    /*
     * 示例：对象的哈希值
     */
    static void example03() {
        Person person1 = new Person("张三", 22, '男');
        Person person2 = new Person("张三", 22, '男');

        System.out.println("person1的哈希值：" + person1.hashCode());
        System.out.println("person2的哈希值：" + person2.hashCode());
    }
}
