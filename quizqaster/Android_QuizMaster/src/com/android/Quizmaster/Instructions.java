package com.android.Quizmaster;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Instructions extends Activity {

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructions);
        
        Button back = (Button) findViewById(R.id.Instructionsback);
        back.setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Instructions.this, Main.class));
			}
		});
    }
}
