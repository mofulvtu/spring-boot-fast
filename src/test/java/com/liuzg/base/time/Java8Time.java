package com.liuzg.base.time;

import org.junit.Test;

import java.time.*;

import static java.time.temporal.ChronoUnit.*;

public class Java8Time {

    @Test
    public void testLocalDate() {
        LocalDate localDate = LocalDate.now();

        Month month = localDate.getMonth();
        int year = localDate.getYear();
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        int dayOfMonth = localDate.getDayOfMonth();
        int dayOfYear = localDate.getDayOfYear();
        int i = localDate.lengthOfMonth();
        int i1 = localDate.lengthOfYear();
        boolean leapYear = localDate.isLeapYear();

        System.out.println("LocalTime to LocalDateTime:" + localDate.atTime(LocalTime.now()));

        System.out.println("date:" + localDate);
        System.out.println("month:" + month);
        System.out.println("year:" + year);
        System.out.println("dayOfWeek:" + dayOfWeek);
        System.out.println("dayOfMonth:" + dayOfMonth);
        System.out.println("dayOfYear:" + dayOfYear);
        System.out.println("lengthOfMonth:" + i);
        System.out.println("lengthOfYear:" + i1);
        System.out.println("isLeapYear:" + leapYear);

        System.out.println("加法运算");
        System.out.println("当前：" + LocalDate.now());
        System.out.println("加1天：" + LocalDate.now().plusDays(1));
        System.out.println("加1周：" + LocalDate.now().plusWeeks(1));
        System.out.println("加1月：" + LocalDate.now().plusMonths(1));
        System.out.println("加1年：" + LocalDate.now().plusYears(1));

        System.out.println("减法运算");
        System.out.println("当前：" + LocalDate.now());
        System.out.println("减1天：" + LocalDate.now().minusDays(1));
        System.out.println("减1周：" + LocalDate.now().minusWeeks(1));
        System.out.println("减1月：" + LocalDate.now().minusMonths(1));
        System.out.println("减1年：" + LocalDate.now().minusYears(1));

        System.out.println("当前：" + LocalDate.now());
        System.out.println("替换日期为1：" + LocalDate.now().withDayOfMonth(1));
        System.out.println("替换天数为1：" + LocalDate.now().withDayOfYear(1));
        System.out.println("替换月份为1：" + LocalDate.now().withMonth(1));
        System.out.println("替换年份为1：" + LocalDate.now().withYear(1));

        System.out.println("当天：" + LocalDate.now());
        System.out.println("是否在当天之前：" + LocalDate.now().minusDays(1).isBefore(LocalDate.now()));
        System.out.println("是否在当天之后：" + LocalDate.now().plusDays(1).isAfter(LocalDate.now()));
        System.out.println("是否在当天：" + LocalDate.now().isEqual(LocalDate.now()));
        System.out.println("今年是否是闰年：" + LocalDate.now().isLeapYear());
    }


    @Test
    public void testLocalTime() {
        LocalTime localTime = LocalTime.now();
        System.out.println("localTime:" + localTime);
        System.out.println("hour:" + localTime.getHour());
        System.out.println("minute:" + localTime.getMinute());
        System.out.println("second:" + localTime.getSecond());
        System.out.println("nano:" + localTime.getNano());

        System.out.println("加1小时：" + localTime.plusHours(1));
        System.out.println("加1分钟：" + localTime.plusMinutes(1));
        System.out.println("加1秒：" + localTime.plusSeconds(1));
        System.out.println("加1纳秒：" + localTime.plusNanos(1));

        System.out.println("减1小时：" + localTime.minusHours(1));
        System.out.println("减1分钟：" + localTime.minusMinutes(1));
        System.out.println("减1秒：" + localTime.minusSeconds(1));
        System.out.println("减1纳秒：" + localTime.minusNanos(1));

        System.out.println("当前时间之前：" + localTime.isBefore(LocalTime.now()));
        System.out.println("当前时间之后：" + localTime.isAfter(LocalTime.now()));
        System.out.println("LocalDate to LocalDateTime ：" + localTime.atDate(LocalDate.now()));
    }

    @Test
    public void testLocalDateTime(){
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime:"+localDateTime);
    }

    @Test
    public void testInstant(){
        Instant instant = Instant.now();
        System.out.println("instant:"+instant);
        System.out.println("加1小时："+instant.plus(1, HOURS));
        System.out.println("加1分钟："+instant.plus(1, MINUTES));
        System.out.println("加1秒："+instant.plus(1, SECONDS));

        System.out.println("减1小时："+instant.minus(1, HOURS));
        System.out.println("减1分钟："+instant.minus(1, MINUTES));
        System.out.println("减1秒："+instant.minus(1, SECONDS));

    }

    @Test
    public void testDuration() {
        // Get duration between two dates
        LocalDateTime from = LocalDateTime.of(2019, Month.APRIL, 16, 0, 0, 0);
        LocalDateTime to = LocalDateTime.of(2020, Month.APRIL, 16, 23, 59, 59);

        Duration duration = Duration.between(from, to);
        System.out.println("Duration in days: " + duration.toDays());
        System.out.println("Duration in hours: " + duration.toHours());

    }

    @Test
    public void testClock() {
        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock);
        System.out.println(clock.getZone());

    }

    @Test
    public void testZoneDateTime(){
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("zoneDateTime: "+zonedDateTime);
    }

}
