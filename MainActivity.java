package com.example.createdb;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends Activity {

	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//3.��ȡ�Լ������ļ̳���SQLiteOpenHelper�Ķ���
		MySqliteOpenHelper sqliteOpenHelper = new MySqliteOpenHelper(getApplicationContext(), "hh.db", null, 1);
		//��ȡ���ݿ� ��һ�ε���ʱ�������ݿ�
		SQLiteDatabase mydb = sqliteOpenHelper.getWritableDatabase();
	}


}
