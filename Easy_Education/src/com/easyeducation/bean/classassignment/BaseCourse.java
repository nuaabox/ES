package com.easyeducation.bean.classassignment;

public class BaseCourse {

	public String courseTag;
	/**
	 * 作业内容
	 */
	public String assignmentContent;
	public String isComplete;

	public BaseCourse(String courseTag, String assignmentContent,
			String isComplete) {
		super();
		this.courseTag = courseTag;
		this.assignmentContent = assignmentContent;
		this.isComplete = isComplete;
	}

}
