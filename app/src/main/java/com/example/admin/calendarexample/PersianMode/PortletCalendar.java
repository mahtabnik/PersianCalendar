package com.example.admin.calendarexample.PersianMode;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PortletCalendar {

    public PortletCalendar() {
    }

    public static String getCalTitle(Calendar cal) {
        Calendar _tmp = cal;
        Calendar _tmp1 = cal;
        Calendar _tmp2 = cal;
        int currYear[] = DateConvert.m2h(cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH) , cal.get(Calendar.YEAR));
        return (new StringBuilder()).append(currYear[0]).append(" ").append(
                DateConvert.hmonth2str(currYear[1])).append(", ").append(
                currYear[2]).toString();
    }

    public static String getMonth(Calendar cal) {
        Calendar _tmp = cal;
        Calendar _tmp1 = cal;
        Calendar _tmp2 = cal;
        int currYear[] = DateConvert.m2h(cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH) , cal.get(Calendar.YEAR));
        return (new StringBuilder()).append(DateConvert.hmonth2str(currYear[1])).
                append(", ").append(currYear[2]).toString();
    }

    public static String getWeek(int d, int m, int y) {
        return String.valueOf(DateConvert.hdifdate(1, 1, y, d, m, y) / 7 + 1);
    }

    public static int dayOfWeek(int d, int m, int y) {
        int l = DateConvert.hdifdate(1, 1, 1, d, m, y);
        return (l + 5) % 7;
    }

    public static int maxDayOfMonth(int m, int y) {
        if (m <= 6) {
            return 31;
        }
        return m != 12 || DateConvert.hleap_year(y) ? 30 : 29;
    }

    public static String getDate(Calendar cal) {
        Calendar _tmp = cal;
        Calendar _tmp1 = cal;
        Calendar _tmp2 = cal;
        int currYear[] = DateConvert.m2h(cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH) , cal.get(Calendar.YEAR));
        return (new StringBuilder()).append(currYear[0]).append("/").append(
                currYear[1]).append("/").append(currYear[2]).toString();
    }

    public static String getMD(Calendar cal) {
        Calendar _tmp = cal;
        Calendar _tmp1 = cal;
        Calendar _tmp2 = cal;
        int currYear[] = DateConvert.m2h(cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH) , cal.get(Calendar.YEAR));
        return (new StringBuilder()).append(currYear[0]).append("/").append(
                currYear[1]).toString();
    }

    public static String getDayOfWeek(Calendar cal) {
        Calendar _tmp = cal;
        Calendar _tmp1 = cal;
        Calendar _tmp2 = cal;
        int currYear[] = DateConvert.m2h(cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.MONTH) , cal.get(Calendar.YEAR));
        int l = DateConvert.hdifdate(1, 1, 1, currYear[0], currYear[1],
                                     currYear[2]);
        return DateConvert.hdayofweek2str((l + 5) % 7 + 1);
    }
    public static int getDayOfWeek(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy MM dd");
        String s = df.format(date);
        String currentdate[] = s.split(" ");
        int y = Integer.parseInt(currentdate[0]);
        int m = Integer.parseInt(currentdate[1]);
        int d = Integer.parseInt(currentdate[2]);

        int currYear[] = DateConvert.m2h(y, m , d);
        int l = DateConvert.hdifdate(1, 1, 1, currYear[0], currYear[1],
                currYear[2]);
        return ((l + 5) % 7 + 1);
    }
}
