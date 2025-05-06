package com.model;

public class Faculty {
	
	private int facultyID;
	private String facultyName;
	private Course course;
	
	public int getFacultyID() {
		return facultyID;
	}
	public void setFacultyID(int facultyID) {
		this.facultyID = facultyID;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "\nFacultyID: " + facultyID + ", facultyName: " + facultyName+ course;
	}

}
