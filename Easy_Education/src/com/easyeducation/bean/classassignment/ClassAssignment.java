package com.easyeducation.bean.classassignment;

public class ClassAssignment {

	public ClassAssignment(String classAssignmentId, String data,
			String dataTag, String isAllowModification, Chinese chinese,
			Math math, English english, Physics physics, Chemistry chemistry,
			Biology biology, Geography geography, History history,
			Politics politics) {
		super();
		this.classAssignmentId = classAssignmentId;
		this.data = data;
		this.dataTag = dataTag;
		this.isAllowModification = isAllowModification;
		this.chinese = chinese;
		this.math = math;
		this.english = english;
		this.physics = physics;
		this.chemistry = chemistry;
		this.biology = biology;
		this.geography = geography;
		this.history = history;
		this.politics = politics;
	}

	public String classAssignmentId;
	public String data;
	public String dataTag;
	public String isAllowModification;
	public Chinese chinese;
	public Math math;
	public English english;
	// 物理
	public Physics physics;
	// 化学
	public Chemistry chemistry;
	// 生物
	public Biology biology;
	// 地理
	public Geography geography;
	// 历史
	public History history;
	// 政治
	public Politics politics;

}
