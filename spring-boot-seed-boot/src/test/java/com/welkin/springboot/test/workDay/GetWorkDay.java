package com.welkin.springboot.test.workDay;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class GetWorkDay {
    /**
     * 获取两个时间之内的工作日时间（只去掉两个日期之间的周末时间，法定节假日未去掉）
     *
     * @param start
     * -起始时间，共有3个重载方法，可以传入long型，Long型，与Date型
     * @param end
     * -结束时间，共有3个重载方法，可以传入long型，Long型，与Date型
     * @return Long型时间差对象
     */
    /*public static void main(String[] args) {
        GetWorkDay g=new GetWorkDay();
        List<Date> initHoliday;
        try {
            initHoliday = g.initHoliday();
            double days = g.getWorkdayTimeInMillisExcWeekendHolidays("2016-06-30 17-12-53","2016-08-30 11-27-50","yyyy-MM-dd HH-mm-ss",initHoliday);
            double formateToDay = g.formateToDay(days);
            String formatDuring = g.formatDuring(days);
             System.out.println(formateToDay);
            System.out.println(formatDuring);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    } */

    private double getWorkdayTimeInMillis(long start, long end,
                                          List<Date> listHolidays) {

        // 如果起始时间大于结束时间，将二者交换
        if (start > end) {
            long temp = start;
            start = end;
            end = temp;
        }
        // 根据参数获取起始时间与结束时间的日历类型对象
        Calendar sdate = Calendar.getInstance();
        Calendar edate = Calendar.getInstance();

        sdate.setTimeInMillis(start);
        edate.setTimeInMillis(end);

        // 计算指定时间段内法定节假日天数的毫秒数
        long holidays = 0;
        if (listHolidays != null) {
            holidays = getHolidaysInMillis(start, end, listHolidays);
            listHolidays.clear();
        }

        // 如果两个时间在同一周并且都不是周末日期，则直接返回时间差，增加执行效率
        if ((sdate.get(Calendar.YEAR) == edate.get(Calendar.YEAR))
                && (sdate.get(Calendar.WEEK_OF_YEAR) == edate
                .get(Calendar.WEEK_OF_YEAR))
                && (sdate.get(Calendar.DAY_OF_WEEK) != 1 && sdate
                .get(Calendar.DAY_OF_WEEK) != 7)
                && (edate.get(Calendar.DAY_OF_WEEK) != 1 && edate
                .get(Calendar.DAY_OF_WEEK) != 7)) {
            return new Long(end - start - holidays);
        }
        // 如果两个时间在同一周并且都是周末日期，则直接返回0
        if ((sdate.get(Calendar.YEAR) == edate.get(Calendar.YEAR))
                && (sdate.get(Calendar.WEEK_OF_YEAR) == edate
                .get(Calendar.WEEK_OF_YEAR)-1)
                && (sdate.get(Calendar.DAY_OF_WEEK) == 1
                || sdate.get(Calendar.DAY_OF_WEEK) == 7)
                &&
                (edate.get(Calendar.DAY_OF_WEEK) == 1
                        || edate.get(Calendar.DAY_OF_WEEK) == 7)) {
            start=validateStartTime(sdate);
            end=validateEndTime(edate);
            long result=end - start - holidays;
            return new Long(result>0?result:0);
        }

        start=validateStartTime(sdate);
        end=validateEndTime(edate);

        // 首先取得起始日期与结束日期的下个周一的日期
        Calendar snextM = getNextMonday(sdate);
        Calendar enextM = getNextMonday(edate);

        // 获取这两个周一之间的实际天数
        int days = getDaysBetween(snextM, enextM);

        // 获取这两个周一之间的工作日数(两个周一之间的天数肯定能被7整除，并且工作日数量占其中的5/7)
        int workdays = days / 7 * 5;

        // 计算最终结果，具体为：workdays加上开始时间的时间偏移量，减去结束时间的时间偏移量
        double a=(double)workdays*24*3600000;
        double result = (a + calcWorkdayTimeInMillis(sdate, edate, start, end) - holidays);
        return result > 0 ? result : 0;
    }
    /***
     * 验证开始日期是否合法,如果不合法,并返回修复后的正确日期毫秒数
     * @param sdate
     * @return
     */
    private long validateStartTime(Calendar sdate){
        if(sdate.get(Calendar.DAY_OF_WEEK) == 1)//开始日期从周日开始,如果开始时间为周末，自动修复为下周的9：00开始
        {
            sdate.add(Calendar.DATE,1);
            sdate.setTimeInMillis(sdate.getTime().getTime()- //从9点开始
                    (((sdate.get(Calendar.HOUR_OF_DAY)-9) * 3600000)+ (sdate.get(Calendar.MINUTE) * 60000)+ (sdate.get(Calendar.SECOND) * 1000)));
        }else if(sdate.get(Calendar.DAY_OF_WEEK) == 7){//开始日期从周六开始
            sdate.add(Calendar.DATE,2);
            sdate.setTimeInMillis(
                    sdate.getTime().getTime()- //从9点开始,如果开始时间为周末，自动修复为下周的9：00开始
                            (((sdate.get(Calendar.HOUR_OF_DAY)-9) * 3600000)
                                    + (sdate.get(Calendar.MINUTE) * 60000)
                                    + (sdate.get(Calendar.SECOND) * 1000)));
        }
        return sdate.getTimeInMillis();
    }


    /***
     * 验证结束日期是否合法,如果不合法,并返回修复后的正确日期毫秒数
     * @param sdate
     * @return
     */
    private long validateEndTime(Calendar edate)
    {
        if(edate.get(Calendar.DAY_OF_WEEK) == 1)//结束日期是周日,如果结束日期是周六、周末自动修复为这周五18:00
        {
            edate.add(Calendar.DATE,-2);
            edate.setTimeInMillis(
                    edate.getTime().getTime()+
                            (18*3600000-((edate.get(Calendar.HOUR_OF_DAY) * 3600000)
                                    + (edate.get(Calendar.MINUTE) * 60000)
                                    + (edate.get(Calendar.SECOND) * 1000))));
        }else if(edate.get(Calendar.DAY_OF_WEEK) == 7){//结束日期是周六,如果结束日期是周六、周末自动修复为这周五18:00
            edate.add(Calendar.DATE,-1);
            edate.setTimeInMillis(
                    edate.getTime().getTime()+
                            (18*3600000-((edate.get(Calendar.HOUR_OF_DAY) * 3600000)
                                    + (edate.get(Calendar.MINUTE) * 60000)
                                    + (edate.get(Calendar.SECOND) * 1000))));}
        return edate.getTimeInMillis();
    }
    /***
     * 计算两个日期间的工作日天数，除周六日
     *
     * @param sdate
     * @param edate
     * @return
     */
    private long calcWorkdayTimeInMillis(Calendar sdate, Calendar edate,long start, long end) {
        // 获取开始时间的偏移量
        long scharge = 0;
        if (sdate.get(Calendar.DAY_OF_WEEK) != 1
                && sdate.get(Calendar.DAY_OF_WEEK) != 7) {
            // 只有在开始时间为非周末的时候才计算偏移量
            scharge += (sdate.get(Calendar.HOUR_OF_DAY) * 3600000);
            scharge += (sdate.get(Calendar.MINUTE) * 60000);
            scharge += (sdate.get(Calendar.SECOND) * 1000);
            scharge = ((24 * 3600000) - scharge);

            scharge += ((sdate.getTime().getTime() - start) - (3 * 24 * 3600000));
        }
        // (24*3600000=86400000)-((9*3600000+1800000)=34200000)+(3*24*3600000=259200000)-(2*24*3600000)=
        // 86400000-34200000=52200000
        // 获取结束时间的偏移量
        long echarge = 0;
        if (edate.get(Calendar.DAY_OF_WEEK) != 1
                && edate.get(Calendar.DAY_OF_WEEK) != (7)) {
            // 只有在结束时间为非周末的时候才计算偏移量
            echarge += (edate.get(Calendar.HOUR_OF_DAY) * 3600000);
            echarge += (edate.get(Calendar.MINUTE) * 60000);
            echarge += (edate.get(Calendar.SECOND) * 1000);
            echarge = ((24 * 3600000) - echarge);
            echarge += (edate.getTime().getTime() - end) - (24 * 3600000);
            echarge -= (2 * 24 * 3600000);
        }
        // (24*3600000=86400000)-(18*3600000=64800000)+(24*3=259200000)
        if (scharge < 0 || echarge < 0)
            scharge = echarge = 0;
        return scharge - echarge;
    }

    /**
     * 获取两个时间之内的工作日时间（只去掉两个日期之间的周末时间，法定节假日未去掉）
     *
     * @param start
     * -起始时间，共有3个重载方法，可以传入long型，Long型，与Date型
     * @param end
     * -结束时间，共有3个重载方法，可以传入long型，Long型，与Date型
     * @return Long型时间差对象
     */
    public double getWorkdayTimeInMillisExcWeekend(long start, long end) {
        return getWorkdayTimeInMillis(start, end);
    }

    /***
     * 获取两个时间之内的工作日时间（去掉两个日期之间的周末时间，法定节假日时间）
     *
     * @param start
     * @param end
     * @return
     */
    public double getWorkdayTimeInMillisExcWeekendHolidays(String start,String end, String format, List<Date> listHolidays) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date sdate;
        Date edate;
        try {
            sdate = sdf.parse(start);
            edate = sdf.parse(end);
            return getWorkdayTimeInMillis(sdate.getTime(), edate.getTime(),
                    listHolidays);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Long(0);
        }
    }

    public double getWorkdayTimeInMillis(Long start, Long end) {
        return getWorkdayTimeInMillis(start.longValue(), end.longValue(), null);
    }

    public double getWorkdayTimeInMillis(Date start, Date end) {
        return getWorkdayTimeInMillis(start.getTime(), end.getTime(), null);
    }

    public double getWorkdayTimeInMillis(String start, String end, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date sdate;
        Date edate;
        try {
            sdate = sdf.parse(start);
            edate = sdf.parse(end);
            return getWorkdayTimeInMillis(sdate, edate);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Long(0);
        }
    }

    private long getHolidaysInMillis(long start, long end,
                                     List<Date> listHolidays) {
        Calendar scalendar = Calendar.getInstance();
        Calendar ecalendar = Calendar.getInstance();
        int daysofH = 0;
        try {

            scalendar.setTimeInMillis(start);
            ecalendar.setTimeInMillis(end);

            if (listHolidays == null)
                return new Long(0);
            Iterator<Date> iterator = listHolidays.iterator();
            while (iterator.hasNext()) {
                Calendar ca = Calendar.getInstance();
                Date hdate = iterator.next();
                ca.setTime(hdate);
                if (ca.after(scalendar) && ca.before(ecalendar)) {
                    daysofH = daysofH + 1;
                } else if (ca.getTimeInMillis() == scalendar.getTimeInMillis()) {
                    daysofH = daysofH + 1;
                } else if (ca.getTimeInMillis() == ecalendar.getTimeInMillis()) {
                    daysofH = daysofH + 1;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new Long(0);
        }
        return daysofH * 24 * 3600000;
    }


    private Calendar getNextMonday(Calendar cal) {
        int addnum = 9 - cal.get(Calendar.DAY_OF_WEEK);
        if (addnum == 8)
            addnum = 1;// 周日的情况
        cal.add(Calendar.DATE, addnum);
        return cal;
    }

    /**
     *
     * @param mss
     * @param 要转换的毫秒数
     * @return 该毫秒数转换为 * days * hours * minutes * seconds 后的格式
     */
    public String formatDuring(double mss) {
        long days = (long) (mss / (1000 * 60 * 60 * 24));
        long hours = (long) ((mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
        long minutes = (long) ((mss % (1000 * 60 * 60)) / (1000 * 60));
        long seconds = (long) ((mss % (1000 * 60)) / 1000);
        return days + " days " + hours + " hours " + minutes + " minutes "
                + seconds + " seconds ";
    }

    /**
     * 获取两个日期之间的实际天数，支持跨年
     * @param start
     * @param end
     *
     */
    /**
     * 获得两个日期之间的工作日
     * @since 1.0
     * @param mss
     * @return
     * <br><b>作者： @author zhushunagshuang</b>
     * <br>创建时间：2016年7月21日 下午3:12:23
     */
    public double formateToDay(double mss){
        double days = mss / (1000 * 60 * 60 * 24);
        return days;
    }

    public int getDaysBetween(Calendar start, Calendar end) {
        if (start.after(end)) {
            Calendar swap = start;
            start = end;
            end = swap;
        }

        int days = end.get(Calendar.DAY_OF_YEAR)- start.get(Calendar.DAY_OF_YEAR);
        int y2 = end.get(Calendar.YEAR);
        if (start.get(Calendar.YEAR) != y2) {
            start = (Calendar) start.clone();
            do {
                days += start.getActualMaximum(Calendar.DAY_OF_YEAR);
                start.add(Calendar.YEAR, 1);
            } while (start.get(Calendar.YEAR) != y2);

        }
        return days;
    }
    /**
     * 手动维护2016年的节假日
     * @since 1.0
     * @return
     * @throws ParseException
     * <br><b>作者： @author zhushunagshuang</b>
     * <br>创建时间：2016年7月21日 下午5:12:08
     */
    public List<Date> initHoliday() throws ParseException{
        List<Date> holidays = new ArrayList<Date>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //元旦
        holidays.add(sdf.parse("2016-01-01"));
        holidays.add(sdf.parse("2016-01-02"));
        holidays.add(sdf.parse("2016-01-03"));
        //春节
        holidays.add(sdf.parse("2016-02-07"));
        holidays.add(sdf.parse("2016-02-08"));
        holidays.add(sdf.parse("2016-02-09"));
        holidays.add(sdf.parse("2016-02-10"));
        holidays.add(sdf.parse("2016-02-11"));
        holidays.add(sdf.parse("2016-02-12"));
        holidays.add(sdf.parse("2016-02-13"));
        //清明节
        holidays.add(sdf.parse("2016-04-02"));
        holidays.add(sdf.parse("2016-04-03"));
        holidays.add(sdf.parse("2016-04-04"));
        //劳动节
        holidays.add(sdf.parse("2016-04-30"));
        holidays.add(sdf.parse("2016-05-01"));
        holidays.add(sdf.parse("2016-05-02"));
        //端午节
        holidays.add(sdf.parse("2016-06-09"));
        holidays.add(sdf.parse("2016-06-10"));
        holidays.add(sdf.parse("2016-06-11"));
        //中秋节
        holidays.add(sdf.parse("2016-09-15"));
        holidays.add(sdf.parse("2016-09-16"));
        holidays.add(sdf.parse("2016-09-17"));
        //国庆节
        holidays.add(sdf.parse("2016-10-01"));
        holidays.add(sdf.parse("2016-10-02"));
        holidays.add(sdf.parse("2016-10-03"));
        holidays.add(sdf.parse("2016-10-04"));
        holidays.add(sdf.parse("2016-10-05"));
        holidays.add(sdf.parse("2016-10-06"));
        holidays.add(sdf.parse("2016-10-07"));
        return holidays;
    }
}
