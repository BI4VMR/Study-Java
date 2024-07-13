package net.bi4vmr.study.exception;

/**
 * Name        : CustomException
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@qq.com
 * <p>
 * Date        : 2022-11-25 23:47
 * <p>
 * Description : 自定义异常。
 */
public class CustomException extends Exception {

    // 错误码
    private final int code;

    public CustomException(int code, String message) {
        super(message);
        this.code = code;
    }

    // 获取错误码
    public int getCode() {
        return code;
    }
}
