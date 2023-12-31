package net.bi4vmr.study.jni.datatype;

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
     * 示例：传递基本数据类型参数
     */
    static void example01() {
        JNIClass c = new JNIClass();
        c.passBasicTypes(true, -1000, 3.1415);
    }

    /*
     * 示例：传递字符串参数
     */
    static void example02() {
        JNIClass c = new JNIClass();
        c.passString("This is some text info.");
    }

    /*
     * 示例：传递字符串数组参数
     */
    static void example03() {
        // 测试数据
        String[] array = new String[]{"A", "B", "C", "D"};

        JNIClass c = new JNIClass();
        c.passStringArray(array);
    }

    /*
     * 示例：返回基本数据类型
     */
    static void example04() {
        JNIClass c = new JNIClass();
        long num = c.returnBasicTypes();
        System.out.println("ReturnBasicTypes. Value:[" + num + "]");
    }

    /*
     * 示例：返回字符串
     */
    static void example05() {
        JNIClass c = new JNIClass();
        String text = c.returnString();
        System.out.println("ReturnString. Value:[" + text + "]");
    }
}
