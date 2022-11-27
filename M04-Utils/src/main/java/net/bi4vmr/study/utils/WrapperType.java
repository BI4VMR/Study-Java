package net.bi4vmr.study.utils;

/**
 * Name        : WrapperType
 * Author      : BI4VMR
 * Email       : bi4vmr@qq.com
 * Date        : 2022-07-10 20:47
 * Description : 包装类。
 */
public class WrapperType {
    public static void main(String[] args) {
        // 定义double类型变量
        double i = 91.5;

        // 自动装箱
        Double da = i;
        System.out.println("装箱后的结果：" + da);

        // 定义一个Float包装类对象，值为87.3
        Float j = new Float(87.3);

        // 手动拆箱
        float k = j.floatValue();
        // 自动拆箱
        float l = j;
        System.out.println("拆箱后的结果为：" + k + "和" + l);

        // 将字符串直接转为int型(使用静态方法)
        int t = Integer.parseInt("101");
        System.out.println("转换后的结果为：" + t);
    }
}
