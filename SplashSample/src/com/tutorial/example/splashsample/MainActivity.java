package com.tutorial.example.splashsample;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

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
	
}
