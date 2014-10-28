package com.fruitsalad.fmtle.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.TextView;

import com.fruitsalad.fmtle.R;

public class ExamActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//设置activity覆盖锁屏
		WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
		layoutParams.flags = WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
					| WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED;	
		getWindow().setAttributes(layoutParams);
		
		setContentView(R.layout.exam);
		
		
		
		initEvents();
	}

	private void initEvents() {

	}
	
	
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		//屏蔽menu键和返回键
		switch(keyCode) {
		case KeyEvent.KEYCODE_MENU:
		case KeyEvent.KEYCODE_BACK:
			return true;
		}	
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onClick(View v) {
		
	}
}
