package net.bi4vmr.study;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * 日期时间工具类。
 *
 * <p>
 * 提供以下功能：
 * <ul>
 *   <li>时间戳 ↔ LocalDateTime / ZonedDateTime 互转</li>
 *   <li>时间字符串 → LocalDateTime / ZonedDateTime 解析</li>
 *   <li>获取当前时间戳（系统时区 / 指定时区）</li>
 *   <li>获取当前周 / 月 / 季度 / 年的时间范围（DateTime 或时间戳表示）</li>
 *   <li>格式化、差值计算、偏移、边界、判断等常用扩展方法</li>
 * </ul>
 *
 * @author bi4vmr@outlook.com
 * @since 1.0.0
 */
public class DateTimeUtil {

    // ==================== 常量 ====================

    /**
     * 默认日期时间格式：{@code yyyy-MM-dd HH:mm:ss}
     */
    public static final String PATTERN_DATETIME = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期格式：{@code yyyy-MM-dd}
     */
    public static final String PATTERN_DATE = "yyyy-MM-dd";

    /**
     * 时间格式：{@code HH:mm:ss}
     */
    public static final String PATTERN_TIME = "HH:mm:ss";

    /**
     * 系统默认时区
     */
    public static final ZoneId DEFAULT_ZONE = ZoneId.systemDefault();

    // ==================== 内部类型 ====================

    /**
     * 时间范围，包含起止两个端点。
     *
     * @param <T> 时间类型，可为 {@link LocalDateTime} 或 {@link Long}（毫秒时间戳）
     */
    public static final class TimeRange<T> {

        /**
         * 起始时间（含）
         */
        private final T start;

        /**
         * 结束时间（含）
         */
        private final T end;

        public TimeRange(T start, T end) {
            this.start = start;
            this.end = end;
        }

        public T start() {
            return start;
        }

