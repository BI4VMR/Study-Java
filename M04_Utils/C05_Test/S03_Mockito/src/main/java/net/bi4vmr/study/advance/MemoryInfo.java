package net.bi4vmr.study.advance;

/**
 * 内存信息工具类。
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class MemoryInfo {

    public long getTotalMemory() {
        return Runtime.getRuntime().totalMemory();
    }

    public long getFreeMemory() {
        return Runtime.getRuntime().freeMemory();
    }
}
