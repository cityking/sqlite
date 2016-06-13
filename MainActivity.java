package com.example.createdb;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends Activity {

	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//3.获取自己创建的继承自SQLiteOpenHelper的对象
		MySqliteOpenHelper sqliteOpenHelper = new MySqliteOpenHelper(getApplicationContext(), "hh.db", null, 1);
		//获取数据库 第一次调用时创建数据库
		SQLiteDatabase mydb = sqliteOpenHelper.getWritableDatabase();
	}


}
