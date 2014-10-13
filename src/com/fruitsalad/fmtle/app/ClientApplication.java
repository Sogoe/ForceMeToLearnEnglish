package com.fruitsalad.fmtle.app;

import android.app.Application;
import android.view.View;

public class ClientApplication extends Application {
	private View view = null;
	
	@Override
	public void onCreate() {
		super.onCreate();
	}

	@Override
	public void onTerminate() {
		super.onTerminate();
		
		view = null;
	}
	
	public View getView() {
		return view;
	}
	
	public void clearView() {
		view = null;
	}
	
	public void setView(View view) {
		this.view = view;
	}
}
