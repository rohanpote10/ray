package com.model;

public class Batch {
	
	private int batchID;
	private String batchName;
	
	private Faculty faculty;
	
	public void setBatchID(int batchID) {
		this.batchID=batchID;
	}
	public int getBatchID() {
		return batchID;
	}
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	@Override
	public String toString() {
		return "\nBatchID: " + batchID + ", batchName: " + batchName + faculty;
	}
}
