package com.android.Quizmaster;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
 
public class AReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context con, Intent in) {
                try {
                        /* Display an alert */
                	Toast.makeText(con, "Alarm Received!", Toast.LENGTH_LONG).show();
                        Log.d("Srinivas", "In OnReceive() Method");
                } catch (Exception r) {
                        Log.e("Srinivas", "An Error Occured!");
                }
        }
}
