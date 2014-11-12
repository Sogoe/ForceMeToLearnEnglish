package com.fruitsalad.fmtle.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.text.Html;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.fruitsalad.fmtle.R;
import com.fruitsalad.fmtle.database.English;
import com.fruitsalad.fmtle.service.CountService;
import com.fruitsalad.fmtle.utils.DataBaseHelper;
import com.fruitsalad.fmtle.view.CustomTextView;

public class ExamActivity extends Activity implements OnClickListener {
	private int right_index;
	private Handler handler;
	private int[] bg_list = { R.drawable.bg1, R.drawable.bg2, R.drawable.bg3,
			R.drawable.bg5, R.drawable.bg6, R.drawable.bg7 };
	private CustomTextView skipTextView;
	private CustomTextView choice_a;
	private CustomTextView choice_b;
	private CustomTextView choice_c;
	private CustomTextView choice_d;
	private SparseArray<CustomTextView> choiceList;
	private Vibrator vb;
	public final static String FROM_RECEIVER = "FROM RECEIVER";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.exam);
		handler = new Handler();
		init();
	}

	private void init() {
		skipTextView = (CustomTextView) findViewById(R.id.skip);
		choice_a = (CustomTextView) findViewById(R.id.choice_a);
		choice_b = (CustomTextView) findViewById(R.id.choice_b);
		choice_c = (CustomTextView) findViewById(R.id.choice_c);
		choice_d = (CustomTextView) findViewById(R.id.choice_d);
		ImageView img = (ImageView) findViewById(R.id.image_view);
		// TODO 以后增加自定义的壁纸功能
		img.setImageResource(bg_list[(int) (Math.random() * 6)]);

		skipTextView.setOnClickListener(this);
		choice_a.setOnClickListener(this);
		choice_b.setOnClickListener(this);
		choice_c.setOnClickListener(this);
		choice_d.setOnClickListener(this);

		CustomTextView english = (CustomTextView) findViewById(R.id.english);
		TextView symbol = (TextView) findViewById(R.id.symbol);
		// 从数据库获取随机英文序列
		English[] list = DataBaseHelper.ramdomQuery();
		// 随机正确答案
		right_index = (int) (Math.random() * 4);
		// 设置题目
		english.setText(list[right_index].getEnglish());
		symbol.setText("[" + list[right_index].getSymbol() + "]");
		choice_a.setText(Html.fromHtml("<font color='#fef5ac'> A. </font>"
				+ list[0].getChinese()));
		choice_b.setText(Html.fromHtml("<font color='#fef5ac'> B. </font>"
				+ list[1].getChinese()));
		choice_c.setText(Html.fromHtml("<font color='#fef5ac'> C. </font>"
				+ list[2].getChinese()));
		choice_d.setText(Html.fromHtml("<font color='#fef5ac'> D. </font>"
				+ list[3].getChinese()));

		choice_a.setTag(0);
		choice_b.setTag(1);
		choice_c.setTag(2);
		choice_d.setTag(3);

		choiceList = new SparseArray<CustomTextView>();
		choiceList.put(0, choice_a);
		choiceList.put(1, choice_b);
		choiceList.put(2, choice_c);
		choiceList.put(3, choice_d);

		vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
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
			overridePendingTransition(R.anim.exam_enter, R.anim.exam_exit);
			break;
		case R.id.choice_a:
		case R.id.choice_b:
		case R.id.choice_c:
		case R.id.choice_d:
			if ((Integer) v.getTag() == right_index) {
				v.setBackgroundResource(R.drawable.right_press_bg);
				sendCountData(CountService.COUNT_RIGHT);

				skipTextView.setClickable(false);

				handler.postDelayed(new Runnable() {

					@Override
					public void run() {
						finish();
						overridePendingTransition(R.anim.exam_enter,
								R.anim.exam_exit);
					}
				}, 700);
			} else {
				v.setBackgroundResource(R.drawable.wrong_press_bg);
				v.setClickable(false);
				sendCountData(CountService.COUNT_WRONG);
				vb.vibrate(100);

				choiceList.get(right_index).setBackgroundResource(
						R.drawable.right_press_bg);

				skipTextView.setText(R.string.wrong_notice);
			}

			choice_a.setClickable(false);
			choice_b.setClickable(false);
			choice_c.setClickable(false);
			choice_d.setClickable(false);

			break;
		}
	}

	private void sendCountData(int cmd) {
		Intent intent = new Intent(this, CountService.class);
		intent.setAction(String.valueOf(cmd));
		startService(intent);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}
