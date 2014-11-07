package com.fruitsalad.fmtle.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.fruitsalad.fmtle.activity.BlankActivity;
import com.fruitsalad.fmtle.activity.ExamActivity;

public class ScreenOnOffReciever extends BroadcastReceiver {
	
	@Override
	public void onReceive(Context context, Intent intent) {
		
		if (intent.getAction() == Intent.ACTION_USER_PRESENT) {
			Log.v("ScreenOnOff", "on!!!");
			Intent exam_intent = new Intent(context, ExamActivity.class);
			exam_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(exam_intent);
		}
		
		if (intent.getAction() == Intent.ACTION_SCREEN_OFF) {
			Log.v("ScreenOnOff", "off!!!");
			Intent exam_intent = new Intent(context, BlankActivity.class);
			exam_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
			exam_intent.setAction(BlankActivity.FROM_RECEIVER);
			context.startActivity(exam_intent);
		}
	}
}
