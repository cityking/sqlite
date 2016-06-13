package com.example.createdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

//1.����MySqliteOpenHelper�̳���SQLiteOpenHelper
public class MySqliteOpenHelper extends SQLiteOpenHelper {
	//2.��ӹ��췽��
	public MySqliteOpenHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	//���ݿ��һ�δ���ʱִ��
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table info(_id integer primary key autoincrement,name varchar(20))");

	}
	//���ݿ���°汾ʱִ��
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	

	}

}
