package com.android.Quizmaster;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class DatbaseTest extends Activity{

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        SQLiteDatabase database = openOrCreateDatabase("QuizMaster", MODE_PRIVATE, null);
        database.execSQL("create table Questions(_id integer primary key Autoincrement, Question text not null, Opt1 Text not null," +
        				 " Opt2 Text not null, Opt3 Text not null, Opt4 Text not null, Answer text not null);");
        database.execSQL("insert into Questions(Question, Opt1, Opt2, Opt3, Opt4, Answer) values('Question1', 'Option1.1', 'Option1.2', 'Option1.3', 'Option1.4', 'Option1.1');");
        database.execSQL("insert into Questions(Question, Opt1, Opt2, Opt3, Opt4, Answer) values('Question2', 'Option2.1', 'Option2.2', 'Option2.3', 'Option2.4', 'Option2.1');");
        database.execSQL("insert into Questions(Question, Opt1, Opt2, Opt3, Opt4, Answer) values('Question3', 'Option3.1', 'Option3.2', 'Option3.3', 'Option3.4', 'Option3.1');");
        database.execSQL("insert into Questions(Question, Opt1, Opt2, Opt3, Opt4, Answer) values('Question4', 'Option4.1', 'Option4.2', 'Option4.3', 'Option4.4', 'Option4.1');");
        database.execSQL("insert into Questions(Question, Opt1, Opt2, Opt3, Opt4, Answer) values('Question5', 'Option5.1', 'Option5.2', 'Option5.3', 'Option5.4', 'Option5.1');");
        database.execSQL("insert into Questions(Question, Opt1, Opt2, Opt3, Opt4, Answer) values('Question6', 'Option6.1', 'Option6.2', 'Option6.3', 'Option6.4', 'Option6.1');");
        database.execSQL("insert into Questions(Question, Opt1, Opt2, Opt3, Opt4, Answer) values('Question7', 'Option7.1', 'Option7.2', 'Option7.3', 'Option7.4', 'Option7.1');");
        database.execSQL("insert into Questions(Question, Opt1, Opt2, Opt3, Opt4, Answer) values('Question8', 'Option8.1', 'Option8.2', 'Option8.3', 'Option8.4', 'Option8.1');");
        
//        Cursor cursor = database.rawQuery("Select * from Questions", null);
//        cursor.moveToFirst();
//        for(int i=0; i < cursor.getColumnCount(); i++){
//        	Log.d("srinivas", cursor.getString(cursor.getColumnIndex("Question")));
//        	cursor.move(1);
//        }
        database.close();
        
        
	}
	
}
