package com.fruitsalad.fmtle.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.IBinder;

public class CountService extends IntentService {
	public static final int COUNT_RIGHT = 1;
	public static final int COUNT_WRONG = 2;
	public static final int COUNT_SKIP = 3;

	public CountService() {
		this("Count");
	}

	public CountService(String name) {
		super(name);
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		int cmd = Integer.parseInt(intent.getAction());
		SharedPreferences spf = null;
		Editor edit = null;
		String today = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
		int temp = 0;
		String date = "";
		switch (cmd) {
		case COUNT_RIGHT:
			spf = getSharedPreferences("count_spf", Context.MODE_PRIVATE);
			date = spf.getString("date", "2014-11-11");
			if(date.equals(today)) {
				temp = spf.getInt("right", 0);
			}else {
				temp = 0;
			}
			edit = spf.edit();
			edit.putInt("right", ++temp);
			edit.commit();
			break;
		case COUNT_WRONG:
			spf = getSharedPreferences("count_spf", Context.MODE_PRIVATE);
			date = spf.getString("date", "2014-11-11");
			if(date.equals(today)) {
				temp = spf.getInt("wrong", 0);
			}else {
				temp = 0;
			}
			temp = spf.getInt("wrong", 0);
			edit = spf.edit();
			edit.putInt("wrong", ++temp);
			edit.commit();
			break;
		case COUNT_SKIP:
			spf = getSharedPreferences("count_spf", Context.MODE_PRIVATE);
			date = spf.getString("date", "2014-11-11");
			if(date.equals(today)) {
				temp = spf.getInt("skip", 0);
			}else {
				temp = 0;
			}		
			temp = spf.getInt("skip", 0);
			edit = spf.edit();
			edit.putInt("skip", ++temp);
			edit.commit();
			break;
		}
	}
}
