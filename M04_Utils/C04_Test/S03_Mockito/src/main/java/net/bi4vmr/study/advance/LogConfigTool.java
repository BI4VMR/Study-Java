package net.bi4vmr.study.advance;

import java.util.function.Consumer;
import java.util.logging.Level;

/**
 * 日志配置工具类。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class LogConfigTool {

    private static ConfigListener mListener;

    public static void addConfigListener(ConfigListener listener) {
        mListener = listener;
    }

    public static void prepare(Consumer<String> callback) {
        // 模拟准备过程
        callback.accept("/real/log/path/");
    }

    public interface ConfigListener {
        void onLevelChange(Level level);
    }
}
