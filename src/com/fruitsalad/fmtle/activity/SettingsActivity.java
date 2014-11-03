package com.fruitsalad.fmtle.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.fruitsalad.fmtle.R;
import com.fruitsalad.fmtle.service.PermanentService;
import com.fruitsalad.fmtle.view.CircleView;

public class SettingsActivity extends Activity {
	private CircleView cv = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.settings);

		Intent intent = new Intent(this, PermanentService.class);
		startService(intent);

		cv = (CircleView) findViewById(R.id.number);
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		
		SharedPreferences spf = getSharedPreferences("count_spf", Context.MODE_PRIVATE);
		int right = spf.getInt("right", 0);
		int wrong = spf.getInt("wrong", 0);
		int skip = spf.getInt("skip", 0);
		int b = (right + wrong) == 0 ? 0 : right * 100
				/ (right + wrong);
		cv.setNumber(b);
	}
}
