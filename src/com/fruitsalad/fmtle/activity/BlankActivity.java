package com.fruitsalad.fmtle.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class BlankActivity extends Activity {
	public static final String SHOW_NOTHING = "nothing";
	public static final String FROM_RECEIVER = "from receiver";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Intent intent = getIntent();
		if (intent.getAction() == SHOW_NOTHING) {
			finish();
		} else if (intent.getAction() == FROM_RECEIVER) {
			Intent startExam = new Intent(this, ExamActivity.class);
			startActivity(startExam);
			finish();
		} else {
			Intent startSettings = new Intent(this, SettingsActivity.class);
			startActivity(startSettings);
			
			//TODO
			finish();
		}
	}
}
