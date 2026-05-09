package net.bi4vmr.study.base;

/**
 * 示例代码：基本应用。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class TestBase {

    public static void main(String[] args) {
        example01();
    }

    /**
     * 示例一：访问Math类的静态常量。
     * <p>
     * 在本示例中，我们访问Math类的静态常量。
     */
    static void example01() {
        System.out.println("π: " + Math.PI);
        System.out.println("e: " + Math.E);
    }
}
