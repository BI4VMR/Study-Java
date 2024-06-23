package net.bi4vmr.study.base;

/**
 * 测试代码：泛型。
 *
 * @author BI4VMR
 */
public class TestBase {

    public static void main(String[] args) {
        example02();
    }

    /*
     * 示例：简介 - 不使用泛型实现坐标类。
     */
    static void example01() {
        // 使用数字类型数据创建实例
        Location1 i1 = new Location1(100, 25.1082);

        // 读取数据时需要判断具体的类型
        Object xRaw = i1.getX();
        if (xRaw instanceof Integer) {
            // 将数据转换为具体类型再操作
            boolean resultX = ((Integer) xRaw).compareTo(100) == 0;
            System.out.println("x = 100? " + resultX);
        } else if (xRaw instanceof Double) {
            boolean resultX = ((Double) xRaw).compareTo(100.0) == 0;
            System.out.println("x = 100? " + resultX);
        } else {
            throw new IllegalArgumentException("参数类型错误！");
        }
        // 比较Y轴的数据时也需要判断类型，此处省略相关代码。

        // 创建实例时随便传入非法数据也不会出错，只在读取数据时才能发现错误。
        Location1 i2 = new Location1(TestBase.class, Thread.currentThread());
    }

    /*
     * 示例：基本应用 - 使用泛型实现坐标类。
     */
    static void example02() {
        // 使用数字类型数据创建实例
        Location2<Integer, Double> i1 = new Location2<>(100, 25.1082);

        // 读取数据时无需判断类型，与创建实例时的类型一致。
        Integer x = i1.getX();
        boolean resultX = x.compareTo(100) == 0;
        System.out.println("x = 100? " + resultX);
        // 比较Y轴的数据时无需判断类型，此处省略相关代码。

        // 构造方法参数与声明实例时的泛型类型不一致，编译时将会报错。
        // Location2<Integer, Double> i2 = new Location2<>(TestBase.class, Thread.currentThread());
    }
}
