package com.fruitsalad.fmtle.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.fruitsalad.fmtle.R;

public class ExamActivity extends Activity {
	private View view = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Intent intent = getIntent();
		
		WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
		layoutParams.flags = WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD;
		LayoutInflater inflater = LayoutInflater.from(this);
		view = inflater.inflate(R.layout.settings, null);
		WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
		windowManager.addView(view, layoutParams);
		
		Log.v("create Activity", "created!");
	}
}
