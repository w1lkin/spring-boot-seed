package com.welkin.springbootseed.web.api;


import com.welkin.springbootseed.common.util.DateUtil;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author welkin
 * 2017年9月28日15:58:40
 */
public class DateParameter implements Serializable {

    public DateParameter() {}

    public static DateParameter valueOf(String dateString) {
        if(dateString == null || "".equals(dateString))
            return new DateParameter();
        Date date = DateUtil.dateStrParse(dateString, "yyyy-MM-dd");
        return new DateParameter(date);
    }

    private Date date;

    public Date getDate() {
        return date;
    }

    public Date getNextDay() {
        if(Objects.isNull(date)) {
            return null;
        }
        return DateUtil.addDay(date, 1);
    }

    public DateParameter(Date date) {
        this.date = date;
    }
}
