package com.example.createdb;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	MySqliteOpenHelper sqliteOpenHelper;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 3.获取自己创建的继承自SQLiteOpenHelper的对象
		sqliteOpenHelper = new MySqliteOpenHelper(getApplicationContext(), "hh.db", null, 1);

	}

	public void add(View v) {
		// 获取数据库 第一次调用时创建数据库
		SQLiteDatabase mydb = sqliteOpenHelper.getWritableDatabase();
		mydb.execSQL("INSERT INTO info (name,phone) VALUES (?,?)", new Object[] { "cityking", "18221339272" });
	}

	public void delete(View v) {
		SQLiteDatabase mydb = sqliteOpenHelper.getWritableDatabase();
		mydb.execSQL("DELETE FROM info WHERE name =?", new Object[] { "cityking" });
	}

	public void update(View v) {
		SQLiteDatabase mydb = sqliteOpenHelper.getWritableDatabase();
		mydb.execSQL("UPDATE info SET name=? WHERE name =?", new Object[] { "王城", "cityking" });
	}

	public void find(View v) {
		SQLiteDatabase mydb = sqliteOpenHelper.getReadableDatabase();
		Cursor cursor = mydb.rawQuery("select * from info", null);
		if (cursor != null && cursor.getCount() > 0) {
			while (cursor.moveToNext()) {
				String name = cursor.getString(1);
				String phone = cursor.getString(2);
				System.out.println("name=" + name + ",phone=" + phone);
			}
		}
	}

}
