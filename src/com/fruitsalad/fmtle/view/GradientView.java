package com.fruitsalad.fmtle.view;

import java.util.Calendar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class GradientView extends View {
	private LinearGradient linearGradient = null;
	private int width = 0;
	private int height = 0;
	private Paint paint = new Paint();
	private Rect rect = null;
	
	public GradientView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public GradientView(Context context, AttributeSet attrs,
			int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		
		//获取屏幕尺寸
		DisplayMetrics display = context.getResources().getDisplayMetrics();
		width = display.widthPixels;
		height = display.heightPixels;
		rect = new Rect(0, 0, width, height);
		
		Calendar now = Calendar.getInstance();
		int hour = now.get(Calendar.HOUR_OF_DAY);
		if(hour >= 20 || hour <= 8) {
			linearGradient = new LinearGradient(width/2, 0, width/2, height, 
					new int[]{0xaa03263a, 0x7714446a}, null, Shader.TileMode.CLAMP);
		}else {
			linearGradient = new LinearGradient(width/2, 0, width/2, height, 
					new int[]{0xaade7d2c, 0x77fada8d}, null, Shader.TileMode.CLAMP);
		}
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		paint.setShader(linearGradient);
		canvas.drawRect(rect, paint);
	}
}
