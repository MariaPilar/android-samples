package com.example.tutorialconexion;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		new NetTask().execute();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return false;
	}

	

	
	private class NetTask extends AsyncTask<Object, Object, Object> {

		String nubes = "Sin definir";
		
		@Override
		protected Object doInBackground(Object... params) {
			fillData();
			return null;
		}
		
		@Override
		protected void onPostExecute(Object result) {
			TextView textView = (TextView)findViewById(R.id.texto1);
			
			textView.setText(nubes);			
		};
		
		
		public void fillData() {
			URL url = null;
			try {
				url = new URL("http://api.openweathermap.org/data/2.5/weather?q=Madrid,es&units=metric&lang=sp");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
			
			HttpURLConnection urlConnection = null;
			try {
				urlConnection = (HttpURLConnection) url.openConnection();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			StringBuffer stringBuffer = new StringBuffer();		
			
			try {
				InputStream is = urlConnection.getInputStream();
				BufferedInputStream buffStream = new BufferedInputStream(is);
				
				byte[] buffer = new byte[1024];
				
				while (buffStream.read(buffer) != -1) {
					stringBuffer.append(new String(buffer));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				JSONObject jobj = new JSONObject(stringBuffer.toString());
				
				nubes = jobj.getJSONArray("weather").getJSONObject(0).getString("description");
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		
	}
}
