package com.mezo.athena.admin.common.util;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * @author qzrs
 */
public class DateTimeUtils {

    public static final String DEFAUT_FORMAT = "yyyy-MM-dd";


    public static String dateToString(Date date) {

        return dateToString(date, DEFAUT_FORMAT);
    }

    public static String dateToString(Date date, String format) {
        return DateFormatUtils.format(date, format);
    }

    public static String timeToString(Date date) {

        return timeToString(date, DEFAUT_FORMAT);
    }

    public static String timeToString(Date date, String format) {
        return DateFormatUtils.format(date, format);
    }
}
