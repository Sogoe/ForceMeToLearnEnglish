package com.fruitsalad.fmtle.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.fruitsalad.fmtle.R;
import com.fruitsalad.fmtle.database.ExamDataBaseHelper;
import com.fruitsalad.fmtle.service.PermanentService;

public class SettingsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.settings);
		
		Intent intent = new Intent(this, PermanentService.class);
		startService(intent);
		
		ExamDataBaseHelper dbHelper = new ExamDataBaseHelper(this);
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		Cursor cursor = db.query("EXAM_SIJI", null, "_ID=?", new String[]{"2"}, null, null, null);
		TextView text_view = (TextView) findViewById(R.id.textView1);
		if(cursor.moveToFirst()) {
			int col_english = cursor.getColumnIndex("ENGLISH");
			String englisth = cursor.getString(col_english);
			
			text_view.setText(englisth);
		}
		
		text_view.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SettingsActivity.this, ExamActivity.class);
				startActivity(intent);
			}
		});
	}

}
