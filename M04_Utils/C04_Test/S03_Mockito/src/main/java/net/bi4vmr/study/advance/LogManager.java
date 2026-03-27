package net.bi4vmr.study.advance;

import java.util.Random;
import java.util.logging.Level;

/**
 * 日志工具类。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class LogManager {

    private Level minLevel = Level.INFO;

    public Level getMinLevel() {
        return minLevel;
    }

    public LogManager() {
        // 注册配置监听器
        LogConfigTool.addConfigListener(newLevel -> {
            minLevel = newLevel;
        });
    }

    // 业务方法：导出日志
    public void saveLog(StateCallback callback) {
        // 通知外部监听者操作开始
        callback.onStart();

        // 生成随机耗时以模拟实际操作
        int time = new Random().nextInt(100, 500);
        callback.onEnd(time);
    }

    // 事件监听器
    public interface StateCallback {

        // 操作开始
        default void onStart() {
        }

        // 操作完成：通知消耗时长
        void onEnd(long time);
    }
}
