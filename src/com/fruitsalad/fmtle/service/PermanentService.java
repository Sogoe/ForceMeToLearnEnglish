package com.fruitsalad.fmtle.service;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

import com.fruitsalad.fmtle.receiver.ScreenOnOffReciever;
import com.fruitsalad.fmtle.utils.DataBaseHelper;

public class PermanentService extends Service {
	private static String TAG = "Permanent Service";
	private ScreenOnOffReciever recevier = null;

	
	@Override
	public void onCreate() {
		super.onCreate();
		Log.v(TAG, "service created!");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
		if(recevier == null) {
			
			recevier = new ScreenOnOffReciever();
			IntentFilter intentFilter = new IntentFilter();
			intentFilter.addAction(Intent.ACTION_SCREEN_ON);
			intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
			registerReceiver(recevier, intentFilter);
			
			Log.v(TAG, "broadcast registered!");
		}
		
		return Service.START_STICKY;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		
		unregisterReceiver(recevier);
		recevier = null;
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
}
