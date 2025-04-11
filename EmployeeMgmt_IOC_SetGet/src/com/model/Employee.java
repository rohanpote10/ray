package com.model;

public class Employee {
	
	int empID;
	String name;
	double salary;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	@Override
	public String toString() {
		return "\nEmployeeID: " + empID + "     Name: " + name + "     Salary: " + salary;
	}

}
