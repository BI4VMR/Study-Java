package net.bi4vmr.study.jni.dynamic;

/**
 * Name        : JNIClass
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@outlook.com
 * <p>
 * Date        : 2024-01-20 22:26
 * <p>
 * Description : 包含本地方法的类。
 */
public class JNIClass {

    static {
        System.loadLibrary("native");
    }

    // 本地方法：传递基本数据类型参数
    native void passBasicTypes(boolean b, int i, double d);

    // 本地方法：传递字符串参数
    native void passString(String str);

    // 本地方法：传递字符串数组参数
    native void passStringArray(String[] array);

    // 本地方法：返回基本数据类型
    native long returnBasicTypes();

    // 本地方法：返回字符串
    native String returnString();
}
