package com.easyeducation.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.easyeducation.application.EasyEducationApplication;

public final class DBHelper extends SQLiteOpenHelper {
	private static DBHelper helper = null;
	private static final String DATABASE_NAME = "course.db";
	public static final String INTEGER_TYPE = " integer";
	private static final String TEXT_TYPE = " TEXT";
	public static final String ID = "id";
	public static final String TIME = "time";

	public static final String SYLLABUS_TABLE = "SyllabusTable";
	public static final String SYLLABUS_COURSE_ID = "courseId";
	public static final String SYLLABUS_COURSE_NAME = "courseName";
	public static final String SYLLABUS_TEACHER_NAME = "teacherName";
	public static final String SYLLABUS_TAG = "Tag";
	public static final String SYLLABUS_ISADDING = "isAdding";

	private DBHelper() {
		super(EasyEducationApplication.getInstance().getApplicationContext(),
				DATABASE_NAME, null, 1);
	}

	public static DBHelper getInstance() {
		if (helper == null) {
			helper = new DBHelper();
		}
		return helper;
	}

	/**
	 * 关闭数据库
	 */
	public void closeDatabase(SQLiteDatabase db) {
		if (db != null && db.isOpen()) {
			db.close();
		}
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.beginTransaction();
		try {
			createAllTables(db);
			db.setTransactionSuccessful();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.endTransaction();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

	private void createAllTables(SQLiteDatabase db) {
		createSyllabus(db);
	}

	/**
	 * 创建询盘快捷模板工具
	 * 
	 * @param db
	 */
	private void createSyllabus(SQLiteDatabase db) {
		String[] cloumns = new String[] { SYLLABUS_COURSE_ID + INTEGER_TYPE,
				SYLLABUS_COURSE_NAME + TEXT_TYPE,
				SYLLABUS_TEACHER_NAME + TEXT_TYPE, SYLLABUS_TAG + TEXT_TYPE,
				SYLLABUS_ISADDING + TEXT_TYPE };
		createTable(db, SYLLABUS_TABLE, cloumns);
	}

	/**
	 * @param sqliteDatabase
	 * @param table
	 *            要创建的数据表名
	 * @param columns
	 *            列名
	 */
	private void createTable(SQLiteDatabase sqliteDatabase, String table,
			String[] columns) {
		String createTable = "create table if not exists ";
		String primaryKey = " Integer primary key autoincrement";
		String text = " text";
		char leftBracket = '(';
		char rightBracket = ')';
		char comma = ',';
		int stringBufferSize = 170;
		StringBuffer sql = new StringBuffer(stringBufferSize);
		sql.append(createTable).append(table).append(leftBracket).append(ID)
				.append(primaryKey).append(comma);
		for (String column : columns) {
			sql.append(column);
			sql.append(comma);
		}
		sql.append(TIME).append(text).append(rightBracket);
		try {
			sqliteDatabase.execSQL(sql.toString());
		} catch (Exception e) {
			e.getMessage();
		}

	}

	/**
	 * drop表
	 * 
	 * @param table
	 *            需要drop的表名
	 */
	public synchronized void dropTable(final SQLiteDatabase db,
			final String table) {
		SQLiteDatabase database = null;
		try {
			database = db == null ? getWritableDatabase() : db;
			database.execSQL("drop table if exists " + table);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 插入数据
	 * 
	 * @param table
	 * @param nullColumnHack
	 * @param values
	 * @return
	 */
	public synchronized long insert(final String table,
			final String nullColumnHack, final ContentValues values) {
		SQLiteDatabase database = null;
		try {
			database = getWritableDatabase();
			return database.insert(table, nullColumnHack, values);
		} catch (Exception e) {
			return -1;
		} finally {
			closeDatabase(database);
		}
	}

	/**
	 * 删除数据
	 * 
	 * @param table
	 * @param whereClause
	 * @param whereArgs
	 * @return
	 */
	public int delete(final String table, final String whereClause,
			final String[] whereArgs) {
		SQLiteDatabase database = null;
		try {
			database = getWritableDatabase();
			return database.delete(table, whereClause, whereArgs);

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			closeDatabase(database);
		}
	}

	/**
	 * 更新数据
	 * 
	 * @param table
	 * @param values
	 * @param whereClause
	 * @param whereArgs
	 * @return
	 */
	public int update(final String table, final ContentValues values,
			final String whereClause, final String[] whereArgs) {
		SQLiteDatabase database = null;
		try {
			database = getWritableDatabase();
			return database.update(table, values, whereClause, whereArgs);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			closeDatabase(database);
		}
	}
}
