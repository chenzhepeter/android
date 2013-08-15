package com.example.genapp2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.content.*;
public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void helpScreen(View view){
    	Intent intent = new Intent(this, Helpscreen.class);
    	startActivity(intent);
    }
    
    public void profScreen(View view){
    	Intent intent = new Intent(this,Profscreen.class);
    	startActivity(intent);
    }
    
    public void qrScan(View view){
    	Intent qrDroid=new Intent("la.droid.qr.scan");
    	startActivityForResult(qrDroid,0);
    }
}
