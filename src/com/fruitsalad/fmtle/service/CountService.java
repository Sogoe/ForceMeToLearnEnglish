package com.fruitsalad.fmtle.service;

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
		int temp = 0;
		switch (cmd) {
		case COUNT_RIGHT:
			spf = getSharedPreferences("count_spf", Context.MODE_PRIVATE);
			temp = spf.getInt("right", 0);
			edit = spf.edit();
			edit.putInt("right", ++temp);
			edit.commit();
			break;
		case COUNT_WRONG:
			spf = getSharedPreferences("count_spf", Context.MODE_PRIVATE);
			temp = spf.getInt("wrong", 0);
			edit = spf.edit();
			edit.putInt("wrong", ++temp);
			edit.commit();
			break;
		case COUNT_SKIP:
			spf = getSharedPreferences("count_spf", Context.MODE_PRIVATE);
			temp = spf.getInt("skip", 0);
			edit = spf.edit();
			edit.putInt("skip", ++temp);
			edit.commit();
			break;
		}
	}
}
