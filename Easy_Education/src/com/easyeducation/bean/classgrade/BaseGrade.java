package com.easyeducation.bean.classgrade;

public class BaseGrade {

	public String averageScore;
	public String topScore;
	public String lowestScore;

	public BaseGrade(String averageScore, String topScore, String lowestScore) {
		super();
		this.averageScore = averageScore;
		this.topScore = topScore;
		this.lowestScore = lowestScore;
	}

}
