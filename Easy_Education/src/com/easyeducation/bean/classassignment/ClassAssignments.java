package com.easyeducation.bean.classassignment;

import java.util.ArrayList;

import com.easyeducation.bean.BaseBean;

public class ClassAssignments extends BaseBean {

	public ArrayList<ClassAssignment> classAssignment;

	public static ArrayList<ClassAssignment> classAssignments() {
		Chinese chinese = new Chinese("1", "语文", "false");
		Math math = new Math("2", "数学", "false");
		English english = new English("3", "英语", "false");
		Physics physics = new Physics("4", "物理", "true");
		Chemistry chemistry = new Chemistry("5", "化学", "false");
		Biology biology = new Biology("6", "化学", "false");
		Geography geography = new Geography("7", "地理", "false");
		History history = new History("8", "历史", "false");
		Politics politics = new Politics("9", "政治", "false");

		ArrayList<ClassAssignment> assignments = new ArrayList<ClassAssignment>();
		ClassAssignment assignment = new ClassAssignment("11111", "2015-11-11",
				"今天", "true", chinese, math, english, physics, chemistry,
				biology, geography, history, politics);
		assignments.add(assignment);
		chinese = new Chinese("1", "语文", "false");
		math = new Math("2", "数学", "false");
		english = new English("3", "英语", "false");
		physics = new Physics("4", "物理", "true");
		chemistry = new Chemistry("5", "化学", "false");
		biology = new Biology("6", "化学", "false");
		geography = new Geography("7", "地理", "false");
		history = new History("8", "历史", "false");
		politics = new Politics("9", "政治", "false");
		assignment = new ClassAssignment("11111", "2015-10-12", "昨天", "false",
				chinese, math, english, physics, chemistry, biology, geography,
				history, politics);
		assignments.add(assignment);
		return assignments;

	};

}
