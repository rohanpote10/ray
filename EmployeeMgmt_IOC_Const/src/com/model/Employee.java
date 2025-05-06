package com.model;

public class Employee {
	
	int empID;
	String name;
	double salary;
	public String getName() {
		return name;
	}
	
	public Employee(int empID, String name, double salary) {
		super();
		this.empID = empID;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "\nEmployeeID: " + empID + "     Name: " + name + "     Salary: " + salary;
	}

}
