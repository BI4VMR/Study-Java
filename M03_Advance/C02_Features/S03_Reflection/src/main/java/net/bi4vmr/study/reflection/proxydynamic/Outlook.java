package net.bi4vmr.study.reflection.proxydynamic;

/**
 * 目标类：Outlook客户端。
 *
 * @author BI4VMR@outlook.com
 * @since 1.0.0
 */
public class Outlook implements SMTPSender {

    @Override
    public boolean send(String address, String content) {
        System.out.println("目标类 -> 使用Outlook发送邮件...");
        System.out.println("目标类 -> 邮箱：[" + address + "] 内容：[" + content + "]");
        return true;
    }
}
