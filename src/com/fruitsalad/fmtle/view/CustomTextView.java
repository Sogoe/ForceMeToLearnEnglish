package com.fruitsalad.fmtle.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.fruitsalad.fmtle.R;

public class CustomTextView extends TextView {
	private Typeface fontStyle = null;

	public CustomTextView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

		TypedArray typedArray = context.obtainStyledAttributes(attrs,
				R.styleable.CustomTextview);
		int index = typedArray.getInt(R.styleable.CustomTextview_fontStyle, 0);
		typedArray.recycle();

		fontStyle = Typeface.createFromAsset(context.getAssets(),
				FontStyleMap.getFontStyle(index));
		setTypeface(fontStyle);
	}
}
