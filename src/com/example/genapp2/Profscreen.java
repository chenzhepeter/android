package com.example.genapp2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class Profscreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profscreen);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.profscreen, menu);
		return true;
	}
	public void helpScreen(View view){
    	Intent intent = new Intent(this, Helpscreen.class);
    	startActivity(intent);
	} 
	
	public void scanScreen(View view){
		Intent intent= new Intent(this,MainActivity.class);
		startActivity(intent);
	}

}
