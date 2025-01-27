package net.bi4vmr.study.oop.base;

/**
 * 测试代码：静态成员。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class TestStatic {

    // 定义静态变量
    public static int num = 100;

    // 定义静态方法，计算平均分。
    static double avg(int score1, int score2) {
        return (score1 + score2) / 2.0;
    }

    // 测试方法
    public static void main(String[] args) {
        // 创建第一个对象，修改静态变量"num"的值
        TestStatic obj1 = new TestStatic();
        obj1.num = -1;
        System.out.println("对象1读取到的num变量值: " + obj1.num);

        // 创建第二个对象，读取静态变量"num"的值。
        TestStatic obj2 = new TestStatic();
        System.out.println("对象2读取到的num变量值: " + obj2.num);

        System.out.println("静态方法测试：");
        // 使用类名调用静态方法
        double score = TestStatic.avg(1, 2);
        System.out.println("平均分为：" + score);
    }
}
