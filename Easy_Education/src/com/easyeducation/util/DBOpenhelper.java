package com.easyeducation.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenhelper extends SQLiteOpenHelper {

	public DBOpenhelper(Context context) {
		super(context, "books.db", null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * æ°æ®åºç¬¬ä¸?æ¬¡è¢«åå»ºçæ¶åè°ç¨ç
	 * åè½ï¼åå»ºæ°æ®åºè¡?
	 */
	public void onCreate(SQLiteDatabase db) {
		// db.execSQL("CREATE TABLE HNIA_menu (id integer primary key autoincrement,buttonName  varchar(20)");
		// åå»ºæé®è¡¨ï¼åå«ç¸å³çjosnæ°æ®
		db.execSQL("CREATE TABLE MENU_URL (Menu_id integer primary key autoincrement,appId integer,buttonName varchar(50),id integer,imageUrl varchar(1024),sort varchar(10),spiderId integer,url varchar(10),userId integer,vipuserId integer");
		//åå»ºåºé¨ææ¬è¡?
		db.execSQL("CREATE TABLE bottomText (BottomText_id integer primary key autoincrement,appId integer,id integer,text varchar(256),userId integer");
		
		db.execSQL("CREATE TABLE bottomText (BottomText_id integer primary key autoincrement,appId integer,id integer,text varchar(256),userId integer");
	}

	/**
	 * æ°æ®åºçæ¬å·åçååæ¯è°ç?
	 */
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
