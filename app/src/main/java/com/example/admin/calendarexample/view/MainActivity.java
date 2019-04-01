package com.example.admin.calendarexample.view;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.PersistableBundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import com.example.admin.calendarexample.PersianMode.DateConvert;
import com.example.admin.calendarexample.PersianMode.PortletCalendar;
import com.example.admin.calendarexample.R;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class MainActivity extends AppCompatActivity {
    int thisDay;
    int thisMonth;
    int thisYear;
    PortletCalendar pc;
    Map map;
    GridView grid;
    int first = 1;
    ArrayList days;
    ArrayAdapter gridArray;
    Button preMonth,nextMonth;
    TextView myMonth;
    TextView myYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myMonth=(TextView) findViewById(R.id.monthView);
        myYear=(TextView) findViewById(R.id.yearView);
        grid = (GridView) findViewById(R.id.grid);
        preMonth=(Button) findViewById(R.id.preMonth);
        nextMonth=(Button) findViewById(R.id.postMonth);
        pc = new PortletCalendar();
        days = new ArrayList<>();
        gridArray = new ArrayAdapter(this, android.R.layout.simple_spinner_item, days);
        map = new TreeMap<Integer, Integer>();
        map.put(0, 5);
        map.put(1, 4);
        map.put(2, 3);
        map.put(3, 2);
        map.put(4, 1);
        map.put(5, 0);
        map.put(6, 6);

        Typeface face = Typeface.createFromAsset(getAssets(),
                "fonts/IRANSans.ttf");
        myMonth.setTypeface(face);
        myYear.setTypeface(face);
        preMonth.setTypeface(face);
        nextMonth.setTypeface(face);

        if(savedInstanceState==null) {
            setD();
            Log.i("setD","counting");
        }



        preMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int m = thisMonth;
                int y = thisYear;
                if (thisMonth == 1) {

                    thisYear -= 1;
                    thisMonth = 12;

                } else {

                    thisMonth = thisMonth - 1;

                }

                days.clear();
                setCal();

            }
        });

        nextMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int m = thisMonth;
                int y = thisYear;
                if (thisMonth == 12) {

                    thisYear += 1;
                    thisMonth = 1;
                } else {

                    thisMonth = thisMonth + 1;

                }

                days.clear();
                setCal();

            }
        });

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView t=(TextView) view;
               if(t.getText()!=" "){
                   int currYear[] = DateConvert.h2m(Integer.parseInt(""+t.getText()), thisMonth, thisYear);
                   int thisMonthm = currYear[1];
                   int thisDaym = currYear[0];
                   int thisYearm = currYear[2];
                   AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                   builder1.setMessage("تاریخ میلادی "+"\n"+ thisDaym+"/ "+thisMonthm+"/ "+thisYearm +"\n"+ "تاریخ شمسی"+"\n"+thisYear+"/ "+thisMonth+"/ "+t.getText());
                   builder1.setCancelable(true);

                   builder1.setPositiveButton(
                           "Ok",
                           new DialogInterface.OnClickListener() {
                               public void onClick(DialogInterface dialog, int id) {
                                   dialog.cancel();
                               }
                           });
                   AlertDialog alert11 = builder1.create();
                   alert11.show();
               }
            }
        });




    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState!=null){
            Log.i("month",""+thisMonth);
            thisMonth=savedInstanceState.getInt("month");
            thisDay=savedInstanceState.getInt("day");
            thisYear=savedInstanceState.getInt("year");
            Log.i("restore","restoring");
            Log.i("values",""+thisYear+"  "+thisMonth);
            setCal();
        }




    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("loaded",true);
        outState.putInt("month",thisMonth);
        outState.putInt("day",thisDay);
        outState.putInt("year",thisYear);


    }




    public void setD() {
        String today = DateConvert.today();
        thisDay = DateConvert.getday(today);
        thisMonth = DateConvert.getmonth(today);
        thisYear = DateConvert.getyear(today);
        Log.i("today", thisDay + "    " + thisMonth);

        setCal();
    }

    public void setCal() {

        myMonth.setText(""+DateConvert.hmonth2str(thisMonth));
        myYear.setText(""+thisYear);

        int maxDayOfMonth = pc.maxDayOfMonth(thisMonth, thisYear);
        int col = (int) map.get(pc.dayOfWeek(first, thisMonth, thisYear));
        int j = 0;
        for (int i = 1; i <= maxDayOfMonth+6-col; i++) {
            int currYear[] = DateConvert.h2m(i, thisMonth, thisYear);
            String is = String.valueOf(i);
            if(i-1<6-col) {
                days.add(" ");
                j++;
            }

            else {

                days.add(i-j);
            }
            gridArray.notifyDataSetChanged();


        }

        grid.setAdapter(gridArray);
        grid.setSelectionFromTop(0,col);
    }


}

