package com.example.bettersleephelper;

import android.widget.TextView;
import android.widget.TimePicker;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TimePicker timePicker = findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);

        final TextView tv6Hours = findViewById(R.id.tv6hours);
        final TextView tv7Hours = findViewById(R.id.tv7Hours);
        final TextView tv8Hours = findViewById(R.id.tv8hours);


        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Calendar c = Calendar.getInstance();
                c.set(Calendar.HOUR_OF_DAY, hourOfDay);
                c.set(Calendar.MINUTE, minute);

                c.add(Calendar.MINUTE, -4 * 90);
                String time = String.format("%02d:%02d", c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE));
                tv6Hours.setText("To sleep 6 hours: " +  time);

                c.add(Calendar.MINUTE, -90);
                time = String.format("%02d:%02d", c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE));
                tv7Hours.setText("To sleep 7 hours and a half: " + time);

                c.add(Calendar.MINUTE, - 90);
                time = String.format("%02d:%02d", c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE));
                tv8Hours.setText("To sleep 9 hours: " + time);
            }
        });


    }
}
