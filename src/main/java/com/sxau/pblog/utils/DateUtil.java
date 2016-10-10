package com.sxau.pblog.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gaohailong on 2016/10/9.
 */
public class DateUtil {
    public static String getCurrentDate() {
        //生成日期对象
        Date current_date = new Date();
        //设置日期格式化样式为：yyyy-MM-dd
        SimpleDateFormat SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //格式化当前日期
        return SimpleDateFormat.format(current_date.getTime());
    }
}
