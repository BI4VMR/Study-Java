package net.bi4vmr.study.reflection.proxydynamic;

import java.lang.reflect.Proxy;

/**
 * 测试类：动态代理（反射机制实现）。
 * <p>
 * 调用代理类的方法，即客户类。
 *
 * @author BI4VMR@outlook.com
 * @since 1.0.0
 */
public class TestDynamicProxy {

    public static void main(String[] args) {

        // 创建目标类实例
        Outlook outlook = new Outlook();
        // 创建代理处理器实例
        MailHandler mailHandler = new MailHandler(outlook);

        /*
         * 创建代理类对象。
         *
         * @param loader 类加载器，用于创建代理类对象。所有应用类加载器均可使用，例如：代理类、目标类等；系统类加载器不可使用，例如：String与Object的类加载器。
         * @param interfaces 代理类需要实现的接口列表。我们可以调用目标类Class类的 `getInterfaces()` 方法获取数组，也可以创建数组并自行填入接口。
         * @param handler 调用处理器。当客户类调用代理类中的方法时，JVM将会回调该对象中的 `invoke()` 方法。
         * @return 代理类对象，可以被强制转换为 `interfaces` 参数所指明的任意一种类型。
         */
        SMTPSender proxySender = (SMTPSender) Proxy.newProxyInstance(Outlook.class.getClassLoader(), Outlook.class.getInterfaces(), mailHandler);
        // 通过代理对象调用目标对象的方法
        boolean result = proxySender.send("BI4VMR@outlook.com", "测试内容。");
        System.out.println("客户类 -> 邮件发送结果：" + result);
    }
}
