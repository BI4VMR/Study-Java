package net.bi4vmr.study.datetime;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.ZoneId;
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

        long s1 =currentMonthFirstDayTimestamp();
        long s2 = currentMonthLastDayTimestamp();
        System.out.println("当前月份范围的第一天时间戳：" + s1);
        System.out.println("当前月份范围的最后一天时间戳：" + s2);
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

        ZoneId systemZone = ZoneId.systemDefault();
        ZonedDateTime.now(ZoneId.of("America/New_York"));
        // /**
        //  * 3. 使用 ZoneOffset 处理固定偏移量
        //  *
        //  * 如果你不需要处理复杂的夏令时规则，只需要表达类似 “GMT+8” 这种固定偏移，可以使用 ZoneOffset。它虽然也不是枚举，但内部提供了一些常用的常量：
        //  *
        //  *     ZoneOffset.UTC（等价于 +00:00）
        //  *
        //  *     ZoneOffset.MIN（最小偏移量 -18:00）
        //  *
        //  *     ZoneOffset.MAX（最大偏移量 +18:00）
        //  */
    }

    public static long currentMonthFirstDayTimestamp() {
        ZoneId zone = ZoneId.systemDefault();
        return YearMonth.now(zone)
                .atDay(1)
                .atStartOfDay(zone)
                .toInstant()
                .toEpochMilli();
    }

    public static long currentMonthLastDayTimestamp() {
        ZoneId zone = ZoneId.systemDefault();
        return YearMonth.now(zone)
                .atEndOfMonth()
                .atTime(LocalTime.MAX)
                .atZone(zone)
                .toInstant()
                .toEpochMilli();
    }
}
