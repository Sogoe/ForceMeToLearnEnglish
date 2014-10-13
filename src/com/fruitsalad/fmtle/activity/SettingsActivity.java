package com.fruitsalad.fmtle.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.fruitsalad.fmtle.R;
import com.fruitsalad.fmtle.service.PermanentService;

public class SettingsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.settings);
		
		Intent intent = new Intent(this, PermanentService.class);
		startService(intent);
	}

}
