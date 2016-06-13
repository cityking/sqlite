package com.example.createdb;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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
		ContentValues values = new ContentValues();
		values.put("name", "chenhai");
		values.put("phone", "13166185977");
		long insert = mydb.insert("info", null, values );
		if(insert>0){
		Toast.makeText(getApplicationContext(), "添加成功", 0).show();
		}else{
			Toast.makeText(getApplicationContext(), "添加失败", 0).show();
		}
//		mydb.execSQL("INSERT INTO info (name,phone) VALUES (?,?)", new Object[] { "cityking", "18221339272" });
		mydb.close();
	}

	public void delete(View v) {
		SQLiteDatabase mydb = sqliteOpenHelper.getWritableDatabase();
		int delete = mydb.delete("info", "name=?", new String[]{"chenhai"});
//		mydb.execSQL("DELETE FROM info WHERE name =?", new Object[] { "cityking" });
		Toast.makeText(getApplicationContext(), "删除了"+delete+"行", 0).show();
		mydb.close();
	}

	public void update(View v) {
		SQLiteDatabase mydb = sqliteOpenHelper.getWritableDatabase();
//		mydb.execSQL("UPDATE info SET name=? WHERE name =?", new Object[] { "王城", "cityking" });
		ContentValues values = new ContentValues();
		values.put("phone", "13882547894");
		int update = mydb.update("info", values, "name=?", new String[]{"chenhai"});
		Toast.makeText(getApplicationContext(), "更新了"+update+"行", 0).show();
		mydb.close();
	}

	public void find(View v) {
		SQLiteDatabase mydb = sqliteOpenHelper.getReadableDatabase();
//		Cursor cursor = mydb.rawQuery("select name,phone from info", null);
		Cursor cursor = mydb.query("info", new String[]{"name","phone"}, null, null, null, null, null);
		if (cursor != null && cursor.getCount() > 0) {
			while (cursor.moveToNext()) {
				String name = cursor.getString(0);
				String phone = cursor.getString(1);
				System.out.println("name=" + name + ",phone=" + phone);
			}
		}
	}

}
