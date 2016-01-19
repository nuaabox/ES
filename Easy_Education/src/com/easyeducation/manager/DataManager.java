package com.easyeducation.manager;

import java.util.ArrayList;

import android.util.Log;

import com.easyeducation.bean.Module;
import com.easyeducation.bean.mysyllabus.BaseSyllabus;
import com.easyeducation.db.DBDataHelper;
import com.easyeducation.db.DBHelper;

public class DataManager {
	private static DataManager dbManager;

	public static DataManager getInstance() {
		if (dbManager == null) {
			synchronized (DataManager.class) {
				if (dbManager == null) {
					dbManager = new DataManager();
				}
			}
		}
		return dbManager;
	}

	/**
	 * 插入新数据
	 * 
	 * @param Table
	 *            表名
	 * @param mailShortCut
	 *            对象
	 * @return 返回-1：插入失败
	 */
	public long insertInToSyllabusTable(BaseSyllabus baseSyllabus) {
		return DBDataHelper.getInstance().insert(DBHelper.SYLLABUS_TABLE,
				baseSyllabus);
	}

	public ArrayList<BaseSyllabus> selectSyllabusTable(String[] selectionArgs) {
		ArrayList<Module> modules = DBDataHelper.getInstance().select(
				DBHelper.SYLLABUS_TABLE, DBHelper.SYLLABUS_TAG + " = ?",
				selectionArgs, DBHelper.SYLLABUS_COURSE_ID + " asc",
				BaseSyllabus.class);
		ArrayList<BaseSyllabus> baseSyllabus = new ArrayList<BaseSyllabus>();
		if (modules != null && modules.size() != 0) {
			for (int i = 0; i < modules.size(); i++) {
				baseSyllabus.add((BaseSyllabus) modules.get(i));
			}
		}
		return baseSyllabus;
	}

	public ArrayList<BaseSyllabus> selectAllSyllabusTable() {
		ArrayList<Module> modules = DBDataHelper.getInstance().select(
				DBHelper.SYLLABUS_TABLE, null, null, null, BaseSyllabus.class);
		ArrayList<BaseSyllabus> baseSyllabus = new ArrayList<BaseSyllabus>();
		if (modules != null && modules.size() != 0) {
			for (int i = 0; i < modules.size(); i++) {
				baseSyllabus.add((BaseSyllabus) modules.get(i));
			}
		}
		return baseSyllabus;
	}

	/**
	 * 
	 * @param key
	 * @param value
	 * @param courseName
	 * @param teacherName
	 */
	public void updateSyllabus(String courseIdValue, String courseName,
			String teacherName) {
		ArrayList<Module> modules = DBDataHelper.getInstance().select(
				DBHelper.SYLLABUS_TABLE, null, DBHelper.SYLLABUS_COURSE_ID,
				"'" + courseIdValue + "'", null, BaseSyllabus.class);
		BaseSyllabus baseSyllabus = null;
		if (null != modules && modules.size() != 0) {
			baseSyllabus = ((BaseSyllabus) modules.get(0));
			baseSyllabus.courseName = courseName;
			baseSyllabus.teacherName = teacherName;
			long index = DBDataHelper.getInstance().update(
					DBHelper.SYLLABUS_TABLE, baseSyllabus);
			Log.i("----", "index" + index);
		}
	}

}
