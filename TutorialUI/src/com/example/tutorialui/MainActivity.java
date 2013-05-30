package com.example.tutorialui;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TextView textView = (TextView) findViewById(R.id.text1);
		textView.setText("Cambio Texto 1");

		Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// 1. Instantiate an AlertDialog.Builder with its constructor
				AlertDialog.Builder builder = new AlertDialog.Builder(v
						.getContext());

				// 2. Chain together various setter methods to set the dialog
				// characteristics
				builder.setMessage("Botón 2 Pulsado").setTitle("Botón 2");

				// 3. Get the AlertDialog from create()
				AlertDialog dialog = builder.create();

				dialog.show();
			}
		});
		
		ListView listView1 = (ListView) findViewById(R.id.listView1);
		
		ArrayList lista = new ArrayList();
		lista.add("Uno");
		lista.add("Dos");
		
		//ArrayAdapter adapter = new ArrayAdapter(this, R.id.listView1, lista);
		
		//listView1.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void clickBoton1(View view) {
		Toast toast = Toast.makeText(this, "Botón 1 pulsado",
				Toast.LENGTH_SHORT);
		toast.show();
	}

}
