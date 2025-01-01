package net.bi4vmr.study.reflection.proxystatic;

/**
 * 测试类：静态代理。
 * <p>
 * 调用代理类的方法，即客户类。
 *
 * @author BI4VMR@outlook.com
 * @since 1.0.0
 */
public class TestStaticProxy {

    public static void main(String[] args) {
        // 创建代理类对象，调用代理类中的方法。
        MailProxy proxy = new MailProxy();
        boolean result = proxy.send("BI4VMR@outlook.com", "测试内容。");
        System.out.println("客户类 -> 邮件发送结果：" + result);
    }
}
