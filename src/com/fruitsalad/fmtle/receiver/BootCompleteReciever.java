package com.fruitsalad.fmtle.receiver;

import com.fruitsalad.fmtle.service.PermanentService;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BootCompleteReciever extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		
		Log.v("Reciever", "boot completed!");
		
		Intent n_intent = new Intent(context, PermanentService.class);
		context.startService(n_intent);
	}

}
