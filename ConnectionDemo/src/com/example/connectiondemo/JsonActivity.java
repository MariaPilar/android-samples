package com.example.connectiondemo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class JsonActivity extends Activity {

	private class DownloadTask extends AsyncTask<Object, Object, Object> {
		StringBuffer texto = new StringBuffer();
		
		@Override
		protected Object doInBackground(final Object... urls) {
			fillData();

			return null;
		}

		@Override
		protected void onPostExecute(final Object result) {
			TextView textItem = (TextView) findViewById(R.id.text_json);
			textItem.setText(texto);			
		}

		@Override
		protected void onPreExecute() {
		}
		
		protected void fillData() {
			String content = HttpHelper
					.getContent("http://api.twitter.com/1/statuses/user_timeline.json?screen_name=fernandopcg");

			Log.i("Prev", content);


			JSONArray array;
			try {
				array = new JSONArray(content);
				for (int i = 0; i < array.length(); i++) {
					JSONObject item = array.getJSONObject(i);
					String aux = item.getString("text");
					Log.i("Json", aux);
					texto.append(aux).append("\n").append("-----------------------").append("\n");
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}		
	}



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_json);

		new DownloadTask().execute();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.json, menu);
		return true;
	}
}
