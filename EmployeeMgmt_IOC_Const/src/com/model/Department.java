package com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Department {

	int deptID;
	String deptName;
	Map<String, String> dnameAndLocation;
	List<Employee> listOfEmployees = new ArrayList<Employee>();

	
	public Department(int deptID, String deptName, Map<String, String> dnameAndLocation,
			List<Employee> listOfEmployees) {
		super();
		this.deptID = deptID;
		this.deptName = deptName;
		this.dnameAndLocation = dnameAndLocation;
		this.listOfEmployees = listOfEmployees;
	}


	@Override
	public String toString() {
		return "\nDepartmentID: " + deptID + "     Name=" + deptName + "     Deptname&Location=" + dnameAndLocation
				+ "\nListOfEmployees=: " + listOfEmployees;
	}

}
