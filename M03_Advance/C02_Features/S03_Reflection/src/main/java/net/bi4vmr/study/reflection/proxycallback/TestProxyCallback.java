package net.bi4vmr.study.reflection.proxycallback;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 测试类：动态代理（利用JDK代理接收回调方法）。
 *
 * @author BI4VMR@outlook.com
 * @since 1.0.0
 */
public class TestProxyCallback {

    public static void main(String[] args) {
        try {
            // 创建目标类实例
            FileHelper fileHelper = new FileHelper();

            // 获取回调接口的Class文件
            Class<?> clazz = Class.forName("net.bi4vmr.study.reflection.proxycallback.FileHelper$Callback");
            // 通过代理机制创建回调接口实现类的对象
            Object callback = Proxy.newProxyInstance(TestProxyCallback.class.getClassLoader(),
                    new Class[]{clazz},
                    new CallbackHandler());
            // 获取注册回调的方法，传入回调接口实现类的对象。
            Method method = FileHelper.class.getDeclaredMethod("saveFile", clazz);
            method.invoke(fileHelper, callback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
