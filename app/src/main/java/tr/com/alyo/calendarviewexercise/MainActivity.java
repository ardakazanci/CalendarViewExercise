package tr.com.alyo.calendarviewexercise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import org.threeten.bp.LocalDate;


import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateLongClickListener;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements OnDateSelectedListener, OnMonthChangedListener, OnDateLongClickListener {


    private MaterialCalendarView widget;

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private ArrayList<CalendarDay> dates;

    private final OneDayDecorator oneDayDecorator = new OneDayDecorator();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setupUI();
        widget.setOnDateChangedListener(this);
        widget.setOnMonthChangedListener(this);
        widget.setOnDateLongClickListener(this);
        exerciseCalendar();


    }

    private void exerciseCalendar() {

        dates = new ArrayList<CalendarDay>();

        dates.add(CalendarDay.from(2019, 10, 25));
        dates.add(CalendarDay.from(2019, 10, 26));
        dates.add(CalendarDay.from(2019, 10, 27));
        dates.add(CalendarDay.from(2019, 10, 28));


        widget.addDecorator(new DayViewDecorator() {
            @Override
            public boolean shouldDecorate(CalendarDay day) {

                return day == CalendarDay.from(2019, 10, 25);

            }

            @Override
            public void decorate(DayViewFacade view) {
                view.setBackgroundDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.my_selector));

            }
        });


        widget.addDecorator(new EventDecorator(Color.BLACK, dates));


        //long selectedDate = calendarView.getDate();
        // 5 Gün Sonrası
        //long fiveDaysLater = selectedDate + (1000L*60*60*24*5);
        //Log.i(LOG_TAG, "Normal : " + selectedDate);
        //Log.i(LOG_TAG,"Five Days Later : "+ fiveDaysLater);

        //Log.i(LOG_TAG, "Formatter : " +  Utils.dateConverter(selectedDate));
        //Log.i(LOG_TAG,"Five Days Later Formatter : "+ Utils.dateConverter(fiveDaysLater));

        //calendarView.setDate(selectedDate,true,true);
        //calendarView.setDate(fiveDaysLater,true,true);
        //calendarView.setDate(fiveDaysLater);
        //calendarView.setDate


    }

    private void setupUI() {

        widget = findViewById(R.id.demoCalendar);
        widget.setShowOtherDates(MaterialCalendarView.SHOW_ALL);
        final LocalDate instance = LocalDate.now();
        widget.setSelectedDate(instance);

        widget.addDecorators(
                new MySelectorDecorator(this),
                new HighlightWeekendsDecorator(),
                oneDayDecorator
        );


    }


    @Override
    public void onMonthChanged(MaterialCalendarView widget, CalendarDay date) {
        Log.e(LOG_TAG, "Month Changed");
    }

    @Override
    public void onDateLongClick(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date) {
        Log.e(LOG_TAG, "Long Click -> " + date.getDate());
    }

    @Override
    public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {

    }
}
