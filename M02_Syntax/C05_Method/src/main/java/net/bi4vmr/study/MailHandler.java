package net.bi4vmr.study;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理类：邮件功能代理。
 *
 * @author BI4VMR@outlook.com
 * @since 1.0.0
 */
public class MailHandler implements InvocationHandler {

    // 全局变量，用于保存外部传入的目标类实例。
    private final TestMethod.FileHelper sender;

    /**
     * 构造方法。
     *
     * @param sender 目标类对象。
     */
    public MailHandler(TestMethod.FileHelper sender) {
        this.sender = sender;
    }

    /**
     * 回调方法，代理方法被客户类调用时触发。
     *
     * @param proxy  代理对象。
     * @param method 方法详情。
     * @param args   参数列表。
     * @return 需要返回给调用者的值。
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        String methodName = method.getName();
        System.out.println("代理类 -> 收到客户类的调用请求，方法名称：[" + methodName + "]");
        switch (methodName) {
            /* 目标类的方法 */
            case "send":
                // 校验参数是否合法，然后调用目标类的对应方法。
                if (args != null && args.length == 2) {
                    String address = args[0].toString();
                    String content = args[1].toString();
                    return null;
                } else {
                    return null;
                }

            /* Object类的方法 */
            case "toString":
                return sender.toString();
            case "hashCode":
                return sender.hashCode();
            case "equals":
                if (args != null && args.length >= 1 && args[0] != null) {
                    return sender.hashCode() == args[0].hashCode();
                } else {
                    return false;
                }
        }

        return null;
    }
}
