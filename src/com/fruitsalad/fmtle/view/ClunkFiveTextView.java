package com.fruitsalad.fmtle.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class ClunkFiveTextView extends TextView{
	private Typeface clunkFive = null;

	public ClunkFiveTextView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}	
	
	public ClunkFiveTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
		clunkFive = Typeface.createFromAsset(context.getAssets(), "Chunkfive.ttf");
		setTypeface(clunkFive);
	}
}
