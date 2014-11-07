package com.fruitsalad.fmtle.view;

import com.fruitsalad.fmtle.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

public class UnderlineTextView extends TextView {
	// 线条颜色
	private int strokeColor = 0;
	// 线条宽度
	private float strokeWidth = 0;
	private Paint paint = null;

	public UnderlineTextView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public UnderlineTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

		TypedArray typedArray = context.obtainStyledAttributes(attrs,
				R.styleable.UnderlineTextView);
		strokeColor = typedArray.getColor(R.styleable.UnderlineTextView_strokeColor, 0xffbd60c7);
		strokeWidth = typedArray.getDimension(R.styleable.UnderlineTextView_strokeWidth, 2);
		typedArray.recycle();
		
		paint = new Paint(Paint.ANTI_ALIAS_FLAG);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		int height = getHeight();
		int width = getWidth();
		
		//draw underline
		paint.setColor(strokeColor);
		paint.setStrokeWidth(strokeWidth);
		paint.setStyle(Paint.Style.FILL_AND_STROKE);
		
		canvas.drawLine(0, height-strokeWidth, width, height-strokeWidth, paint);
	}
}
