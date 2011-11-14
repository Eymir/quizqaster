package com.android.Quizmaster;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
        String Questions = intent.getStringExtra("Score");
        String Answered = intent.getStringExtra("Number");
        
        Ques = (TextView) findViewById(R.id.setQuestions);
        Ans = (TextView) findViewById(R.id.setAnswers);
        
        Ques.setText(Questions);
        Ans.setText(Answered);
        
        Button OK = (Button) findViewById(R.id.OKButton);
        OK.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(DisplayScores.this, Main.class));
			}
		});
	}
}
