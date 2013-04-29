package com.example.persistence;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class PreferenceActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_preference);
		//updateText();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.preference, menu);
		return true;
	}
	
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
	
	@Override
	protected void onResume() {
		super.onResume();
		updateText();
	};
	
	public void aumentaCuenta(View view) {
		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(this);
		
		int cuenta = sp.getInt("cuenta", 0);
		
		SharedPreferences.Editor editor = sp.edit();
		
		editor.putInt("cuenta", ++cuenta);
		
		editor.commit();
		
		updateText();		
	}
	

	public void updateText() {
		TextView textView = (TextView)this.findViewById(R.id.textView1);
		TextView textView2 = (TextView)this.findViewById(R.id.textView2);
		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(this);
		
		int cuenta = sp.getInt("cuenta", 0);
		String textoDemo = sp.getString("texto_demo", "Sin Definir");
		
		textView.setText(Integer.toString(cuenta));
		textView2.setText(textoDemo);
	}
	
}
