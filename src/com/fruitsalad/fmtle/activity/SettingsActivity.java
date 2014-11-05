package com.fruitsalad.fmtle.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.fruitsalad.fmtle.R;
import com.fruitsalad.fmtle.service.PermanentService;
import com.fruitsalad.fmtle.view.CircleView;

public class SettingsActivity extends Activity {
	private CircleView cv = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Log.v("SettingsActivity", "on create!");
		
		setContentView(R.layout.settings);

		cv = (CircleView) findViewById(R.id.number);
	}

	@SuppressLint("InlinedApi")
	@Override
	protected void onStart() {
		super.onStart();
		
		Intent intent = new Intent(this, PermanentService.class);
		if (Build.VERSION.SDK_INT >= 12)
			intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
		startService(intent);

		SharedPreferences spf = getSharedPreferences("count_spf",
				Context.MODE_PRIVATE);
		int right = spf.getInt("right", 0);
		int wrong = spf.getInt("wrong", 0);
		int skip = spf.getInt("skip", 0);
		int b = (right + wrong) == 0 ? 0 : right * 100 / (right + wrong);
		cv.setNumber(b);
	}
}
