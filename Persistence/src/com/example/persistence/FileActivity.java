package com.example.persistence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class FileActivity extends Activity {

	String FILENAME = "demo_file";	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_file);
	}
	

	protected void onResume() {
		super.onResume();
		
		readFile(null);
	};	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.file, menu);
		return false;
	}
	
	public void writeFile(View view) {		

		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(this);
		
		int cuenta = sp.getInt("cuenta", 0);
		String textoDemo = sp.getString("texto_demo", "Sin Definir");

		String string = textoDemo + " - " + cuenta;
		
		FileOutputStream fos;
		try {
			fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		
		try {
			fos.write(string.getBytes());
			fos.close();			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void readFile(View view) {
		String string = "hello world!";

		TextView textView = (TextView)findViewById(R.id.text_file);		
		
		FileInputStream fis;
		try {
			fis = openFileInput(FILENAME);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			textView.setText("Error abriendo archivo");
			return;
		}
		
		
		try {
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			String result = new String(buffer);

			textView.setText(result);
			fis.close();			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			textView.setText("Error leyendo archivo");			
		}
	}
	
}
