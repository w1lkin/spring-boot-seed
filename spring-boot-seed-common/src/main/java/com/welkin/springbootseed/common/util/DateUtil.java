package com.welkin.springbootseed.common.util;

import com.welkin.springbootseed.common.ApiResponseCode;
import com.welkin.springbootseed.common.exception.BizException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * 时间工具类
 * @author welkin
 */
public class DateUtil {

  /**
   * * 将d转换成中国日期格式,如2016-1-22转成2016年1月22日
   *
   * @param d
   * @return
   */
  public static String getChineseDateStr(Date d) {
    Objects.requireNonNull(d);
    DateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
    return format.format(d);
  }

  public static String getDefaultDateStr(Date d) {
    Objects.requireNonNull(d);
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    return format.format(d);
  }

  /**
   * * 将日期字符串转换为java.util.Date类型
   *
   * @param dateStr
   * @param formatStr
   * @return
   * @throws ParseException
   */
  public static Date dateStrParse(String dateStr, String formatStr) {
    try {
      DateFormat format = new SimpleDateFormat(formatStr);
      return format.parse(dateStr);
    } catch (ParseException e) {
      BizException.fail(ApiResponseCode.UN_KNONW_ERROR, e.getMessage());
      return null;
    }
  }

  public static Date todayDate() {
    return toDate(new Date());
  }

  public static Date toDate(Date dateTime) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(dateTime);
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    return calendar.getTime();
  }

  public static String convertDateToStr(Date d, String formatStr) {
    Objects.requireNonNull(d);
    Objects.requireNonNull(formatStr);
    DateFormat format = new SimpleDateFormat(formatStr);
    return format.format(d);
  }

  public static Date clearTimeInfo(Date d) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(d);
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    return calendar.getTime();
  }

  public static Date addDays(Date d, int amount) {
    Objects.requireNonNull(d);
    Calendar cld = Calendar.getInstance();
    cld.setTime(d);
    cld.add(Calendar.DATE, amount);
    return cld.getTime();
  }

  public static Date addMinutes(Date d, int amount) {
    Objects.requireNonNull(d);
    Calendar cld = Calendar.getInstance();
    cld.setTime(d);
    cld.add(Calendar.MINUTE, amount);
    return cld.getTime();
  }

  public static Date addSeconds(Date d, int amount) {
    Objects.requireNonNull(d);
    Calendar cld = Calendar.getInstance();
    cld.setTime(d);
    cld.add(Calendar.SECOND, amount);
    return cld.getTime();
  }

  /**
   * 获取本月第一天
   *
   * @return
   */
  public static Date getFirstDayOfMonth() {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.MONTH, 0);
    calendar.set(Calendar.DAY_OF_MONTH, 1);
    return calendar.getTime();
  }

  /**
   * 获取本月最后一天
   *
   * @return
   */
  public static Date getLastDayOfMonth() {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.MONTH, 1);
    calendar.add(Calendar.DAY_OF_MONTH, -1);
    return calendar.getTime();
  }

  /**
   * 获取下月第一天
   *
   * @return
   */
  public static Date getFirstDayOfNextMonth() {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
    calendar.set(Calendar.DAY_OF_MONTH, 1);
    return calendar.getTime();
  }

  public static int getDaySub(Date beginDate, Date endDate) {
    long day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
    return (int) (day + 1);
  }

  /**
   * 两个日期之间的天数
   *
   * @param beginDate
   * @param endDate
   * @return
   */
  public static long betweenDays(Date beginDate, Date endDate) {
    LocalDate begin = dateToLocalDate(beginDate);
    LocalDate end = dateToLocalDate(endDate);
    return end.toEpochDay() - begin.toEpochDay();
  }

  /**
   * date 转 localDate
   *
   * @param date
   * @return
   */
  public static LocalDate dateToLocalDate(Date date) {
    Instant instant = date.toInstant();
    ZoneId zoneId = ZoneId.systemDefault();
    // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
    LocalDate localDate = instant.atZone(zoneId).toLocalDate();
    return localDate;
  }

  /**
   * localDate 转 date
   *
   * @param localDate
   * @return
   */
  public static Date localDateToDate(LocalDate localDate) {
    ZoneId zoneId = ZoneId.systemDefault();
    ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
    Date date = Date.from(zdt.toInstant());
    return date;
  }

  /**
   * 增加指定天数
   *
   * @param date
   * @param days
   * @return
   */
  public static LocalDate addDays(Date date, Integer days) {
    if (days == null) {
      days = 0;
    }
    LocalDate localDate = dateToLocalDate(date);
    return localDate.plusDays(days);
  }

  /**
   * 获取上周一
   *
   * @param date
   * @return
   */
  public static Date getLastWeekMonday(Date date) {
    Date a = DateUtil.addDays(date, -1);
    Calendar cal = Calendar.getInstance();
    cal.setTime(a);
    cal.add(Calendar.WEEK_OF_YEAR, -1); // 一周
    cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
    return cal.getTime();
  }

  /**
   * 获取上周日
   *
   * @param date
   * @return
   */
  public static Date getLastWeekSunday(Date date) {
    Date a = DateUtil.addDays(date, -1);
    Calendar cal = Calendar.getInstance();
    cal.setTime(a);
    cal.set(Calendar.DAY_OF_WEEK, 1);
    return cal.getTime();
  }
}
