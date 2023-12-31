package net.bi4vmr.study.utils.ch03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * Name        : DateTimeUtils
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@qq.com
 * <p>
 * Date        : 2022-11-20 11:24
 * <p>
 * Description : 时间与日期相关工具。
 */
public class DateTimeUtils {

    public static void main(String[] args) {
        example06();
    }

    static void example01() {
        long millis = System.currentTimeMillis();

        System.out.println("1970-1-1 00:00 距今的毫秒数:" + millis);
        long seconds = millis / 1000;
        System.out.println("1970-1-1 00:00 距今的秒数:" + seconds);
        long days = seconds / (60 * 60 * 24);
        System.out.println("1970-1-1 00:00 距今的天数:" + days);
    }

    static void example02() {
        // 创建Date对象，其时间值为代码执行的时刻。
        Date date1 = new Date();
        System.out.println(date1);

        // 获取"date1"的时间值，并增加1小时。
        Date date2 = new Date(date1.getTime() + (1000 * 3600));
        System.out.println(date2);
    }

    static void example03() {
        // 获取Calendar实例
        Calendar c = Calendar.getInstance();
        // 获取对应字段
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int min = c.get(Calendar.MINUTE);
        int sec = c.get(Calendar.SECOND);

        System.out.println("当前时间：" + year + "-" + month + "-" + day + " " + hour + ":" + min + ":" + sec);
    }

    static void example04() {
        // 创建SimpleDateFormat实例并指定格式
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 格式化当前日期
        System.out.println(s.format(new Date()));
    }

    static void example05() {
        SimpleDateFormat s = new SimpleDateFormat("yy/MM/dd HH:mm");
        // 需要转换的日期
        String input = "2000/1/1 00:00";

        try {
            Date d = s.parse(input);
            System.out.println(d);
        } catch (ParseException pe) {
            System.out.println("输入格式错误！");
        }
    }

    static void example06() {
        System.out.println(LocalDateTime.now());
        System.out.println();
    }
}
