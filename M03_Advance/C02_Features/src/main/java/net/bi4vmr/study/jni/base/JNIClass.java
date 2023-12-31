package net.bi4vmr.study.jni.base;

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
        /*
         * 加载C或C++编写的动态链接库
         *
         * 指定动态链接库的名称前缀，Linux环境下为"native.so"；Windows环境下为"native.dll"。
         */
        System.loadLibrary("native");
    }

    // 本地方法：输出文本
    native void printInfo();
}
