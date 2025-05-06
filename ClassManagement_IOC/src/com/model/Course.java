package com.model;

public class Course {
	
	private int courseID;
	private String courseName;
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	@Override
	public String toString() {
		return "\nCourseID=" + courseID + ", courseName: " + courseName;
	}
	
	

}
