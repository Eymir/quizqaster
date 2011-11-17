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
        
        database.execSQL("insert into Questions(Question, Opt1, Opt2, Opt3, Opt4, Answer) values('FIFA is an Organization working in the field of:', 'Banking', 'Textiles', 'Power Generation', 'Sports', 'Sports');");
        database.execSQL("insert into Questions(Question, Opt1, Opt2, Opt3, Opt4, Answer) values('Olympic Games are organized after a gap of every ', 'Two years', 'Three years', 'Four years', 'Five years', 'Four years');");
        database.execSQL("insert into Questions(Question, Opt1, Opt2, Opt3, Opt4, Answer) values('How many squares are there in chess board', '36', '48', '64', '72', '64');");
        database.execSQL("insert into Questions(Question, Opt1, Opt2, Opt3, Opt4, Answer) values('The term Grand Slam is associated with ', 'Billiards', 'Cricket', 'chess', 'Tennis', 'Tennis');");
        database.execSQL("insert into Questions(Question, Opt1, Opt2, Opt3, Opt4, Answer) values('The term 16 yards is ssociated with ', 'Polo', 'Hockey', 'Basketball', 'badminton', 'Hockey');");
        database.execSQL("insert into Questions(Question, Opt1, Opt2, Opt3, Opt4, Answer) values('With which game is the Double Falut is associated', 'Lawn Tennis', 'Football', 'Cricket', 'Hockey', 'Football');");
        database.execSQL("insert into Questions(Question, Opt1, Opt2, Opt3, Opt4, Answer) values('Length of pitch in cricket is __ yards ', '21', '22', '23', '24', '22');");
        database.execSQL("insert into Questions(Question, Opt1, Opt2, Opt3, Opt4, Answer) values('First indian to take a hat-trick in international test is ', 'Kapil Dev', 'Jasu Patel', 'Sachin Tendulkar', 'haribhajan Shigh', 'haribhajan Shigh');");
        
//        Cursor cursor = database.rawQuery("Select * from Questions", null);
//        cursor.moveToFirst();
//        for(int i=0; i < cursor.getColumnCount(); i++){
//        	Log.d("srinivas", cursor.getString(cursor.getColumnIndex("Question")));
//        	cursor.move(1);
//        }
        database.close();
        finish();
	}
	
}
