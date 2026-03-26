package net.bi4vmr.study.advance;

import java.util.logging.Level;

/**
 * 日志工具类。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class LogManager {

    private Level minLevel = Level.INFO;

    public LogManager() {
        // 注册配置监听器
        LogConfigTool.addConfigListener(level -> {
            System.out.println("收到配置变更事件，新级别：" + level);
            minLevel = level;
        });
    }

    public Level getMinLevel() {
        return minLevel;
    }

    public void saveLog(StateCallback callback) {
        callback.onStart();
        // 模拟耗时
        callback.onEnd(150L);
    }

    public interface StateCallback {
        void onStart();
        void onEnd(long time);
    }
}
