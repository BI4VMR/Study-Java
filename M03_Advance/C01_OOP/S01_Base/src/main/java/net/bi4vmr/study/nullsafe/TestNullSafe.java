package net.bi4vmr.study.nullsafe;

import net.bi4vmr.study.base.Person;

/**
 * 测试类 - 空值安全。
 *
 * @author BI4VMR
 */
public class TestNullSafe {

    public static void main(String[] args) {
        example01();
    }

    /*
     * 示例：访问空值对象中的变量或方法
     */
    static void example01() {
        // 创建一个值为空的对象"zhangsan"
        Person zhangsan = null;
        // 调用该对象的方法
        zhangsan.speak();
    }

    /*
     * 示例：判断可空变量
     */
    static void example02() {
        // 创建一个值为空的对象"zhangsan"
        Person zhangsan = null;

        // 判断对象是否为空
        if (zhangsan != null) {
            // 调用该对象的方法
            zhangsan.speak();
        } else {
            System.out.println("对象为空，放弃操作！");
        }
    }
}
