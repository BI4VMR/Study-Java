package net.bi4vmr.study.advance;

import java.util.logging.Level;

/**
 * 日志配置工具类。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class LogConfigTool {

    private static ConfigListener mListener;

    /**
     * 注册回调。
     *
     * @param l 监听器实现。
     */
    public static void addConfigListener(ConfigListener l) {
        mListener = l;
    }

    /**
     * 回调接口：日志配置变更。
     */
    public interface ConfigListener {

        // 回调方法：最小日志级别变更
        void onLevelChange(Level level);
    }
}
