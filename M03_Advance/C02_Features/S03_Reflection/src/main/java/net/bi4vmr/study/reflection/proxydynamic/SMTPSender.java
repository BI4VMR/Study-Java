package net.bi4vmr.study.reflection.proxydynamic;

/**
 * 公共接口：邮件发送能力。
 *
 * @author BI4VMR@outlook.com
 * @since 1.0.0
 */
public interface SMTPSender {

    /**
     * 发送邮件。
     *
     * @param address 目标邮箱地址。
     * @param content 邮件内容。
     * @return "true"表示发送成功，"false"表示发送失败。
     */
    boolean send(String address, String content);
}
