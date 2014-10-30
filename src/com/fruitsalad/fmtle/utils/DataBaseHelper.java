package com.fruitsalad.fmtle.utils;

import java.util.Random;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.fruitsalad.fmtle.database.English;
import com.fruitsalad.fmtle.database.ExamDataBaseHelper;

public class DataBaseHelper {
	private static ExamDataBaseHelper helper = null;
	private static SQLiteDatabase db = null;
	private static String table = null;

	public static void init(Context context) {
		helper = new ExamDataBaseHelper(context);
		db = helper.getWritableDatabase();
		table = "EXAM_SIJI";
	}

	public static English[] ramdomQuery() {
		if (db == null)
			throw new IllegalArgumentException();
		Cursor cursor = db.rawQuery("select * from " + table, null);
		English[] list = new English[4];
		int count = cursor.getCount();
		Random r = new Random();
		for (int i = 0; i < 4; i++) {
			int index = r.nextInt(count);
			if (cursor.moveToPosition(index)) {
				list[i] = toEnglish(cursor);
			} else {
				i--;
			}
		}
		cursor.close();
		return list;
	}

	private static English toEnglish(Cursor cursor) {
		int col_english = cursor.getColumnIndex("ENGLISH");
		String english = cursor.getString(col_english);
		int col_chinese = cursor.getColumnIndex("CHINESE");
		String chinese = cursor.getString(col_chinese);
		int col_symbol = cursor.getColumnIndex("SYMBOL");
		String symbol = cursor.getString(col_symbol);
		int col_count = cursor.getColumnIndex("COUNT");
		int count = cursor.getInt(col_count);
		return new English(english, symbol, chinese, count);
	}
	
	public static void realse() {
		if(db != null && db.isOpen()) {
			db.close();
		}
		helper = null;
	}
}
