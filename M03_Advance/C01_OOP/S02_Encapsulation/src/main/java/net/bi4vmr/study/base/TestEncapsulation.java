package net.bi4vmr.study.base;

import java.io.File;

/**
 * 测试类 - 封装。
 *
 * @author BI4VMR
 */
public class TestEncapsulation {

    public static void main(String[] args) {
        example02();
    }

    /*
     * 示例：调用其他包中的功能
     */
    static void example01() {
        // 调用Util包中的类
        java.util.UUID.randomUUID();
        // 调用IO包中的类
        new File("/");
    }

    /*
     * 示例：使用"get/set"方法访问变量
     */
    static void example02() {
        Student student = new Student();
        // 使用set方法给name属性赋值
        student.setName("张三");
        // 使用get方法读取name属性的值
        System.out.println("name的值为：" + student.getName());
    }

    /*
     * 示例：成员内部类
     */
    static void example03() {
        // 创建外部类的对象
        Outer o = new Outer();
        // 创建内部类的对象
        Outer.Inner i = o.new Inner();
        // 调用内部类对象的show方法
        i.show();
    }

    /*
     * 示例：匿名内部类
     */
    static void example04() {
        // 该方法需要一个USBStateCallback接口的实现类，此处直接实例化，无需保存至当前类的变量。
        USBManager.addUSBStateCallback(new USBManager.USBStateCallback() {
            @Override
            public void onPlugged() {
                System.out.println("检测到USB设备插入！");
            }

            @Override
            public void onUnPlugged() {
                System.out.println("检测到USB设备拔出！");
            }
        });
    }
}
