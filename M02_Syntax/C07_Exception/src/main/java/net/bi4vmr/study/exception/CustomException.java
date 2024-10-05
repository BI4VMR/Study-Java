package net.bi4vmr.study.exception;

/**
 * 自定义异常。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
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
