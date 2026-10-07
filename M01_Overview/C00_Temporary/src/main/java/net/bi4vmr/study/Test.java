package net.bi4vmr.study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Test {
    static Logger logger = LoggerFactory.getLogger(Test.class);
    static DateTimeFormatter f2 = new DateTimeFormatterBuilder()
            // 支持多种日期格式
            .appendPattern("[yyyy-MM-dd][yyyy/MM/dd][yyyy-M-d][yyyy/M/d]")
            // 可选部分开始
            .optionalStart()
            // 日期和时间之间可能以空格分隔，或以 ISO 标准格式的 `T` 分隔。
            .appendPattern("[' ']['T']")
            // 支持有秒时间和无秒时间、单数字时间和双数字时间
            .appendPattern("[HH:mm:ss][HH:mm][H:m:s][H:m]")
            .optionalEnd()
            // 配置默认值，如果输入文本不包含时分秒，则填写为 `00:00:00` 。
            .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
            .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
            .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
            .toFormatter();

    public static void main(String[] args) throws Exception {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


        String[] samples = {
                "2026-10-02 10:15:30",  // 标准 - 带秒
                "2026/10/02 10:15",     // / 分隔，不带秒
                "2026-10-2 8:5:0",      // 单数字月日时分秒
                "2026/10/02",           // 仅日期
                "2026-10-02T10:15:30"   // ISO 带 T 分隔
        };

        for (String sample : samples) {
            System.out.println(sample + "  -->  " + parse(sample));
        }
    }

    public static LocalDateTime parse(String text) {
        return LocalDateTime.parse(text.trim(), f2);
    }
}
