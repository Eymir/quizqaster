package com.android.Quizmaster;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends Activity {
	
    
	Button Start, Instructions, extras, Exit;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Initialize();
        
//listener for Button Instructions.
        
        Instructions.setOnClickListener(new OnClickListener() { public void onClick(View v) {  startActivity(new Intent(Main.this, Instructions.class));  }  });
        
//Listener for the Button Start.
        
        Start.setOnClickListener(new OnClickListener() {  public void onClick(View v) {  startActivity(new Intent(Main.this, Start.class));  }  });
        
//Listener for the  extras Button
        
        extras.setOnClickListener(new OnClickListener() {  public void onClick(View v) {  startActivity(new Intent(Main.this, Extras.class));  }  });
        
// Listener for the Exit Page.
        
    	Exit.setOnClickListener(new OnClickListener() {  public void onClick(View v) {  finish();  }  });
    }
    
    private void Initialize(){
    	Start = (Button) findViewById(R.id.start);
        Instructions = (Button) findViewById(R.id.instructions);
        extras = (Button) findViewById(R.id.extras);
        Exit = (Button) findViewById(R.id.exit);
    }
}


