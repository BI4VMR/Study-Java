package net.bi4vmr.study.advance.ch01;

/**
 * Name        : StaticDemo
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@qq.com
 * <p>
 * Date        : 2022-12-03 19:10
 * <p>
 * Description : 类的静态成员示例。
 */
public class StaticDemo {

    // 定义静态方法，计算平均分。
    public static double avg(int score1, int score2) {
        return (score1 + score2) / 2.0;
    }

    // 测试方法
    public static void main(String[] args) {
        // 使用类名调用静态方法
        double score = StaticDemo.avg(1, 2);
        System.out.println("平均分为：" + score);
    }
}
