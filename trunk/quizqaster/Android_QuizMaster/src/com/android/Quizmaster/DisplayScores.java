package com.android.Quizmaster;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DisplayScores extends Activity {

	TextView Ques,Ans;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displayscores);


        Intent intent = getIntent();
        String Questions = intent.getStringExtra("Number");
        String Answered = intent.getStringExtra("Score");
        
        Ques = (TextView) findViewById(R.id.Questions_Info);
        Ans = (TextView) findViewById(R.id.Answers_Info);
        
        Ques.setText(Questions);
        Ans.setText(Answered);
        
        Button OK = (Button) findViewById(R.id.OKButton);
        OK.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(DisplayScores.this, Main.class));
				finish();
			}
		});
	}
	
}
