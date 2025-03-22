package net.bi4vmr.study.callback;

public interface FileCallback {

    /**
     * 回调方法。
     *
     * @param result  执行结果。
     * @param message 消息。
     */
    void onResult(boolean result, String message);
}
