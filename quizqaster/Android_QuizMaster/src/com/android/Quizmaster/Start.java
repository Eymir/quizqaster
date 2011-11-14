package com.android.Quizmaster;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class Start extends Activity {

	private Button Next;
	private RadioButton Rb1, Rb2, Rb3, Rb4;
	private TextView Question;
	String Answer;
	int count=1,Score=0;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        
        //Initialize all the buttons and TextViews.
        InitializeEventHandlers();
        ShowQuestion(1);
        
//        Confirm.setOnClickListener(new OnClickListener() {  public void onClick(View v) {  EvaluateQuestion();  }  });
        
        Next.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				if(count < 5){
					EvaluateQuestion();
					if(count < 5) ShowQuestion(++count);
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
		
        Next = (Button) findViewById(R.id.Next);
        
        Rb1 = (RadioButton) findViewById(R.id.Option1);
        Rb2 = (RadioButton) findViewById(R.id.Option2);
        Rb3 = (RadioButton) findViewById(R.id.Option3);
        Rb4 = (RadioButton) findViewById(R.id.Option4);
        
        Question = (TextView) findViewById(R.id.Question);
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
	        Question.setText(cursor.getString(cursor.getColumnIndex("Question")));
	        Rb1.setText(cursor.getString(cursor.getColumnIndex("Opt1")));
	        Rb2.setText(cursor.getString(cursor.getColumnIndex("Opt2")));
	        Rb3.setText(cursor.getString(cursor.getColumnIndex("Opt3")));
	        Rb4.setText(cursor.getString(cursor.getColumnIndex("Opt4")));
	        Answer = cursor.getString(cursor.getColumnIndex("Answer"));
		}else Log.d("Quiz Master", "Cursor is null");
        
        database.close();
	}
	
}
