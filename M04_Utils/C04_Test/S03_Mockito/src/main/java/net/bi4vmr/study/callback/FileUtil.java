package net.bi4vmr.study.callback;

import java.util.Timer;
import java.util.TimerTask;

public class FileUtil {

    /**
     * 保存文件。
     *
     * @param callback 回调接口实现。
     */
    static void saveFile(FileCallback callback) {
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                // 异步操作完成，调用回调接口实现中的方法，通知调用者。
                callback.onResult(true, "OK.");
                // 清除Timer，终止当前程序。
                System.gc();
            }
        };
        // 延迟2秒再执行上述任务，模拟异步操作。
        new Timer().schedule(task, 2000L);
    }
}
