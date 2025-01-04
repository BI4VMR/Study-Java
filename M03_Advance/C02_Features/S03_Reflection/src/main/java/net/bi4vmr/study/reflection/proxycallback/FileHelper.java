package net.bi4vmr.study.reflection.proxycallback;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 文件工具类。
 *
 * @author BI4VMR@outlook.com
 * @since 1.0.0
 */
class FileHelper {

    public void saveFile(Callback cb) {
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                cb.onResult(true, "OK");
                // 清除Timer，终止当前程序。
                System.gc();
            }
        };
        // 延迟2秒再执行上述任务，模拟异步操作。
        new Timer().schedule(task, 2000L);
    }

    /**
     * 回调接口。
     */
    interface Callback {

        /**
         * 回调方法。
         *
         * @param result  执行结果。
         * @param message 消息。
         */
        void onResult(boolean result, String message);
    }
}
