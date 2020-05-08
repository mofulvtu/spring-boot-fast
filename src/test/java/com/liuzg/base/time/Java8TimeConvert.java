package com.liuzg.base.time;

import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Java8TimeConvert {

    @Test
    public void testDateTimeFormatter(){

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();

        String dateStr1 = formatter1.format(localDate);
        String dateStr2 = formatter2.format(localDate);
        System.out.println("LocalDate to dateStr(yyyy/MM/dd):"+dateStr1);
        System.out.println("LocalDate to dateStr(yyyy-MM-dd):"+dateStr2);
        String format = localDate.format(formatter1);
        System.out.println("LocalDate to dateStr(yyyy/MM/dd):"+format);
        LocalDate localDate1 = LocalDate.parse(dateStr1, formatter1);
        LocalDate localDate2 = LocalDate.parse(dateStr2, formatter2);
        System.out.println("dateStr to LocalDate:"+localDate1);
        System.out.println("dateStr to LocalDate:"+localDate2);


        String yyyyMMdd = DateUtils.format(new Date(), "yyyyMMdd");
        System.out.println("yyyyMMdd:"+yyyyMMdd);
        Date parse = DateUtils.parse("2020-02-23", "yyyy-MM-dd");
        System.out.println("yyyy-MM-dd:"+parse);

    }
}
