package com.android.Quizmaster;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button Start = (Button) findViewById(R.id.Start);
        Button Instructions = (Button) findViewById(R.id.Instructions);
        Button HighScores = (Button) findViewById(R.id.HighScores);
        Button Exit = (Button) findViewById(R.id.Exit);
        Button Database = (Button)findViewById(R.id.Database);
        
//listener for Button Instructions.
        
        Instructions.setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Main.this, Instructions.class));
			}
		});
        
//Listener for the Button Start.
        
        Start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Main.this, Start.class));
			}
		});
        
//Listener for the  HighScores Button
        
        HighScores.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Main.this, HighScores.class));
			}
		});
        
// Listener for the Exit Page.
        
    	Exit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
    	
//Listener for the Add Database page.
    	Database.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Main.this, DatbaseTest.class));
				
			}
		});
        
    }
}


