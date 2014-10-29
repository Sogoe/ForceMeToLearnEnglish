package com.fruitsalad.fmtle.view;

import android.util.SparseArray;

public class FontStyleMap {
	private static SparseArray<String> hashMap = new SparseArray<String>();
	
	static {
		hashMap.put(0, "Gotham_Light.otf");
		hashMap.put(1, "FZLTXHK_GBK.ttf");
	}
	
	public static String getFontStyle(int index) {
		return hashMap.get(index);
	}
}
