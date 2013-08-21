package com.example.genapp2;




import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;

import android.os.Bundle;
import android.os.Parcelable;

import android.app.Activity;
import android.app.PendingIntent;

import android.view.Menu;
import android.view.View;
import android.widget.Toast;
import android.content.*;
public class MainActivity extends Activity {
	private static final String TAG = "NFCReadTag";
    private NfcAdapter mNfcAdapter;
    private IntentFilter[] mNdefExchangeFilters;
    private PendingIntent mNfcPendingIntent;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);

        mNfcPendingIntent = PendingIntent.getActivity(this, 0, new Intent(this,
                getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP
                | Intent.FLAG_ACTIVITY_CLEAR_TOP), 0);


        IntentFilter nfcIntent = new IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED);
        nfcIntent.addDataScheme("text/plain");      
        mNdefExchangeFilters = new IntentFilter[] { nfcIntent };
        onNewIntent(getIntent());
    }
	
	@Override
    protected void onPause() {
        super.onPause();
        if(mNfcAdapter != null) mNfcAdapter.disableForegroundDispatch(this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);      
        if (mNfcAdapter.ACTION_NDEF_DISCOVERED.equals(intent.getAction())) {
            NdefMessage[] messages = null;
            Parcelable[] rawMsgs = intent.getParcelableArrayExtra(mNfcAdapter.EXTRA_NDEF_MESSAGES);
            if (rawMsgs != null) {
                messages = new NdefMessage[rawMsgs.length];
                for (int i = 0; i < rawMsgs.length; i++) {
                    messages[i] = (NdefMessage) rawMsgs[i];
                }}
                else if (rawMsgs == null){
                    Toast.makeText(getApplicationContext(), "No NDEF Message Read", Toast.LENGTH_LONG).show();
                }
            if(messages[0] != null) {
                String result="";
                byte[] payload = messages[0].getRecords()[0].getPayload();
                for (int b = 3; b<payload.length; b++) { // skip SOH
                    result += (char) payload[b];
                }
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
            }
        }
        else Toast.makeText(getApplicationContext(), "Intent Error...", Toast.LENGTH_LONG).show();

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
