package net.bi4vmr.study.reflection.proxycallback;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理类：回调接口代理。
 *
 * @author BI4VMR@outlook.com
 * @since 1.0.0
 */
public class CallbackHandler implements InvocationHandler {

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
            case "onResult":
                // 校验参数是否合法，然后调用目标类的对应方法。
                if (args != null && args.length == 2) {
                    boolean result = args[0] instanceof Boolean ? (Boolean) args[0] : false;
                    String message = args[1].toString();
                    System.out.println("代理类 -> 结果：[" + result + "] 消息：[" + message + "]");
                }
                return null;

            /* Object类的方法 */
            case "toString":
                return toString();
            case "hashCode":
                return hashCode();
            case "equals":
                if (args != null && args.length >= 1 && args[0] != null) {
                    return hashCode() == args[0].hashCode();
                } else {
                    return false;
                }
        }

        return null;
    }
}
