package com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Department {

	int deptID;
	String deptName;
	Map<String,String> dnameAndLocation;
			List<Employee>listOfEmployees=new ArrayList<Employee>();
			public int getDeptID() {
				return deptID;
			}
			public void setDeptID(int deptID) {
				this.deptID = deptID;
			}
			public String getDeptName() {
				return deptName;
			}
			public void setDeptName(String deptName) {
				this.deptName = deptName;
			}
			public Map<String, String> getDnameAndLocation() {
				return dnameAndLocation;
			}
			public void setDnameAndLocation(Map<String, String> dnameAndLocation) {
				this.dnameAndLocation = dnameAndLocation;
			}
			public List<Employee> getListOfEmployees() {
				return listOfEmployees;
			}
			public void setListOfEmployees(List<Employee> listOfEmployees) {
				this.listOfEmployees = listOfEmployees;
			}
			@Override
			public String toString() {
				return "\nDepartmentID: " + deptID + "     Name=" + deptName + "     Deptname&Location="
						+ dnameAndLocation + "\nListOfEmployees=: " + listOfEmployees;
			}
			
			
}
