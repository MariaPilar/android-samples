package com.tutorial.example.splashsample;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clickSample1(v);
            }
        });		
		
        Log.i(this.getClass().getName(), "onCreate");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
        Log.i(this.getClass().getName(), "onCreateOptionsMenu");
		return true;
	}
	
	/**
	 * This method will be called any time a user selects one of the options
	 * on the menu. For the implementation, whichever button is clicked is
	 * mapped onto the relevant activity.
	 * @param item MenuItem
	 * @return boolean
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
			case R.id.action_settings:
				startActivity(new Intent(this, EditPreferences.class));
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}	
	
	public void clickSample1(View view) {
        Intent intent = new Intent(this, Sample1.class);
        this.startActivity(intent);
	}

	public void clickSample2(View view) {
        Intent intent = new Intent(this, Sample2.class);
        this.startActivity(intent);
	}
	
	public void clickSample3(View view) {
        Intent intent = new Intent(this, Sample3.class);
        this.startActivity(intent);
	}
	
	public void clickSample4(View view) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
	    builder.setMessage("Are you sure You want to exit")
	        .setCancelable(false)
	        .setPositiveButton("YES",
	        new OnClickListener() {
	            // On
	            // clicking
	            // "Yes"
	            // button

	            public void onClick(DialogInterface dialog,int id) {
	            	Log.i(this.getClass().getName(), " onClick ");
	                closeApplication(); // Close Application method called
	            }
	        })
	        .setNegativeButton("NO",
	        new DialogInterface.OnClickListener() {
	            // On
	            // clicking
	            // "No"
	            // button
	            public void onClick(DialogInterface dialog,int id) {
	                dialog.cancel();
	            }
	        });

	        AlertDialog alert = builder.create();
	        alert.show();
	}
	
	private void closeApplication() {
		Log.i(this.getClass().getName(), "closeApplication ");
        this.finish();
        //
    }	
	
	public void onDestroy() {
        super.onDestroy();
        Log.i(this.getClass().getName(), "onDestory");
    }	
}
