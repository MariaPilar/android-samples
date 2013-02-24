package com.tutorial.example.splashsample;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;

public class Sample3 extends Activity{
	/**
	 * Simple Dialog used to show the splash screen
	 */
	protected Dialog mSplashDialog;
	 
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	 
	    MyStateSaver data = (MyStateSaver) getLastNonConfigurationInstance();
	    if (data != null) {
	        // Show splash screen if still loading
	        if (data.showSplashScreen) {
	            showSplashScreen();
	        }
	        setContentView(R.layout.activity_main);        
	 
	        // Rebuild your UI with your saved state here
	    } else {
	        showSplashScreen();
	        setContentView(R.layout.activity_main);
	        // Do your heavy loading here on a background thread
	    }
	}
	 
	@Override
	public Object onRetainNonConfigurationInstance() {
	    MyStateSaver data = new MyStateSaver();
	    // Save your important data here
	 
	    if (mSplashDialog != null) {
	        data.showSplashScreen = true;
	        removeSplashScreen();
	    }
	    return data;
	}
	 
	/**
	 * Removes the Dialog that displays the splash screen
	 */
	protected void removeSplashScreen() {
	    if (mSplashDialog != null) {
	        mSplashDialog.dismiss();
	        mSplashDialog = null;
	    }
	}
	 
	/**
	 * Shows the splash screen over the full Activity
	 */
	protected void showSplashScreen() {
	    mSplashDialog = new Dialog(this, R.style.SplashScreen);
	    mSplashDialog.setContentView(R.layout.sample1);
	    mSplashDialog.setCancelable(false);
	    mSplashDialog.show();
	     
	    // Set Runnable to remove splash screen just in case
	    final Handler handler = new Handler();
	    handler.postDelayed(new Runnable() {
	      @Override
	      public void run() {
	        removeSplashScreen();
	      }
	    }, 3000);
	}
	 
	/**
	 * Simple class for storing important data across config changes
	 */
	private class MyStateSaver {
	    public boolean showSplashScreen = false;
	    // Your other important fields here
	}
}
