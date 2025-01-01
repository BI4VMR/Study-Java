package net.bi4vmr.study.reflection.proxystatic;

/**
 * 代理类：邮件功能代理。
 *
 * @author BI4VMR@outlook.com
 * @since 1.0.0
 */
public class MailProxy implements SMTPSender {

    private final Outlook outlook = new Outlook();

    @Override
    public boolean send(String address, String content) {
        // 扩展能力一：日志记录。
        System.out.println("代理类 -> 记录操作日志...");
        // 扩展能力二：耗时统计。
        long startTS = System.currentTimeMillis();

        // 收到客户类的调用请求后，调用目标类的对应方法。
        boolean result = outlook.send(address, content);

        long time = System.currentTimeMillis() - startTS;
        System.out.println("代理类 -> 发送邮件耗时：" + time + "ms");

        return result;
    }
}
