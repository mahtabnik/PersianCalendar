package com.example.admin.calendarexample.PersianMode;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateConvert {

    public DateConvert() {
    }

    public static String hmonth2str(int m) {
        String months[] = {
                          "\u0641\u0631\u0648\u0631\u062F\u064A\u0646",
                          "\u0627\u0631\u062F\u064A\u0628\u0647\u0634\u062A",
                          "\u062E\u0631\u062F\u0627\u062F",
                          "\u062A\u064A\u0631",
                          "\u0645\u0631\u062F\u0627\u062F",
                          "\u0634\u0647\u0631\u064A\u0648\u0631",
                          "\u0645\u0647\u0631", "\u0622\u0628\u0627\u0646",
                          "\u0622\u0630\u0631", "\u062F\u064A",
                          "\u0628\u0647\u0645\u0646",
                          "\u0627\u0633\u0641\u0646\u062F"
        };
        if (m <= 12 && m >= 1) {
            return months[m - 1];
        } else {
            return "";
        }
    }

    public static String mmonth2str(int m) {
        String months[] = {
                          "Junary", "February", "March", "April", "May", "June",
                          "July", "August", "September", "October",
                          "November", "December"
        };
        if (m <= 12 && m >= 1) {
            return months[m - 1];
        } else {
            return "";
        }
    }

    public static String hdayofweek2str(int wd) {
        String weekdays[] = {
                            "\u064A\u0643 \u0634\u0646\u0628\u0647",
                            "\u062F\u0648 \u0634\u0646\u0628\u0647",
                            "\u0633\u0647 \u0634\u0646\u0628\u0647",
                            "\u0686\u0647\u0627\u0631 \u0634\u0646\u0628\u0647",
                            "\u067E\u0646\u062C \u0634\u0646\u0628\u0647",
                            "\u062C\u0645\u0639\u0647",
                            "\u0634\u0646\u0628\u0647"
        };
        if (wd <= 7 && wd >= 1) {
            return weekdays[wd - 1];
        } else {
            return "";
        }
    }

    public static String mdayofweek2str(int wd) {
        String weekdays[] = {
                            "Sunday", "Monday", "Thuesday", "Wednesday",
                            "Thursday", "Friday", "Saturday"
        };
        if (wd <= 7 && wd >= 1) {
            return weekdays[wd - 1];
        } else {
            return "";
        }
    }

    public static boolean mleap_year(int y) {
        if (y % 100 != 0) {
            return y % 4 == 0;
        }
        int i = y / 100;
        return i % 4 == 0 && i >= 16;
    }

    public static boolean hleap_year(int y) {
        int x3 = y;
        int x1 = (x3 + 38) * 31;
        int x2 = x1 % 128;
        return x2 <= 30;
    }

    public static int hdate2day(int d, int m, int y) {
        if (m >= 1 && m <= 6) {
            return (m - 1) * 31 + d;
        }
        if (m >= 7 && m <= 11) {
            return 186 + (m - 7) * 30 + d;
        }
        if (m == 12) {
            return 336 + d;
        } else {
            return 0;
        }
    }

    public static int hdifdate(int d1, int m1, int y1, int d2, int m2, int y2) {
        int hy;
        int hm;
        int hd;
        int ly;
        int lm;
        int ld;
        if (y1 > y2) {
            hy = y1;
            hm = m1;
            hd = d1;
            ly = y2;
            lm = m2;
            ld = d2;
        } else
        if (y1 < y2) {
            ly = y1;
            lm = m1;
            ld = d1;
            hy = y2;
            hm = m2;
            hd = d2;
        } else
        if (m1 > m2) {
            hy = y1;
            hm = m1;
            hd = d1;
            ly = y2;
            lm = m2;
            ld = d2;
        } else
        if (m1 < m2) {
            ly = y1;
            lm = m1;
            ld = d1;
            hy = y2;
            hm = m2;
            hd = d2;
        } else
        if (d1 > d2) {
            hy = y1;
            hm = m1;
            hd = d1;
            ly = y2;
            lm = m2;
            ld = d2;
        } else
        if (d1 < d2) {
            ly = y1;
            lm = m1;
            ld = d1;
            hy = y2;
            hm = m2;
            hd = d2;
        } else {
            return 0;
        }
        if (hy == ly) {
            int x1 = hdate2day(hd, hm, hy);
            int x2 = hdate2day(ld, lm, ly);
            return x1 - x2;
        }
        int xn2 = 0;
        int xn = 365;
        if (hleap_year(ly)) {
            xn = 366;
        }
        int x1 = hdate2day(ld, lm, ly);
        int x2 = hdate2day(hd, hm, hy);
        for (int yn = ly + 1; yn <= hy - 1; yn++) {
            if (hleap_year(yn)) {
                xn2 += 366;
            } else {
                xn2 += 365;
            }
        }

        return (xn - x1) + x2 + xn2;
    }

    public static int[] hday2date(int years, int days) {
        int y;
        int d;
        int m = d = y = years;
        if (days >= 1 && days <= 31) {
            m = 1;
            d = days;
        } else
        if (days >= 32 && days <= 62) {
            m = 2;
            d = days - 31;
        } else
        if (days >= 63 && days <= 93) {
            m = 3;
            d = days - 62;
        } else
        if (days >= 94 && days <= 124) {
            m = 4;
            d = days - 93;
        } else
        if (days >= 125 && days <= 155) {
            m = 5;
            d = days - 124;
        } else
        if (days >= 156 && days <= 186) {
            m = 6;
            d = days - 155;
        } else
        if (days >= 187 && days <= 216) {
            m = 7;
            d = days - 186;
        } else
        if (days >= 217 && days <= 246) {
            m = 8;
            d = days - 216;
        } else
        if (days >= 247 && days <= 276) {
            m = 9;
            d = days - 246;
        } else
        if (days >= 277 && days <= 306) {
            m = 10;
            d = days - 276;
        } else
        if (days >= 307 && days <= 336) {
            m = 11;
            d = days - 306;
        } else
        if (days >= 337 && days <= 367) {
            m = 12;
            d = days - 336;
        }
        int array[] = {
                      d, m, y
        };
        return array;
    }

    public static int[] mday2date(int years, int days) {
        int y1 = years;
        int y = y1;
        int d1 = 0;
        int d = 0;
        int m = 0;
        boolean b = true;
        for (int i = 1; i <= 12 && b; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10) {
                if (d1 + 31 < days) {
                    d1 += 31;
                } else {
                    m = i;
                    d = days - d1;
                    b = false;
                }
                continue;
            }
            if (i == 4 || i == 6 || i == 9 || i == 11) {
                if (d1 + 30 < days) {
                    d1 += 30;
                } else {
                    m = i;
                    d = days - d1;
                    b = false;
                }
                continue;
            }
            if (i == 2) {
                if (mleap_year(y1)) {
                    if (d1 + 29 < days) {
                        d1 += 29;
                    } else {
                        m = i;
                        d = days - d1;
                        b = false;
                    }
                    continue;
                }
                if (d1 + 28 < days) {
                    d1 += 28;
                } else {
                    m = i;
                    d = days - d1;
                    b = false;
                }
            } else {
                d = days - d1;
                m = i;
            }
        }

        int array[] = {
                      d, m, y
        };
        return array;
    }

    public static int mdate2day(int d, int m, int y) {
        int days = 0;
        for (int i = 1; i <= m - 1; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10) {
                days += 31;
                continue;
            }
            if (i == 4 || i == 6 || i == 9 || i == 11) {
                days += 30;
                continue;
            }
            int y1 = y;
            if (mleap_year(y1)) {
                days += 29;
            } else {
                days += 28;
            }
        }

        days += d;
        return days;
    }

    public static int mdifdate(int d1, int m1, int y1, int d2, int m2, int y2) {
        int hy;
        int hm;
        int hd;
        int ly;
        int lm;
        int ld;
        if (y1 > y2) {
            hy = y1;
            hm = m1;
            hd = d1;
            ly = y2;
            lm = m2;
            ld = d2;
        } else
        if (y1 < y2) {
            ly = y1;
            lm = m1;
            ld = d1;
            hy = y2;
            hm = m2;
            hd = d2;
        } else
        if (m1 > m2) {
            hy = y1;
            hm = m1;
            hd = d1;
            ly = y2;
            lm = m2;
            ld = d2;
        } else
        if (m1 < m2) {
            ly = y1;
            lm = m1;
            ld = d1;
            hy = y2;
            hm = m2;
            hd = d2;
        } else
        if (d1 > d2) {
            hy = y1;
            hm = m1;
            hd = d1;
            ly = y2;
            lm = m2;
            ld = d2;
        } else
        if (d1 < d2) {
            ly = y1;
            lm = m1;
            ld = d1;
            hy = y2;
            hm = m2;
            hd = d2;
        } else {
            return 0;
        }
        int x1;
        int x2;
        if (hy == ly) {
            x1 = mdate2day(hd, hm, hy);
            x2 = mdate2day(ld, lm, ly);
            return x1 - x2;
        }
        int xn2 = 0;
        int xn;
        if (mleap_year(ly)) {
            xn = 366;
        } else {
            xn = 365;
        }
        x1 = mdate2day(ld, lm, ly);
        x2 = mdate2day(hd, hm, hy);
        for (int yn = ly + 1; yn <= hy - 1; yn++) {
            if (mleap_year(yn)) {
                xn2 += 366;
            } else {
                xn2 += 365;
            }
        }

        return (xn - x1) + x2 + xn2;
    }

    public static int[] hndifdate(int days, int d, int m, int y) {
        int x1;
        int yn;
        int ylen;
        if (days >= 0) {
            x1 = hdate2day(d, m, y);
            x1 += days;
            yn = y;
            do {
                do {
                    if (hleap_year(yn)) {
                        ylen = 366;
                    } else {
                        ylen = 365;
                    }
                    if (x1 <= ylen) {
                        break;
                    }
                    x1 -= ylen;
                    yn++;
                } while (true);
            } while (x1 > ylen);
            return hday2date(yn, x1);
        }
        if (hleap_year(y)) {
            ylen = 366;
        } else {
            ylen = 365;
        }
        x1 = Math.abs(days) + (ylen - hdate2day(d, m, y) - 1);
        yn = y;
        do {
            do {
                if (hleap_year(yn)) {
                    ylen = 366;
                } else {
                    ylen = 365;
                }
                if (x1 < ylen) {
                    break;
                }
                x1 -= ylen;
                yn--;
            } while (true);
        } while (x1 >= ylen);
        x1 = ylen - x1;
        return hday2date(yn, x1);
    }

    public static int[] mndifdate(int days, int d, int m, int y) {
        int res1[] = new int[3];
        int ylen;
        int yn;
        int x1;
        if (days >= 0) {
            x1 = mdate2day(d, m, y);
            x1 += days;
            yn = y;
            do {
                do {
                    if (mleap_year(yn)) {
                        ylen = 366;
                    } else {
                        ylen = 365;
                    }
                    if (x1 <= ylen) {
                        break;
                    }
                    x1 -= ylen;
                    yn++;
                } while (true);
            } while (x1 > ylen);
            res1 = mday2date(yn, x1);
            return res1;
        }
        if (mleap_year(y)) {
            ylen = 366;
        } else {
            ylen = 365;
        }
        x1 = days + (ylen - mdate2day(d, m, y));
        yn = y;
        do {
            do {
                if (mleap_year(yn)) {
                    ylen = 366;
                } else {
                    ylen = 365;
                }
                if (x1 < ylen) {
                    break;
                }
                x1 -= ylen;
                yn--;
            } while (true);
        } while (x1 >= ylen);
        x1 = ylen - x1;
        res1 = mday2date(yn, x1);
        return res1;
    }

    public static int[] h2m(int din, int min, int yin) {
        int x1 = hdifdate(din, min, yin, 1, 1, 1);
        int res[] = mndifdate(x1, 20, 3, 622);
        return res;
    }

    public static int[] m2h(int din, int min, int yin) {
        int x1 = mdifdate(din, min, yin, 20, 3, 622);
        int res[] = hndifdate(x1, 1, 1, 1);
        return res;
    }

    public static boolean hIsValiddate(int d, int m, int y) {
        boolean r;
        if (m < 1 || m > 12) {
            r = false;
        } else {
            r = true;
        }
        if (m >= 1 && m <= 6) {
            if (d >= 1 && d <= 31) {
                r = true;
            } else {
                r = false;
            }
        } else
        if (m >= 7 && m <= 11) {
            if (d >= 1 && d <= 30) {
                r = true;
            } else {
                r = false;
            }
        } else
        if (m == 12) {
            if (hleap_year(y)) {
                if (d >= 1 && d <= 30) {
                    r = true;
                } else {
                    r = false;
                }
            } else
            if (d >= 1 && d <= 29) {
                r = true;
            } else {
                r = false;
            }
        }
        return r;
    }

    public static boolean mIsValiddate(int d, int m, int y) {
        boolean r;
        if (m < 1 || m > 12) {
            r = false;
        } else {
            r = true;
        }
        if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 ||
            m == 12) {
            if (d >= 1 && d <= 31) {
                r = true;
            } else {
                r = false;
            }
        } else
        if (m == 4 || m == 6 || m == 9 || m == 11) {
            if (d >= 1 && d <= 30) {
                r = true;
            } else {
                r = false;
            }
        } else
        if (m == 2) {
            if (mleap_year(y)) {
                if (d >= 1 && d <= 29) {
                    r = true;
                } else {
                    r = false;
                }
            } else
            if (d >= 1 && d <= 28) {
                r = true;
            } else {
                r = false;
            }
        }
        return r;
    }

    public static String dateString(String inString) {
        int k = 0;
        int j = 1;
        inString = inString.trim();
        if (inString.equals("")) {
            return "";
        }
        String ys = "";
        String ms = "";
        String ds = "";
        for (int i = 0; i < inString.length(); i++) {
            if (inString.charAt(i) <= '9' && inString.charAt(i) >= '0') {
                if (k == 0 && j <= 4) {
                    ys = (new StringBuilder()).append(ys).append(inString.
                            charAt(i)).toString();
                    j++;
                    continue;
                }
                if (k == 1 && j <= 2) {
                    ms = (new StringBuilder()).append(ms).append(inString.
                            charAt(i)).toString();
                    j++;
                    continue;
                }
                if (k == 2 && j <= 2) {
                    ds = (new StringBuilder()).append(ds).append(inString.
                            charAt(i)).toString();
                    j++;
                }
                continue;
            }
            if (inString.charAt(i) == '/' || inString.charAt(i) == '.') {
                j = 1;
                k++;
            }
        }

        if (ys.length() == 2) {
            ys = (new StringBuilder()).append("13").append(ys).toString();
        }
        if (ms.length() == 1) {
            ms = (new StringBuilder()).append("0").append(ms).toString();
        }
        if (ds.length() == 1) {
            ds = (new StringBuilder()).append("0").append(ds).toString();
        }
        return (new StringBuilder()).append(ys).append('/').append(ms).append(
                '/').append(ds).toString();
    }

    public static String mdateString(String instring) {
        instring = instring.trim();
        if (instring.equals("")) {
            return "";
        }
        int dcd[] = decomposedate(instring);
        int d = dcd[2];
        int m = dcd[1];
        int y = dcd[0];
        if (y >= 0 && y <= 20) {
            y += 2000;
        } else
        if (y > 20 && y <= 99) {
            y += 1900;
        }
        String sy = String.valueOf(y);
        String sm = String.valueOf(m);
        if (sm.length() == 1) {
            sm = (new StringBuilder()).append('0').append(sm).toString();
        }
        String sd = String.valueOf(d);
        if (sd.length() == 1) {
            sd = (new StringBuilder()).append('0').append(sd).toString();
        }
        return (new StringBuilder()).append(sy).append('/').append(sm).append(
                '/').append(sd).toString();
    }

    public static int[] decomposedate(String instring) {
        String dc[] = instring.split("/");
        int y = Integer.parseInt(dc[0]);
        int m = Integer.parseInt(dc[1]);
        int d = Integer.parseInt(dc[2]);
        int res[] = {
                    y, m, d
        };
        return res;
    }

    public static String fdate(String indate) {
        String dc[] = indate.split("/");
        String y = dc[0];
        String m = dc[1];
        String d = dc[2];
        return (new StringBuilder()).append(d).append('/').append(m).append('/').
                append(y).toString();
    }

    public static int getyear(String indate) {
        String dc[] = indate.split("/");
        String y = dc[0];
        return Integer.parseInt(y);
    }

    public static int getmonth(String indate) {
        String dc[] = indate.split("/");
        String m = dc[1];
        return Integer.parseInt(m);
    }

    public static int getday(String indate) {
        String dc[] = indate.split("/");
        String d = dc[2];
        return Integer.parseInt(d);
    }

    public static String makedate(int d, int m, int y) {
        String y1 = String.valueOf(y);
        String m1;
        if (m < 10) {
            m1 = (new StringBuilder()).append('0').append(String.valueOf(m)).
                 toString();
        } else {
            m1 = String.valueOf(m);
        }
        String d1;
        if (d < 10) {
            d1 = (new StringBuilder()).append('0').append(String.valueOf(d)).
                 toString();
        } else {
            d1 = String.valueOf(d);
        }
        return (new StringBuilder()).append(y1).append('/').append(m1).append(
                '/').append(d1).toString();
    }

    public static String today() {
        Date today = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy MM dd");
        String s = df.format(today);
        String currentdate[] = s.split(" ");
        int y = Integer.parseInt(currentdate[0]);
        int m = Integer.parseInt(currentdate[1]);
        int d = Integer.parseInt(currentdate[2]);
        int res[] = m2h(d, m, y);
        int d1 = res[0];
        int m1 = res[1];
        int y1 = res[2];
        String ys = String.valueOf(y1);
        String ms = String.valueOf(m1);
        String ds = String.valueOf(d1);
        if (ms.length() == 1) {
            ms = (new StringBuilder()).append('0').append(ms).toString();
        }
        if (ds.length() == 1) {
            ds = (new StringBuilder()).append('0').append(ds).toString();
        }
        return (new StringBuilder()).append(ys).append('/').append(ms).append(
                '/').append(ds).toString();
    }
   public static String todayFull() {
        
        String today = today();
        return datetotext(today);
    }

    public static String IntString(String instr) {
        String t = "";
        for (int i = 0; i < instr.length(); i++) {
            if (instr.charAt(i) >= '0' && instr.charAt(i) <= '9') {
                t = (new StringBuilder()).append(t).append(instr.charAt(i)).
                    toString();
            }
        }

        if (t.equals("")) {
            return "0";
        } else {
            return t;
        }
    }

    public static boolean IsValiddateString(String s) {
        if (s.trim().equals("")) {
            return false;
        } else {
            int dcd[] = decomposedate(s);
            int d = dcd[2];
            int m = dcd[1];
            int y = dcd[0];
            return hIsValiddate(d, m, y);
        }
    }

    public static boolean mIsValiddateString(String s) {
        if (s.trim().equals("")) {
            return false;
        } else {
            int dcd[] = decomposedate(s);
            int d = dcd[2];
            int m = dcd[1];
            int y = dcd[0];
            return mIsValiddate(d, m, y);
        }
    }

    public static String hdayofweek(String instring) {
        String s = dateString(instring);
        if (!IsValiddateString(s)) {
            return "";
        } else {
            int dcd[] = decomposedate(s);
            int d = dcd[2];
            int m = dcd[1];
            int y = dcd[0];
            int l = hdifdate(1, 1, 1, d, m, y);
            int i = (l + 5) % 7;
            return mdayofweek2str(i + 1);
        }
    }

    public static String hdayofweekf(String instring) {
        String s = dateString(instring);
        if (!IsValiddateString(s)) {
            return "";
        } else {
            int dcd[] = decomposedate(s);
            int d = dcd[2];
            int m = dcd[1];
            int y = dcd[0];
            int l = hdifdate(1, 1, 1, d, m, y);
            int i = (l + 5) % 7;
            return hdayofweek2str(i + 1);
        }
    }

    public static String datetotext(String datestr) {
        if (IsValiddateString(datestr)) {
            String s = dateString(datestr);
            int dcd[] = decomposedate(s);
            int dd = dcd[2];
            int mm = dcd[1];
            int yy = dcd[0];
            return (new StringBuilder()).append(hdayofweekf(s)).append(" ").
                    append(PersianTextNumber(dd)).append(" ").append(hmonth2str(
                    mm)).append(" \u0645\u0627\u0647 ").append(
                    PersianTextNumber(yy)).append(
                    " \u0647\u062C\u0631\u064A \u0634\u0645\u0633\u064A ").
                    toString();
        } else {
            return "";
        }
    }

    public static String UTPD(int d) {
        String pd[] = {
                      "\u0635\u0641\u0631", "\u064A\u0643", "\u062F\u0648",
                      "\u0633\u0647", "\u0686\u0647\u0627\u0631",
                      "\u067E\u0646\u062C", "\u0634\u0634",
                      "\u0647\u0641\u062A", "\u0647\u0634\u062A",
                      "\u0646\u0647"
        };
        if (d >= 0 && d <= 9) {
            return pd[d];
        } else {
            return "";
        }
    }

    public static String UTwPD(int d) {
        String pd[] = {
                      "\u062F\u0647", "\u064A\u0627\u0632\u062F\u0647",
                      "\u062F\u0648\u0627\u0632\u062F\u0647",
                      "\u0633\u064A\u0632\u062F\u0647",
                      "\u0686\u0647\u0627\u0631\u062F\u0647",
                      "\u067E\u0627\u0646\u0632\u062F\u0647",
                      "\u0634\u0627\u0646\u0632\u062F\u0647",
                      "\u0647\u0641\u062F\u0647", "\u0647\u062C\u062F\u0647",
                      "\u0646\u0648\u0632\u062F\u0647"
        };
        if (d >= 10 && d <= 19) {
            return pd[d - 10];
        } else {
            return "";
        }
    }

    public static String UHPD(int d) {
        String pd[] = {
                      "\u0628\u064A\u0633\u062A", "\u0633\u064A",
                      "\u0686\u0647\u0644", "\u067E\u0646\u062C\u0627\u0647",
                      "\u0634\u0635\u062A", "\u0647\u0641\u062A\u0627\u062F",
                      "\u0647\u0634\u062A\u0627\u062F", "\u0646\u0648\u062F"
        };
        if (d >= 2 && d <= 9) {
            return pd[d - 2];
        } else {
            return "";
        }
    }

    public static String UThPD(int d) {
        String pd[] = {
                      "\u064A\u0643\u0635\u062F",
                      "\u062F\u0648\u064A\u0633\u062A",
                      "\u0633\u064A\u0633\u0635\u062F",
                      "\u0686\u0647\u0627\u0631\u0635\u062F",
                      "\u067E\u0627\u0646\u0635\u062F",
                      "\u0634\u0634\u0635\u062F",
                      "\u0647\u0641\u062A\u0635\u062F",
                      "\u0647\u0634\u062A\u0635\u062F",
                      "\u0646\u0647\u0635\u062F"
        };
        if (d >= 1 && d <= 9) {
            return pd[d - 1];
        } else {
            return "";
        }
    }

    public static String HPD(int d) {
        String pd[] = {
                      "\u0647\u0632\u0627\u0631",
                      "\u0645\u064A\u0644\u064A\u0648\u0646",
                      "\u0645\u064A\u0644\u064A\u0627\u0631\u062F",
                      "\u062A\u0631\u064A\u0644\u064A\u0648\u0646"
        };
        if (d >= 1 && d <= 4) {
            return pd[d - 1];
        } else {
            return "";
        }
    }

    public static String DDD2PersianNumber(int n) {
        if (n > 999) {
            return "";
        }
        int o = n % 10;
        int t = (n % 100) / 10;
        int h = n / 100;
        String str = "";
        if (t != 1) {
            if (o != 0) {
                str = UTPD(o);
            }
            if (t != 0) {
                if (o != 0) {
                    str = (new StringBuilder()).append(UHPD(t)).append(
                            " \u0648").append(str).toString();
                } else {
                    str = UHPD(t);
                }
            }
            if (h != 0) {
                if (t != 0 || o != 0) {
                    str = (new StringBuilder()).append(UThPD(h)).append(
                            " \u0648").append(str).toString();
                } else {
                    str = UThPD(h);
                }
            }
        } else {
            str = UTwPD(t * 10 + o);
            if (h != 0) {
                str = (new StringBuilder()).append(UThPD(h)).append(" \u0648").
                      append(str).toString();
            }
        }
        return str;
    }

    public static String PersianTextNumber(int n) {
        if (n > 0x7fffffff) {
            return "";
        }
        int temp = n;
        int na[] = new int[5];
        String str = "";
        for (int i = 0; i < 5; i++) {
            na[i] = temp % 1000;
            temp /= 1000;
        }

        str = DDD2PersianNumber(na[0]);
        for (int i = 1; i < 5; i++) {
            if (na[i] == 0) {
                continue;
            }
            boolean test = false;
            for (int k = 1; k <= i - 1; k++) {
                test = test || na[k] != 0;
            }

            if (test) {
                str = (new StringBuilder()).append(DDD2PersianNumber(na[i])).
                      append(" ").append(HPD(i)).append(" ").append(str).
                      toString();
            } else {
                str = (new StringBuilder()).append(DDD2PersianNumber(na[i])).
                      append(" ").append(HPD(i)).append(str).toString();
            }
        }

        return str;
    }


    public static void main(String args[]) {
//        PersianMode.DateConvert a = new PersianMode.DateConvert();
//        PersianMode.DateConvert _tmp = a;
//        int b[] = h2m(20, 12, 1360);
//        for (int i = 0; i < b.length; i++) {
//            System.err.print((new StringBuilder()).append(b[i]).append("\\").
//                             toString());
//        }
      // JOptionPane.showMessageDialog(null, todayFull());
//        int [] a=hndifdate(1,29,12,1388);
        System.out.println(todayFull());
//        System.out.println("hndifdate[0]=" + a[0]);
//         System.out.println("hndifdate[0]=" + a[1]);
//          System.out.println("hndifdate[0]=" + a[2]);

    }
}
