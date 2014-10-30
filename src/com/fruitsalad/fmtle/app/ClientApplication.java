package com.fruitsalad.fmtle.app;

import android.app.Application;
import android.graphics.Typeface;

import com.fruitsalad.fmtle.utils.DataBaseHelper;

public class ClientApplication extends Application {
	private Typeface fontStyle = null;

	@Override
	public void onCreate() {
		super.onCreate();
		
		fontStyle = Typeface.createFromAsset(getAssets(), "FZLTXHK_GBK.ttf");
		DataBaseHelper.init(this);
	}

	@Override
	public void onTerminate() {
		super.onTerminate();
		
		fontStyle = null;
		DataBaseHelper.realse();
	}
	
	public Typeface getFontStyle() {
		return fontStyle;
	}
}
