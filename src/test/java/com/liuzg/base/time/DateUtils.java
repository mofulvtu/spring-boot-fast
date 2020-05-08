package com.liuzg.base.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * <pre>
 *  Desc:  Java8日期、时间工具类
 * </pre>
 *
 * @author liuzg
 * @date  2020/4/23 21:54
 **/
public class DateUtils {


    /**
     * 格式化日期为字符串
     *
     * @param date    date
     * @param pattern 格式
     * @return 日期字符串
     */
    public static String format(Date date, String pattern) {
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 解析字符串日期为Date
     *
     * @param dateStr 日期字符串
     * @param pattern 格式
     * @return Date
     */
    public static Date parse(String dateStr, String pattern) {
        LocalDate localDateTime = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
        Instant instant = localDateTime.atStartOfDay(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    /**
     * LocalDateTime to Date
     *
     * @param localDateTime java.time.LocalDateTime
     * @return Date java.util.Date
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }

    /**
     * LocalDate to Date
     *
     * @param localDate java.time.LocalDate
     * @return Date java.util.Date
     */
    public static Date localDateToDate(LocalDate localDate) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
        return Date.from(zdt.toInstant());
    }

    /**
     *  strDate to LocalDate
     * @param strDate  字符串日期
     * @param pattern  格式
     * @return java.time.LocalDate
     */
    public static LocalDate strDateToLocalDate(String strDate,String pattern){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(strDate,formatter);
    }

}
