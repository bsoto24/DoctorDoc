package com.doctordocplus.doctordoc.presenter.activity;

import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.doctordocplus.doctordoc.R;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class CalendarActivity extends AppCompatActivity {

    private CompactCalendarView calendar;
    private ImageView imgNext, imgPrevious;
    private TextView tvMonth, tvResult;
    private ArrayList<Event> events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        showToolbar("Calendario", true);

        tvMonth = (TextView) findViewById(R.id.tv_month);
        tvResult = (TextView) findViewById(R.id.tv_result);
        imgNext = (ImageView) findViewById(R.id.img_next);
        imgPrevious = (ImageView) findViewById(R.id.img_previous);

        calendar = (CompactCalendarView) findViewById(R.id.compactcalendar_view);
        calendar.setUseThreeLetterAbbreviation(true);

        showMonth();

        events = dataSet();
        addEvents(events);

        tvMonth.setText("MAYO");

        imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar.showNextMonth();
                showMonth();
            }
        });

        imgPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar.showPreviousMonth();
                showMonth();
            }
        });

        calendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                printDay(dateClicked);
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                showMonth();
            }
        });
    }

    private void showMonth() {
        Date date = calendar.getFirstDayOfCurrentMonth();
        String monthname=(String)android.text.format.DateFormat.format("MMMM", date);
        tvMonth.setText(monthname.toUpperCase());
    }


    private void printDay(Date dateClicked) {
        String result = "";
        for (Event e : events) {
            if(e.getTimeInMillis() == dateClicked.getTime()){
                result = e.getData().toString();
                break;
            }
        }
        tvResult.setText(result);
    }

    private ArrayList<Event> dataSet() {
        ArrayList<Event> events = new ArrayList<>();
        events.add(new Event(getResources().getColor(R.color.colorAccent), new GregorianCalendar(2017, 5, 3).getTimeInMillis(), "Consulta General"));
        events.add(new Event(getResources().getColor(R.color.colorAccent), new GregorianCalendar(2017, 5, 5).getTimeInMillis(), "Consulta General"));
        events.add(new Event(getResources().getColor(R.color.colorAccent), new GregorianCalendar(2017, 5, 8).getTimeInMillis(), "Consulta General"));
        events.add(new Event(getResources().getColor(R.color.colorAccent), new GregorianCalendar(2017, 5, 16).getTimeInMillis(), "Consulta General"));
        events.add(new Event(getResources().getColor(R.color.colorAccent), new GregorianCalendar(2017, 5, 30).getTimeInMillis(), "Consulta General"));
        return events;
    }

    public void addEvents(ArrayList<Event> events) {
        for (Event e : events) {
            calendar.addEvent(e);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public void showToolbar(String title, boolean upButton) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}