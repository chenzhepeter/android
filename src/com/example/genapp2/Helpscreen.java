package com.example.genapp2;

import android.os.Bundle;
import android.app.Activity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.view.View;

public class Helpscreen extends Activity {
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_helpscreen);
	
	
		 if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
	            // Show the Up button in the action bar.
	            getActionBar().setDisplayHomeAsUpEnabled(true);
	        }
		 }
	public void profScreen(View view){
    	Intent intent = new Intent(this,Profscreen.class);
    	startActivity(intent);
    }
	
	public void scanScreen(View view){
		Intent intent= new Intent(this,MainActivity.class);
		startActivity(intent);
	}

	
}
