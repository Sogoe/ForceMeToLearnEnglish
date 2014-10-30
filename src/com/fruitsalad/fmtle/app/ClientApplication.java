package com.fruitsalad.fmtle.app;

import com.fruitsalad.fmtle.utils.DataBaseHelper;

import android.app.Application;
import android.graphics.Typeface;

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
