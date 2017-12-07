package com.welkin.springboot.test.workDay;

import com.welkin.springboot.test.BaseTests;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class DateTests extends BaseTests {
    @Test
    public void workDayTest(){
        GetWorkDay g=new GetWorkDay();
        List<Date> initHoliday;
        try {
            initHoliday = g.initHoliday();
            double days = g.getWorkdayTimeInMillisExcWeekendHolidays("2017-12-07","2017-12- 08","yyyy-MM-dd",initHoliday);
            double formateToDay = g.formateToDay(days);
            String formatDuring = g.formatDuring(days);
            System.out.println(formateToDay);
            System.out.println(formatDuring);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Test
    public void workDayTest2(){

    }


}
