package com.example.createdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

//1.创建MySqliteOpenHelper继承自SQLiteOpenHelper
public class MySqliteOpenHelper extends SQLiteOpenHelper {
	//2.添加构造方法
	public MySqliteOpenHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	//数据库第一次创建时执行
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table info(_id integer primary key autoincrement,name varchar(20))");

	}
	//数据库更新版本时执行
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	

	}

}
