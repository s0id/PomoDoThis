package com.example.pomodothis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Statistics_Activity extends AppCompatActivity {
    private TextView todayPomos, todayBreaks, totalPomos, totalBreaks;
    Intent myIntentS;

    private MyDB db ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistics_layout);

        // Find Views By ID
        todayPomos  =   (TextView) findViewById(R.id.todayPomos);
        todayBreaks =   (TextView) findViewById(R.id.todayBreaks);
        totalPomos  =   (TextView) findViewById(R.id.totalPomos);
        totalBreaks =   (TextView) findViewById(R.id.totalBreaks);

        // declating a new database
        db = new MyDB(this.getApplicationContext());

        this.updateTodayStats();

    }

    @Override
    protected void onResume() {
        this.updateTodayStats();
        super.onResume();
    }

    // Button to show all
    public void showmeall(View view) {


        if(myIntentS==null){
            myIntentS = new Intent(this, AllStatistics.class);
            startActivity(myIntentS);
        } else {
            startActivity(myIntentS);
        }
    }
    
    // Update today's stats
    public void updateTodayStats() {
        // Getting the date and formatting it
        Today today = db.getToday();
        todayPomos.setText(String.valueOf(today.getPomos()));
        todayBreaks.setText(String.valueOf(today.getBreaks()));
        totalPomos.setText(minutesToFormat(today.getPomos() * 25));
        totalBreaks.setText(minutesToFormat(today.getBreaks() * 5));

    }

    public static String minutesToFormat(int totalMinutes) {
        int hours   = totalMinutes / 60 ;
        int minutes = totalMinutes % 60;


        return String.format("%dH:%02dMin", hours, minutes);
    }
}