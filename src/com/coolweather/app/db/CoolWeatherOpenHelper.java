/**
 * 
 */
package com.coolweather.app.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

/**
 * @author MjieQiu
 *
 */
public class CoolWeatherOpenHelper extends SQLiteOpenHelper {

	/**
	 * Province 表建表语句
	 */
	public static final String CREATE_PROVINCE = "create table Province ( id integer primary key autoincrement, " +
			"province_name text," +
			" province_code text)";
	/**
	 * City 建表语句
	 */
	public static final String CREATE_CITY = "create table City ( id integer primary key autoincrement, city_name text," +
			"city_code text, province_id integer)";
	
	/**
	 * County建表语句
	 */
	public static final String CREATE_COUNTY = "create table county (id integer primary key autoincrement, county_name text," +
			" county_code text, city_id integer)";
	/**
	 * @param context
	 * @param name
	 * @param factory
	 * @param version
	 */
	public CoolWeatherOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
	}


	/* (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
	 */
	@Override
	public void onCreate(SQLiteDatabase arg0) {
		arg0.execSQL(CREATE_PROVINCE);
		arg0.execSQL(CREATE_CITY);
		arg0.execSQL(CREATE_COUNTY);
	}

	/* (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase, int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
