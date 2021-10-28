package com.zsh.www.tools;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author zsh
 * @description 日期工具类 常规写法.不想自己写可使用第三方工具包(common-util)github自行选择
 * @date 2021/10/27
 */
public class DateTools {
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String TIME_FORMAT = "hh:mm:ss";
    private static final String DATE_TIME_FORMAT = DATE_FORMAT + " " + TIME_FORMAT;

    /**
     * 获取当前时间，返回string类型
     *
     * @return
     */
    public static String now() {
        return now(DATE_TIME_FORMAT);
    }

    public static String now(String format) {
        return dateToString(LocalDateTime.now(), format);
    }

    public static String nowDate() {
        return nowDate(DATE_FORMAT);
    }

    public static String nowDate(String format) {
        return dateToString(LocalDate.now(), format);
    }

    public static String dateToString(LocalDate localDate, String format) {
        return localDateFormat(localDate, format);
    }

    public static String dateToString(LocalDateTime localDate, String format) {
        return localDateTimeFormat(localDate, format);
    }

    public static String dateToString(Date date, String format) {
        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        return dateToString(localDateTime, format);
    }

    public static String localDateFormat(LocalDate localDate, String format) {
        return pattern(format).format(localDate);
    }

    public static LocalDate localDateFormat(String localDate, String format) {
        return LocalDate.parse(localDate, pattern(format));
    }

    public static LocalDateTime localDateTimeFormat(String localDateTime, String format) {
        return LocalDateTime.parse(localDateTime, pattern(format));
    }

    public static String localDateTimeFormat(LocalDateTime localDateTime, String format) {
        return localDateTime.format(pattern(format));
    }

    /**
     * @param date   字符串日期
     * @param format 转换格式
     * @return 返回日期格式
     */
    public static Date dateFormat(String date, String format) {
        return null;
    }

    /**
     * @param date   日期
     * @param format 转换格式
     * @return 返回string字符串
     */
    public static String dateFormat(Date date, String format) {
        return localDateFormat(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), format);
    }

    /**
     * @param timestamp 时间戳
     * @param format    转换格式
     * @return 返回string字符串
     */
    public static String timestampFormat(long timestamp, String format) {
        return null;
    }

    /**
     * @param timestamp timestamp 时间戳
     * @param format    format 转换格式
     * @return 返回date日期
     */
    public static Date timestampToDate(long timestamp, String format) {
        return null;
    }


    /**
     * @param date   日期（字符串）
     * @param format 转换格式
     * @return 时间戳
     */
    public static long timestampFormat(String date, String format) {
        return DateTools.dateToTimestamp(null, null);
    }

    /**
     * @param date   日期
     * @param format 转换格式
     * @return 时间戳
     */
    public static long dateToTimestamp(Date date, String format) {
        return 0;
    }

    public static DateTimeFormatter pattern(String format) {
        return DateTimeFormatter.ofPattern(format);
    }
}
