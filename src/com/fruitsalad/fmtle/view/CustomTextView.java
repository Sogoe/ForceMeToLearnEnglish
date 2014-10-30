package com.fruitsalad.fmtle.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.fruitsalad.fmtle.app.ClientApplication;

public class CustomTextView extends TextView {
	private Typeface fontStyle = null;

	public CustomTextView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

		ClientApplication cApp = (ClientApplication) context
				.getApplicationContext();
		fontStyle = cApp.getFontStyle();
		setTypeface(fontStyle);
	}
}
