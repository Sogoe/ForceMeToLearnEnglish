package com.fruitsalad.fmtle.database;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ExamDataBaseHelper extends SQLiteOpenHelper {
	private static String db_name = "exam.db";
	private static int db_version = 1;
	private Context mContext = null;
	private static String create_sql = "CREATE TABLE IF NOT EXISTS 'EXAM_SIJI' ("
			+ "_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ "ENGLISH VARCHAR(1111130),"
			+ "SYMBOL VARCHAR(20),"
			+ "CHINESE TEXT,"
			+ "COUNT INTEGER DEFAULT 0"
			+ ")";

	public ExamDataBaseHelper(Context context) {
		super(context, db_name, null, db_version);
		this.mContext = context;
		copyDataBase("exam.db");
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
/*		db.beginTransaction();
		db.execSQL(create_sql);
		db.setTransactionSuccessful();
		db.endTransaction();
		
	    insertData(db, "EXAM_SIJI", "siji.txt");*/
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}
	
	private void copyDataBase(String fileName) {
		if(fileName == null || fileName.trim() == "")
			return;
		String db_path = "/data/data/" + mContext.getPackageName() + "/databases/";
		File db_dir = new File(db_path);
		if(!db_dir.exists())
			db_dir.mkdirs();
		File db_file = new File(db_dir, db_name);
		if(db_file.exists())
			return;
		try {
			InputStream is = mContext.getAssets().open(fileName);
			FileOutputStream fos = new FileOutputStream(db_file);
			byte[] temp = new byte[1024];
			int len = 0;
			while((len = is.read(temp)) != -1) {
				fos.write(temp, 0, len);
			}
			fos.flush();
			fos.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
/*	private void insertData(SQLiteDatabase db, String tableName, String fileName) {
		if(tableName == null || tableName.trim() == "" 
				|| fileName == null || fileName.trim() == "")
			return;
		try {
			InputStream is = mContext.getAssets().open(fileName);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line = "";
			String[] splitList = {};
			ContentValues cv = new ContentValues();
			db.beginTransaction();
			do {				
				splitList = line.trim().split("/");
				if(splitList.length == 3) {
					cv.put("ENGLISH", splitList[0].trim());
					cv.put("SYMBOL", splitList[1].trim());
					cv.put("CHINESE", splitList[2].trim());
					db.insert(tableName, "ENGLISH", cv);
				}
				line = br.readLine();
			}while(line != null);
			db.setTransactionSuccessful();
			db.endTransaction();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
}
