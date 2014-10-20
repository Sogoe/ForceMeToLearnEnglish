package com.fruitsalad.fmtle.receiver;

import com.fruitsalad.fmtle.activity.ExamActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ScreenOnOffReciever extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		if (intent.getAction() == Intent.ACTION_SCREEN_ON) {
			Intent exam_intent = new Intent(context, ExamActivity.class);
			exam_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(exam_intent);
		}

		if (intent.getAction() == Intent.ACTION_SCREEN_OFF) {
			
		}
	}
}
