package net.bi4vmr.study.util;

import java.io.Closeable;

/**
 * IO工具。
 *
 * @author BI4VMR@outlook.com
 */
public class IOUtil {

    /**
     * 释放资源（静默）。
     * <p>
     * 关闭实现了Closeable接口的资源，例如文件输入或输出流。
     * <p>
     * 如果遇到异常，会将其忽略。
     *
     * @param closeable 需要关闭的Closeable资源。
     */
    public static void closeSilently(Closeable closeable) {
        if (closeable == null) {
            return;
        }

        try {
            closeable.close();
        } catch (Exception e) {
            // 静默关闭，无需进一步处理。
        }
    }
}
