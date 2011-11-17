package com.android.Quizmaster;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Extras extends Activity {
	
	Button alarm, database;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.extras);
        
        Initialize();
        
        // A Listener for the Alarm button.
        
        alarm.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Extras.this, SetAlarm.class));
				//Toast.makeText(getApplicationContext(), "Alarm setting Complete!", Toast.LENGTH_LONG).show();
			}  });
        
        // A Listener for the database button
        
        database.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Extras.this, DatbaseTest.class));
				//Toast.makeText(getApplicationContext(), "Update Started! Please wait for the 'Done' message", Toast.LENGTH_LONG).show();
			}
		});
        }
	
	private void Initialize(){
		alarm = (Button) findViewById(R.id.SetAlarm);
		database = (Button) findViewById(R.id.UpdateDatabase);
	}
	
}
