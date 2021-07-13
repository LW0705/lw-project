package com.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: 鼠宣伟
 * @Date: 2021/6/1
 * @Description: com.common.util
 * @version: 1.0
 */
public class DateUtils {

    public final static String BASE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public final static String DATE_FORMAT_MTH = "yyyyMM";

    /**
     * 根据指定的格式化规范显示时间
     * Date-->String
     *
     * @param date
     * @param format
     * @return
     */
    public static String date2Str(Date date, String format) {
        if (date == null || EmptyUtils.isEmpty(format)) {
            return "";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    /**
     * 根据指定的格式化规范显示时间
     * String-->Date
     *
     * @param dateStr
     * @return
     */
    public static Date str2Date(String dateStr) {
        if (EmptyUtils.isEmpty(dateStr)) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(BASE_FORMAT);
        try {
            return simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
