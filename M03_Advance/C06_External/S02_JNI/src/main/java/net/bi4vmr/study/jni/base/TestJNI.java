package net.bi4vmr.study.jni.base;

/**
 * Name        : TestJNI
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@outlook.com
 * <p>
 * Date        : 2022-11-21 21:22
 * <p>
 * Description : 测试类：JNI。
 */
public class TestJNI {

    public static void main(String[] args) {
        example01();
    }

    /*
     * 示例：JNI的基本应用
     */
    static void example01() {
        JNIClass c = new JNIClass();
        c.printInfo();
    }
}
