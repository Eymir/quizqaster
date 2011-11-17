package com.android.Quizmaster;

import java.util.Calendar;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;



public class SetAlarm extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);

            try {
                    Calendar cal = Calendar.getInstance();

                    Intent intent = new Intent(this, AReceiver.class);
                    PendingIntent sender = PendingIntent.getBroadcast(getApplicationContext(), 1234567, intent, 0);

                    AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
                    am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis() + 300, sender);
                    Toast.makeText(getApplicationContext(), "Alarm setting Complete!", Toast.LENGTH_SHORT).show();
                    Log.d("Alarm Setting", "Done");
                    finish();

            } catch (Exception e) {
                    Log.d("Alarm Setting", "ERROR IN CODE:" + e.toString());
            }
    }
}