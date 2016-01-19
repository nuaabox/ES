package com.easyeducation.bean.classgrade;

import com.easyeducation.bean.BaseBean;

public class Classgrade extends BaseBean {

	public Classgrade(String classGradeId, String data, String dataTag,
			Chinese chinese, Math math, English english, Physics physics,
			Chemistry chemistry, Biology biology, Geography geography,
			History history, Politics politics, Total total) {
		super();
		this.classGradeId = classGradeId;
		this.data = data;
		this.dataTag = dataTag;
		this.chinese = chinese;
		this.math = math;
		this.english = english;
		this.physics = physics;
		this.chemistry = chemistry;
		this.biology = biology;
		this.geography = geography;
		this.history = history;
		this.politics = politics;
		this.total = total;
	}

	public String classGradeId;
	public String data;
	public String dataTag;
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

	public Total total;

}
