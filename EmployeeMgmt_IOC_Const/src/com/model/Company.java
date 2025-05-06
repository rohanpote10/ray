package com.model;

import java.util.ArrayList;
import java.util.List;

public class Company {
	int companyID;
	String companyName;
	List<Department> listOfDepartments = new ArrayList<Department>();

	public Company(int companyID, String companyName, List<Department> listOfDepartments) {
		super();
		this.companyID = companyID;
		this.companyName = companyName;
		this.listOfDepartments = listOfDepartments;
	}

	@Override
	public String toString() {
		return "CompanyID=" + companyID + "     Name=" + companyName + "\nListOfDepartments=" + listOfDepartments;
	}

}
