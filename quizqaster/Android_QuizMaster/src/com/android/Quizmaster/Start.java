package com.android.Quizmaster;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Start extends Activity {

	private Button Next;
	private RadioButton Rb1, Rb2, Rb3, Rb4;
	RadioGroup Rg;
	private TextView Question,timer,heading;
	String Answer;
	int count=1,Score=0,delay = 30000;
	MyCount counter;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        
        //Initialize all the buttons and TextViews.
        InitializeEventHandlers();
        
        counter = new MyCount(delay,1000);
        ShowQuestion(1);
        counter.start();
        
//        Confirm.setOnClickListener(new OnClickListener() {  public void onClick(View v) {  EvaluateQuestion();  }  });
        
        Next.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				if(count < 5){
					if(delay != 0) EvaluateQuestion();
					else Toast.makeText(getApplicationContext(), "Q." + count + " will not be evaluated!", Toast.LENGTH_LONG).show();
					delay = 30000;
					Rg.clearCheck();
					if(count < 5){
						ShowQuestion(++count);
						counter.start();
						delay = 30000;
					}
				} else {
					EvaluateQuestion();
					Intent intent = new Intent(Start.this, DisplayScores.class);
					intent.putExtra("Score", Score + "");
					intent.putExtra("Number", 5 + "");
					startActivity(intent);
					finish();
				}
			}
		});
        
        }
	
	private void InitializeEventHandlers(){
		
        Next = (Button) findViewById(R.id.next);
        
        Rb1 = (RadioButton) findViewById(R.id.option1);
        Rb2 = (RadioButton) findViewById(R.id.option2);
        Rb3 = (RadioButton) findViewById(R.id.option3);
        Rb4 = (RadioButton) findViewById(R.id.option4);
        Rg = (RadioGroup) findViewById(R.id.RadioGroup);
        
        Question = (TextView) findViewById(R.id.question);
        timer = (TextView) findViewById(R.id.timer);
        
        heading = (TextView) findViewById(R.id.heading_Start);
        
	}
	
	private void EvaluateQuestion(){
		String EnteredAnswer = "";
		if(Rb1.isChecked()) { EnteredAnswer = Rb1.getText().toString(); }
		else if(Rb2.isChecked()) {  EnteredAnswer = Rb2.getText().toString(); }
		else if(Rb3.isChecked()) { EnteredAnswer = Rb3.getText().toString(); }
		else if(Rb4.isChecked()) { EnteredAnswer = Rb4.getText().toString(); }
		if(EnteredAnswer.equals(Answer)) Score++;
	}
	
	private void ShowQuestion(int id){
		SQLiteDatabase database = openOrCreateDatabase("QuizMaster", MODE_WORLD_READABLE, null);
		Cursor cursor = database.rawQuery("Select * from Questions where _id ="+id + ";", null);
		if(cursor != null){
			cursor.moveToFirst();
			heading.append(" " + count);
	        Question.setText(cursor.getString(cursor.getColumnIndex("Question")));
	        Rb1.setText(cursor.getString(cursor.getColumnIndex("Opt1")));
	        Rb2.setText(cursor.getString(cursor.getColumnIndex("Opt2")));
	        Rb3.setText(cursor.getString(cursor.getColumnIndex("Opt3")));
	        Rb4.setText(cursor.getString(cursor.getColumnIndex("Opt4")));
	        Answer = cursor.getString(cursor.getColumnIndex("Answer"));
		}else Log.d("Quiz Master", "Cursor is null");
        
        database.close();
	}
	
	public class MyCount extends CountDownTimer{
		
		public MyCount(long millisInFuture, long countDownInterval) {  super(millisInFuture, countDownInterval);  }
		
	@Override
	public void onFinish() { timer.setText("Time out. Click Next! "); delay = 0; }
	
	@Override
	public void onTick(long millisUntilFinished) { timer.setText("Time Left: " + millisUntilFinished/1000); }
	}
	
}
