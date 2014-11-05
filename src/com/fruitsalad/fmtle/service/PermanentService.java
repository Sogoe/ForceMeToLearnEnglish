package com.fruitsalad.fmtle.service;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

import com.fruitsalad.fmtle.receiver.ScreenOnOffReciever;

public class PermanentService extends Service {
	private ScreenOnOffReciever recevier = null;
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		if(recevier == null) {
			
			recevier = new ScreenOnOffReciever();
			IntentFilter intentFilter = new IntentFilter();
			intentFilter.addAction(Intent.ACTION_USER_PRESENT);
			intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
			registerReceiver(recevier, intentFilter);
			
		}
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
		return Service.START_STICKY;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		
		unregisterReceiver(recevier);
		recevier = null;
		
		startService(new Intent(PermanentService.this, PermanentService.class));
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
}
