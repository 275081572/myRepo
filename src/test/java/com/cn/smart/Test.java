package com.cn.smart;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

public class Test {

    @org.junit.Test
    public void test(){
        for(int i = 29; i >= 0; i--){
            DateTime yesterday = DateUtil.yesterday();
            DateTime offsetDay = DateUtil.offsetDay(yesterday, -1 * i);
            System.out.println(offsetDay);
            System.out.println(getDateStr(offsetDay));
            System.out.println("--------");
        }
//        DateTime yesterday = DateUtil.yesterday();
//        String formatDate = DateUtil.formatDate(yesterday);
//        DateTime tomorrow = DateUtil.yesterday();
//        System.out.println(tomorrow);
//        DateTime newDate3 = DateUtil.offsetDay(tomorrow, 0);
//        String format = DateUtil.format(newDate3, "yyyy-MM-dd");
//        System.out.println(format);
    }

    private String getDateStr(DateTime offsetDay){
        String format = DateUtil.format(offsetDay, "yyyy-MM-dd");
        String[] split = format.split("-");
        return split[1] + "." + split[2];
    }

    @org.junit.Test
    public void test1(){
        DateTime now = DateUtil.date();
        Date beginOfDay = DateUtil.beginOfDay(now);
        for(int i = 0; i < 24; i++){
            DateTime offsetHour = DateUtil.offsetHour(beginOfDay, 1 * i);
            String timeStr = getTimeStr(offsetHour);
            System.out.println(offsetHour);
            System.out.println(timeStr);
            System.out.println("--------");
        }
    }

    private String getTimeStr(DateTime offsetDay){
        String format = DateUtil.format(offsetDay, "yyyy-MM-dd HH:mm:ss.SSS");
        return format.substring(11, 13) + ":00";
    }
}
