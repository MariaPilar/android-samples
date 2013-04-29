package com.example.persistence;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
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
	
	public void lanzaPreferencias(View view) {
		Intent intent = new Intent(this, PreferenceActivity.class);
		this.startActivity(intent);
	}

	public void lanzaFiles(View view) {
		Intent intent = new Intent(this, FileActivity.class);
		this.startActivity(intent);
	}

}
