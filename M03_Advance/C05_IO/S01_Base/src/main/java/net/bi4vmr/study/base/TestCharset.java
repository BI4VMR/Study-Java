package net.bi4vmr.study.base;

import java.nio.charset.Charset;
import java.util.SortedMap;

/**
 * 测试代码 - 字符集。
 *
 * @author BI4VMR@outlook.com
 */
public class TestCharset {

    public static void main(String[] args) {
        example01();
    }

    /**
     * 示例：获取JVM编码信息。
     */
    static void example01() {
        // 获取JVM默认字符集
        Charset charset = Charset.defaultCharset();
        System.out.println("JVM默认字符集：" + charset);

        // 通过名称获取字符集对象
        Charset charset2 = Charset.forName("GBK");
        System.out.println("通过名称获取字符集对象：" + charset2);

        // 判断JVM是否支持特定的字符集
        boolean supportedBIG5 = Charset.isSupported("BIG5");
        System.out.println("当前JVM是否支持BIG5编码：" + supportedBIG5);

        // 获取JVM支持的所有字符集
        System.out.println("当前JVM支持的字符集列表：");
        SortedMap<String, Charset> map = Charset.availableCharsets();
        for (String key : map.keySet()) {
            System.out.println(key);
        }
    }
}
