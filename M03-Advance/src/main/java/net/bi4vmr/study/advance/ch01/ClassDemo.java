package net.bi4vmr.study.advance.ch01;

/**
 * Name        : ClassDemo
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@qq.com
 * <p>
 * Date        : 2022-11-21 21:22
 * <p>
 * Description : 类与对象示例。
 */
public class ClassDemo {

    public static void main(String[] args) {
        example02();
    }

    /*
     * 尝试创建类的对象并使用对象。
     */
    static void example01() {
        // 从模板“人类”创建实体“张三”
        Person zhangsan = new Person();
        // 设置属性
        zhangsan.name = "张三";
        zhangsan.age = 18;
        zhangsan.sex = '男';
        // 调用方法
        zhangsan.speak();

        // 从模板“人类”创建实体“李四”
        Person lisi = new Person();
        lisi.name = "李四";
        lisi.age = 20;
        lisi.sex = '女';
        lisi.speak();
    }

    /*
     * 尝试使用构造方法初始化对象
     */
    static void example02() {
        Person zhangsan = new Person("张三", 18, '男');
        zhangsan.speak();

        Person lisi = new Person("李四", 20, '女');
        lisi.speak();
    }
}
