package com.fruitsalad.fmtle.view;

import com.fruitsalad.fmtle.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

public class CircleView extends View {
	//背景色
	private int backgroundColor;
	//文字颜色
	private int textColor;
	//数字
	private int number;
	private Paint paint;

	public CircleView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		
		TypedArray typeArray = context.obtainStyledAttributes(attrs, R.styleable.CircleView);
		backgroundColor = typeArray.getColor(R.styleable.CircleView_backgroundColor, 0xff80fefe);
		textColor = typeArray.getColor(R.styleable.CircleView_textColor, 0xffffffff);
		number = typeArray.getInt(R.styleable.CircleView_number, 99);
		typeArray.recycle();
		
		paint = new Paint();
	}

	@Override
	protected void onDraw(Canvas canvas) {		
		float centre = getWidth() / 2;
		
		int textSize = getWidth()/3;
		
		paint.setColor(backgroundColor);
		paint.setStyle(Paint.Style.FILL);
		paint.setAntiAlias(true);
		
		canvas.drawCircle(centre, centre, centre, paint);
		
		paint.setStrokeWidth(0);
		paint.setTextSize(textSize);
		paint.setColor(textColor);
		paint.setStyle(Paint.Style.STROKE);
		paint.setTypeface(Typeface.DEFAULT_BOLD);
		float textWidth = paint.measureText("" + number);
		FontMetrics fm = paint.getFontMetrics();
		float baseline = (getWidth() - (fm.bottom - fm.top))/2 -fm.top;
		canvas.drawText("" + number, centre - 2*textWidth/3, baseline, paint);
		
		paint.setTextSize(textSize*4/5);
		canvas.drawText("%", centre + 1*textWidth/3, baseline, paint);
	}
}
