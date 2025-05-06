package com.model;

public class Student {
	
	private int studentID;
	private String studentName;
	private Batch batch;
	
	
	public Student(int studentID, String studentName, Batch batch) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
		this.batch = batch;
	}

	@Override
	public String toString() {
		return "StudentID: " + studentID + ", studentName: " + studentName + batch;
	}
	
}
