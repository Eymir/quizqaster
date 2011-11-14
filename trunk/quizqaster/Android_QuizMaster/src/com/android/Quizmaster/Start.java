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
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class Start extends Activity {

	private Button Confirm, Next;
	private RadioButton Rb1, Rb2, Rb3, Rb4;
	private RadioGroup Rg;
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
        
        Confirm.setOnClickListener(new OnClickListener() {  public void onClick(View v) {  EvaluateQuestion();  }  });
        
        Next.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				if(count <=5){
					ShowQuestion(++count);
				} else {
					Intent intent = new Intent(Start.this, DisplayScores.class);
					intent.putExtra("Score", Score + "");
					intent.putExtra("Number", 6 + "");
					startActivity(intent);
				}
			}
		});
        
        }
	
	private void InitializeEventHandlers(){
		
		Confirm = (Button) findViewById(R.id.Confirm);
        Next = (Button) findViewById(R.id.Next);
        
        Rb1 = (RadioButton) findViewById(R.id.Option1);
        Rb2 = (RadioButton) findViewById(R.id.Option2);
        Rb3 = (RadioButton) findViewById(R.id.Option3);
        Rb4 = (RadioButton) findViewById(R.id.Option4);
        Rg = (RadioGroup) findViewById(R.id.RadioGroup);
        
        Question = (TextView) findViewById(R.id.Question);
	}
	
	private void EvaluateQuestion(){
		String EnteredAnswer = "";
		
		Log.d("Option lengths", "Option1 length: " + Rb1.getText().length() + "Answer length" + Answer.length() + "");
		
		if(Rb1.isChecked()) { EnteredAnswer = Rb1.getText().toString();  Log.d("Evaluated", "Option1 has matched"); }
		else if(Rb2.isChecked()) {  EnteredAnswer = Rb2.getText().toString(); Log.d("Evaluated", "Option2 has matched"); }
		else if(Rb3.isChecked()) { EnteredAnswer = Rb3.getText().toString();  Log.d("Evaluated", "Option1 has matched"); }
		else if(Rb4.isChecked()) { EnteredAnswer = Rb4.getText().toString(); Log.d("Evaluated", "Option1 has matched"); }
		Log.d("EnteredAnswersize", EnteredAnswer);
		if(EnteredAnswer.equals(Answer)) { Score++; Log.d("Evaluate", "Score is incremented.Score now is :  " + Score);}
		else Log.d("Evaluated", "No options matched");
	}
	
	private void ShowQuestion(int id){
		SQLiteDatabase database = openOrCreateDatabase("QuizMaster", MODE_WORLD_READABLE, null);
		Cursor cursor = database.rawQuery("Select * from Questions where _id ="+id + ";", null);
		if(cursor != null){
			cursor.moveToFirst();
	        Log.d("Srinivas", cursor.getString(cursor.getColumnIndex("Question")));
	        Question.setText(cursor.getString(cursor.getColumnIndex("Question")));
	        Rb1.setText(cursor.getString(cursor.getColumnIndex("Opt1")));
	        Rb2.setText(cursor.getString(cursor.getColumnIndex("Opt2")));
	        Rb3.setText(cursor.getString(cursor.getColumnIndex("Opt3")));
	        Rb4.setText(cursor.getString(cursor.getColumnIndex("Opt4")));
	        Answer = cursor.getString(cursor.getColumnIndex("Answer"));
	        
	        Log.d("Question", cursor.getString(cursor.getColumnIndex("Question")));
	        Log.d("1st Option", cursor.getString(cursor.getColumnIndex("Opt1")));
	        Log.d("2nd Option", cursor.getString(cursor.getColumnIndex("Opt2")));
	        Log.d("3rd Option", cursor.getString(cursor.getColumnIndex("Opt3")));
	        Log.d("4th Option", cursor.getString(cursor.getColumnIndex("Opt4")));
	        Log.d("Answer", cursor.getString(cursor.getColumnIndex("Answer")));
	        Log.d("In Answer", Answer);
		}else Log.d("Srinivas", "Cursor is null");
        
        database.close();
	}
	
	
	private void Evaluate(){
		int checkedRadioButton = Rg.getCheckedRadioButtonId();
		
		String CheckedButton = "Rb" + checkedRadioButton;
		
		Log.d("CheckedButton", CheckedButton);
	}
}
