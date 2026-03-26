package net.bi4vmr.study.behavior_verify;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 日志工具类。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class LogManager {

    // 外部依赖
    private Logger logger = Logger.getAnonymousLogger();

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    // 业务方法：将一组消息分行输出
    public void printInfo(List<String> messages) {
        for (String message : messages) {
            logger.log(Level.INFO, message);
        }
    }

    // 业务方法：导出日志
    public void saveLog(StateCallback callback) {
        // 通知外部监听者操作开始
        callback.onStart();

        // 模拟耗时操作
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 通知外部监听者操作结束
        callback.onEnd(200L);
    }

    // 事件监听器
    public interface StateCallback {

        // 操作开始
        void onStart();

        // 操作完成：通知消耗时长
        void onEnd(long time);
    }
}