        public T end() {
            return end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof TimeRange)) return false;
            TimeRange<?> other = (TimeRange<?>) o;
            return java.util.Objects.equals(start, other.start)
                    && java.util.Objects.equals(end, other.end);
        }

        @Override
        public int hashCode() {
            return java.util.Objects.hash(start, end);
        }

        @Override
        public String toString() {
            return "TimeRange{start=" + start + ", end=" + end + "}";
        }
    }

    // ==================== 获取当前时间 ====================

    /**
     * 获取当前 {@link LocalDateTime}（系统时区）。
     *
     * @return 当前本地日期时间
     */
    public static LocalDateTime now() {
        return LocalDateTime.now();
    }

    /**
     * 获取当前 {@link ZonedDateTime}（指定时区）。
     *
     * @param zoneId 目标时区
     * @return 当前带时区的日期时间
     */
    public static ZonedDateTime now(ZoneId zoneId) {
        return ZonedDateTime.now(zoneId);
    }

    // ==================== 获取当前时间戳 ====================

    /**
     * 获取当前时间戳。
     *
     * @return UTC Epoch时间戳。
     */
    public static long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    // ==================== 时间戳 → DateTime ====================

    /**
     * 将毫秒时间戳转为 {@link LocalDateTime}（系统时区）。
     *
     * @param timestamp 毫秒级时间戳
     * @return 对应的本地日期时间
     */
    public static LocalDateTime fromTimestamp(long timestamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), DEFAULT_ZONE);
    }

    /**
     * 将毫秒时间戳转为 {@link ZonedDateTime}（指定时区）。
     *
     * @param timestamp 毫秒级时间戳
     * @param zoneId    目标时区
     * @return 对应的带时区日期时间
     */
    public static ZonedDateTime fromTimestamp(long timestamp, ZoneId zoneId) {
        return ZonedDateTime.ofInstant(Instant.ofEpochMilli(timestamp), zoneId);
    }

    // ==================== DateTime → 时间戳 ====================

    /**
     * 将 {@link LocalDateTime} 转为毫秒时间戳（系统时区）。
     *
     * @param dateTime 本地日期时间
     * @return 毫秒级时间戳
     */
    public static long toTimestamp(LocalDateTime dateTime) {
        return dateTime.atZone(DEFAULT_ZONE).toInstant().toEpochMilli();
    }

    /**
     * 将 {@link ZonedDateTime} 转为毫秒时间戳。
     *
     * @param dateTime 带时区的日期时间
     * @return 毫秒级时间戳
     */
    public static long toTimestamp(ZonedDateTime dateTime) {
        return dateTime.toInstant().toEpochMilli();
    }

    // ==================== 字符串 → DateTime ====================

    /**
     * 将标准格式字符串（{@value #PATTERN_DATETIME}）解析为 {@link LocalDateTime}。
     *
     * @param dateTimeStr 日期时间字符串
     * @return 解析结果
     */
    public static LocalDateTime fromString(String dateTimeStr) {
        return fromString(dateTimeStr, PATTERN_DATETIME);
    }

    /**
     * 将指定格式的字符串解析为 {@link LocalDateTime}。
     *
     * @param dateTimeStr 日期时间字符串
     * @param pattern     格式模板，如 {@code "yyyy/MM/dd HH:mm"}
     * @return 解析结果
     */
    public static LocalDateTime fromString(String dateTimeStr, String pattern) {
        return LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 将标准格式字符串解析为 {@link ZonedDateTime}（指定时区）。
     *
     * @param dateTimeStr 日期时间字符串
     * @param zoneId      目标时区
     * @return 解析结果
     */
    public static ZonedDateTime fromString(String dateTimeStr, ZoneId zoneId) {
        return fromString(dateTimeStr, PATTERN_DATETIME, zoneId);
    }

    /**
     * 将指定格式的字符串解析为 {@link ZonedDateTime}（指定时区）。
     *
     * @param dateTimeStr 日期时间字符串
     * @param pattern     格式模板
     * @param zoneId      目标时区
     * @return 解析结果
     */
    public static ZonedDateTime fromString(String dateTimeStr, String pattern, ZoneId zoneId) {
        LocalDateTime local = LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern(pattern));
        return ZonedDateTime.of(local, zoneId);
    }

    // ==================== 格式化 ====================

    /**
     * 将 {@link LocalDateTime} 格式化为字符串（默认格式 {@value #PATTERN_DATETIME}）。
     *
     * @param dateTime 日期时间
     * @return 格式化后的字符串
     */
    public static String format(LocalDateTime dateTime) {
        return format(dateTime, PATTERN_DATETIME);
    }

    /**
     * 将 {@link LocalDateTime} 格式化为字符串（指定格式）。
     *
     * @param dateTime 日期时间
     * @param pattern  格式模板
     * @return 格式化后的字符串
     */
    public static String format(LocalDateTime dateTime, String pattern) {
        return dateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 将 {@link ZonedDateTime} 格式化为字符串（默认格式 {@value #PATTERN_DATETIME}）。
     *
     * @param dateTime 带时区的日期时间
     * @return 格式化后的字符串
     */
    public static String format(ZonedDateTime dateTime) {
        return format(dateTime, PATTERN_DATETIME);
    }

    /**
     * 将 {@link ZonedDateTime} 格式化为字符串（指定格式）。
     *
     * @param dateTime 带时区的日期时间
     * @param pattern  格式模板
     * @return 格式化后的字符串
     */
    public static String format(ZonedDateTime dateTime, String pattern) {
        return dateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    // ==================== 当前周的时间范围 ====================

    /**
     * 获取当前周的时间范围（周一 00:00:00 ~ 周日 23:59:59）。
     *
     * @return {@link TimeRange}&lt;{@link LocalDateTime}&gt;
     */
    public static TimeRange<LocalDateTime> currentWeekRange() {
        LocalDate today = LocalDate.now();
        LocalDate monday = today.with(DayOfWeek.MONDAY);
        LocalDate sunday = today.with(DayOfWeek.SUNDAY);
        return new TimeRange<>(monday.atStartOfDay(), sunday.atTime(LocalTime.MAX));
    }

    /**
     * 获取当前周的时间范围（毫秒时间戳表示）。
     *
     * @return {@link TimeRange}&lt;{@link Long}&gt;
     */
    public static TimeRange<Long> currentWeekRangeTimestamp() {
        TimeRange<LocalDateTime> range = currentWeekRange();
        return new TimeRange<>(toTimestamp(range.start()), toTimestamp(range.end()));
    }

    // ==================== 月份时间范围 ====================

    /**
     * 获取当前月的时间范围（1日 00:00:00 ~ 末日 23:59:59）。
     *
     * @return {@link TimeRange}&lt;{@link LocalDateTime}&gt;
     */
    public static TimeRange<LocalDateTime> currentMonthRange() {
        LocalDate today = LocalDate.now();
        return monthRange(today.getYear(), today.getMonthValue());
    }

    /**
     * 获取指定月的时间范围（1日 00:00:00 ~ 末日 23:59:59）。
     *
     * @param year  年份
     * @param month 月份（1 ~ 12）
     * @return {@link TimeRange}&lt;{@link LocalDateTime}&gt;
     */
    public static TimeRange<LocalDateTime> monthRange(int year, int month) {
        LocalDate start = LocalDate.of(year, month, 1);
        LocalDate end = start.with(TemporalAdjusters.lastDayOfMonth());
        return new TimeRange<>(start.atStartOfDay(), end.atTime(LocalTime.MAX));
    }

    /**
     * 获取当前月的时间范围（毫秒时间戳表示）。
     *
     * @return {@link TimeRange}&lt;{@link Long}&gt;
     */
    public static TimeRange<Long> currentMonthRangeTimestamp() {
        TimeRange<LocalDateTime> range = currentMonthRange();
        return new TimeRange<>(toTimestamp(range.start()), toTimestamp(range.end()));
    }

    /**
     * 获取指定月的时间范围（毫秒时间戳表示）。
     *
     * @param year  年份
     * @param month 月份（1 ~ 12）
     * @return {@link TimeRange}&lt;{@link Long}&gt;
     */
    public static TimeRange<Long> monthRangeTimestamp(int year, int month) {
        TimeRange<LocalDateTime> range = monthRange(year, month);
        return new TimeRange<>(toTimestamp(range.start()), toTimestamp(range.end()));
    }

    // ==================== 季度时间范围 ====================

    /**
     * 获取当前季度的时间范围。
     *
     * @return {@link TimeRange}&lt;{@link LocalDateTime}&gt;
     */
    public static TimeRange<LocalDateTime> currentQuarterRange() {
        LocalDate today = LocalDate.now();
        int quarter = (today.getMonthValue() - 1) / 3 + 1;
        return quarterRange(today.getYear(), quarter);
    }

    /**
     * 获取指定季度的时间范围（季度第一天 00:00:00 ~ 最后一天 23:59:59）。
     *
     * @param year    年份
     * @param quarter 季度（1 ~ 4）
     * @return {@link TimeRange}&lt;{@link LocalDateTime}&gt;
     */
    public static TimeRange<LocalDateTime> quarterRange(int year, int quarter) {
        int startMonth = (quarter - 1) * 3 + 1;
        LocalDate start = LocalDate.of(year, startMonth, 1);
        LocalDate end = start.plusMonths(2).with(TemporalAdjusters.lastDayOfMonth());
        return new TimeRange<>(start.atStartOfDay(), end.atTime(LocalTime.MAX));
    }

    /**
     * 获取当前季度的时间范围（毫秒时间戳表示）。
     *
     * @return {@link TimeRange}&lt;{@link Long}&gt;
     */
    public static TimeRange<Long> currentQuarterRangeTimestamp() {
        TimeRange<LocalDateTime> range = currentQuarterRange();
        return new TimeRange<>(toTimestamp(range.start()), toTimestamp(range.end()));
    }

    /**
     * 获取指定季度的时间范围（毫秒时间戳表示）。
     *
     * @param year    年份
     * @param quarter 季度（1 ~ 4）
     * @return {@link TimeRange}&lt;{@link Long}&gt;
     */
    public static TimeRange<Long> quarterRangeTimestamp(int year, int quarter) {
        TimeRange<LocalDateTime> range = quarterRange(year, quarter);
        return new TimeRange<>(toTimestamp(range.start()), toTimestamp(range.end()));
    }

    // ==================== 年份时间范围 ====================

    /**
     * 获取当前年的时间范围（1月1日 00:00:00 ~ 12月31日 23:59:59）。
     *
     * @return {@link TimeRange}&lt;{@link LocalDateTime}&gt;
     */
    public static TimeRange<LocalDateTime> currentYearRange() {
        return yearRange(LocalDate.now().getYear());
    }

    /**
     * 获取指定年的时间范围（1月1日 00:00:00 ~ 12月31日 23:59:59）。
     *
     * @param year 年份
     * @return {@link TimeRange}&lt;{@link LocalDateTime}&gt;
     */
    public static TimeRange<LocalDateTime> yearRange(int year) {
        LocalDate start = LocalDate.of(year, 1, 1);
        LocalDate end = LocalDate.of(year, 12, 31);
        return new TimeRange<>(start.atStartOfDay(), end.atTime(LocalTime.MAX));
    }

    /**
     * 获取当前年的时间范围（毫秒时间戳表示）。
     *
     * @return {@link TimeRange}&lt;{@link Long}&gt;
     */
    public static TimeRange<Long> currentYearRangeTimestamp() {
        TimeRange<LocalDateTime> range = currentYearRange();
        return new TimeRange<>(toTimestamp(range.start()), toTimestamp(range.end()));
    }

    /**
     * 获取指定年的时间范围（毫秒时间戳表示）。
     *
     * @param year 年份
     * @return {@link TimeRange}&lt;{@link Long}&gt;
     */
    public static TimeRange<Long> yearRangeTimestamp(int year) {
        TimeRange<LocalDateTime> range = yearRange(year);
        return new TimeRange<>(toTimestamp(range.start()), toTimestamp(range.end()));
    }

    // ==================== 扩展：日期边界 ====================

    /**
     * 获取指定日期的当天开始时间（00:00:00.000000000）。
     *
     * @param dateTime 目标日期时间
     * @return 当天开始时间
     */
    public static LocalDateTime startOfDay(LocalDateTime dateTime) {
        return dateTime.toLocalDate().atStartOfDay();
    }

    /**
     * 获取指定日期的当天结束时间（23:59:59.999999999）。
     *
     * @param dateTime 目标日期时间
     * @return 当天结束时间
     */
    public static LocalDateTime endOfDay(LocalDateTime dateTime) {
        return dateTime.toLocalDate().atTime(LocalTime.MAX);
    }

    // ==================== 扩展：偏移计算 ====================

    /**
     * 在指定 {@link LocalDateTime} 基础上加减天数。
     *
     * @param dateTime 起始时间
     * @param days     天数（负数表示向前偏移）
     * @return 偏移后的时间
     */
    public static LocalDateTime plusDays(LocalDateTime dateTime, long days) {
        return dateTime.plusDays(days);
    }

    /**
     * 在指定 {@link LocalDateTime} 基础上加减小时数。
     *
     * @param dateTime 起始时间
     * @param hours    小时数（负数表示向前偏移）
     * @return 偏移后的时间
     */
    public static LocalDateTime plusHours(LocalDateTime dateTime, long hours) {
        return dateTime.plusHours(hours);
    }

    /**
     * 在指定 {@link LocalDateTime} 基础上加减分钟数。
     *
     * @param dateTime 起始时间
     * @param minutes  分钟数（负数表示向前偏移）
     * @return 偏移后的时间
     */
    public static LocalDateTime plusMinutes(LocalDateTime dateTime, long minutes) {
        return dateTime.plusMinutes(minutes);
    }

    // ==================== 扩展：差值计算 ====================

    /**
     * 计算两个 {@link LocalDateTime} 之间相差的天数。
     *
     * @param start 起始时间（较早）
     * @param end   结束时间（较晚）
     * @return 相差天数（可为负数）
     */
    public static long daysBetween(LocalDateTime start, LocalDateTime end) {
        return ChronoUnit.DAYS.between(start, end);
    }

    /**
     * 计算两个 {@link LocalDateTime} 之间相差的小时数。
     *
     * @param start 起始时间
     * @param end   结束时间
     * @return 相差小时数（可为负数）
     */
    public static long hoursBetween(LocalDateTime start, LocalDateTime end) {
        return ChronoUnit.HOURS.between(start, end);
    }

    /**
     * 计算两个 {@link LocalDateTime} 之间相差的分钟数。
     *
     * @param start 起始时间
     * @param end   结束时间
     * @return 相差分钟数（可为负数）
     */
    public static long minutesBetween(LocalDateTime start, LocalDateTime end) {
        return ChronoUnit.MINUTES.between(start, end);
    }

    // ==================== 扩展：判断 ====================

    /**
     * 判断指定年份是否为闰年。
     *
     * @param year 年份
     * @return {@code true} 表示闰年
     */
    public static boolean isLeapYear(int year) {
        return Year.isLeap(year);
    }

    /**
     * 判断 {@link LocalDateTime} 是否为今天。
     *
     * @param dateTime 目标时间
     * @return {@code true} 表示是今天
     */
    public static boolean isToday(LocalDateTime dateTime) {
        return dateTime.toLocalDate().equals(LocalDate.now());
    }

    /**
     * 判断目标时间是否在 [start, end] 闭区间内。
     *
     * @param target 目标时间
     * @param start  区间起始（含）
     * @param end    区间结束（含）
     * @return {@code true} 表示在区间内
     */
    public static boolean isInRange(LocalDateTime target, LocalDateTime start, LocalDateTime end) {
        return !target.isBefore(start) && !target.isAfter(end);
    }

    /**
     * 判断两个 {@link LocalDateTime} 是否为同一天。
     *
     * @param a 第一个时间
     * @param b 第二个时间
     * @return {@code true} 表示同一天
     */
    public static boolean isSameDay(LocalDateTime a, LocalDateTime b) {
        return a.toLocalDate().equals(b.toLocalDate());
    }
}
