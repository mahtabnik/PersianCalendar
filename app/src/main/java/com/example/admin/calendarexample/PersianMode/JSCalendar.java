package com.example.admin.calendarexample.PersianMode;

import java.text.SimpleDateFormat;
import java.util.Date;
 
public class JSCalendar {

    public JSCalendar() {
    }

    public static int[] rangeYear(int year) {
        Date today = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy MM dd");
        String s = df.format(today);
        String currentdate[] = s.split(" ");
        int m = Integer.parseInt(currentdate[1]);
        int d = Integer.parseInt(currentdate[2]);
        return DateConvert.m2h(d, m, year);
    }
}
