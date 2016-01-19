package com.easyeducation.bean.classgrade;

import java.util.ArrayList;

import com.easyeducation.bean.BaseBean;

public class Classgrades extends BaseBean {

	public ArrayList<Classgrade> classGrade;

	public static ArrayList<Classgrade> classGrades() {

		Chinese chinese = new Chinese("112.1", "124", "98");
		Math math = new Math("120.7", "135", "106");
		English english = new English("131.9", "140", "123");
		Physics physics = new Physics("89.6", "101", "76");
		Chemistry chemistry = new Chemistry("88.2", "96", "74");
		Biology biology = new Biology("80.0", "84", "76");
		Geography geography = new Geography("131.9", "140", "123");
		History history = new History("88.2", "96", "74");
		Politics politics = new Politics("80.0", "84", "76");
		Total total = new Total("631.5", "683", "553");

		ArrayList<Classgrade> classGrades = new ArrayList<Classgrade>();
		Classgrade classgrade = new Classgrade("123456", "2015/9/9", "本次成绩",
				chinese, math, english, physics, chemistry, biology, geography,
				history, politics, total);
		classGrades.add(classgrade);
		classgrade = new Classgrade("654321", "2015/7/12", "上次成绩", chinese,
				math, english, physics, chemistry, biology, geography, history,
				politics, total);
		classGrades.add(classgrade);
		return classGrades;

	};

}
