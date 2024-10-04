package net.bi4vmr.study.datetime;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 测试类：DateTime API。
 *
 * @author BI4VMR@outlook.com
 * @since 1.0.0
 */
public class TestDateTime {

    public static void main(String[] args) {
        example02();
    }

    static void example01() {
        System.out.println(LocalDateTime.now());
        System.out.println();
    }

    static void example02() {
        // 获取Formatter实例，并指定目标格式。
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS z");
        // DateTimeFormatter formatter = DateTimeFormatter.ISO_ORDINAL_DATE;
        String s = formatter.format(ZonedDateTime.now());
        System.out.println(s);

        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // LocalDateTime ldt = LocalDateTime.parse("2018-Dec-20 08:25:30", formatter);
        // System.out.println(ldt); //2018-12-20T08:25:30
    }
}
