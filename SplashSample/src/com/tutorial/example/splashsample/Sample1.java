/**
 * 
 */
package com.tutorial.example.splashsample;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;

/**
 * @author julioa
 * 
 */
public class Sample1 extends Activity {
	// used to know if the back button was pressed in the splash screen activity
	// and avoid opening the next activity
	private boolean mIsBackButtonPressed;
	private static final int SPLASH_DURATION = 2000; // 2 seconds

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(this);
		// Obtain the sharedPreference, default to true if not available
		boolean isSplashEnabled = sp.getBoolean("isSplashEnabled", true);

		if (isSplashEnabled) {

			setContentView(R.layout.sample1);

			Handler handler = new Handler();

			// run a thread after 2 seconds to start the home screen
			handler.postDelayed(new Runnable() {

				@Override
				public void run() {

					// make sure we close the splash screen so the user won't
					// come
					// back when it presses back key

					finish();

					if (!mIsBackButtonPressed) {
						// start the home screen if the back button wasn't
						// pressed
						// already
						Intent intent = new Intent(Sample1.this,
								MainActivity.class);
						Sample1.this.startActivity(intent);
					}

				}

			}, SPLASH_DURATION); // time in milliseconds (1 second = 1000
									// milliseconds) until the run() method will
									// be
									// called
		} else {
			finish();

			if (!mIsBackButtonPressed) {
				// start the home screen if the back button wasn't pressed
				// already
				Intent intent = new Intent(Sample1.this, MainActivity.class);
				Sample1.this.startActivity(intent);
			}
		}
	}

	@Override
	public void onBackPressed() {

		// set the flag to true so the next activity won't start up
		mIsBackButtonPressed = true;
		super.onBackPressed();

	}
}
