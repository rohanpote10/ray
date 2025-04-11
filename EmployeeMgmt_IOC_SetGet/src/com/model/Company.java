package com.model;

import java.util.ArrayList;
import java.util.List;

public class Company {
	int companyID;
	String companyName;
	List<Department> listOfDepartments=new ArrayList<Department>();
	public int getCompanyID() {
		return companyID;
	}
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public List<Department> getListOfDepartments() {
		return listOfDepartments;
	}
	public void setListOfDepartments(List<Department> listOfDepartments) {
		this.listOfDepartments = listOfDepartments;
	}
	@Override
	public String toString() {
		return "CompanyID=" + companyID + "     Name=" + companyName + "\nListOfDepartments="
				+ listOfDepartments;
	}

}
