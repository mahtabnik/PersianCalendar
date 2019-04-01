package com.example.admin.calendarexample.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.admin.calendarexample.R;

/**
 * Created by admin on 24/11/2016.
 */
public class SplashPage extends Activity {

    boolean checked=false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);
        TextView txt1=(TextView) findViewById(R.id.txt1);
        Typeface face = Typeface.createFromAsset(getAssets(),
                "fonts/IRANSans.ttf");
        txt1.setTypeface(face);
        if(savedInstanceState!=null){
            checked=savedInstanceState.getBoolean("checked");
        }

        if(!checked) {

            Thread welcomeThread = new Thread() {

                @Override
                public void run() {
                    try {
                        super.run();
                        sleep(3000); //Delay of 10 seconds
                    } catch (Exception e) {

                    } finally {

                        Intent i = new Intent(SplashPage.this,
                                MainActivity.class);
                        startActivity(i);
                        finish();
                    }
                }
            };
            welcomeThread.start();
        }


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("checked",true);
    }
}
