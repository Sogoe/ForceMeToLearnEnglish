package com.fruitsalad.fmtle.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;

import com.fruitsalad.fmtle.R;
import com.fruitsalad.fmtle.database.English;
import com.fruitsalad.fmtle.utils.DataBaseHelper;
import com.fruitsalad.fmtle.view.CustomTextView;

public class ExamActivity extends Activity implements OnClickListener {
	private int right_index;
	private Handler handler;
	private int[] bg_list = { R.drawable.bg1, R.drawable.bg2, R.drawable.bg3,
			R.drawable.bg4, R.drawable.bg5, R.drawable.bg6, R.drawable.bg7 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
		layoutParams.flags = WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
				| WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED;
		getWindow().setAttributes(layoutParams);

		setContentView(R.layout.exam);

		handler = new Handler();

		init();
	}

	private void init() {
		CustomTextView skipTextView = (CustomTextView) findViewById(R.id.skip);
		CustomTextView choice_a = (CustomTextView) findViewById(R.id.choice_a);
		CustomTextView choice_b = (CustomTextView) findViewById(R.id.choice_b);
		CustomTextView choice_c = (CustomTextView) findViewById(R.id.choice_c);
		CustomTextView choice_d = (CustomTextView) findViewById(R.id.choice_d);
		ImageView img = (ImageView) findViewById(R.id.image_view);
		img.setImageResource(bg_list[(int) (Math.random() * 7)]);
		skipTextView.setOnClickListener(this);
		choice_a.setOnClickListener(this);
		choice_b.setOnClickListener(this);
		choice_c.setOnClickListener(this);
		choice_d.setOnClickListener(this);

		CustomTextView english = (CustomTextView) findViewById(R.id.english);
		CustomTextView symbol = (CustomTextView) findViewById(R.id.symbol);
		English[] list = DataBaseHelper.ramdomQuery();
		right_index = (int) (Math.random() * 4);
		english.setText(list[right_index].getEnglish());
		symbol.setText("[" + list[right_index].getSymbol() + "]");

		choice_a.setText(list[0].getChinese());
		choice_b.setText(list[1].getChinese());
		choice_c.setText(list[2].getChinese());
		choice_d.setText(list[3].getChinese());

		choice_a.setTag(0);
		choice_b.setTag(1);
		choice_c.setTag(2);
		choice_d.setTag(3);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		switch (keyCode) {
		case KeyEvent.KEYCODE_MENU:
		case KeyEvent.KEYCODE_BACK:
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.skip:
			finish();
			break;
		case R.id.choice_a:
		case R.id.choice_b:
		case R.id.choice_c:
		case R.id.choice_d:
			if ((Integer) v.getTag() == right_index) {
				v.setBackgroundResource(R.drawable.right_press_bg);
				handler.postDelayed(new Runnable() {

					@Override
					public void run() {
						finish();
					}
				}, 1000);
			} else {
				v.setBackgroundResource(R.drawable.wrong_press_bg);
				v.setClickable(false);
			}
			break;
		}
	}
}
