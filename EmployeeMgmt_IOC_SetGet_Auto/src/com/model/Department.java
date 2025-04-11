package com.model;

import java.util.List;
import java.util.Map;

public class Department {

    private int deptID;
    private String deptName;
    private Map<String, String> dnameAndLocation;
    private List<Employee> listOfEmployees;

    public Department(int deptID, String deptName, Map<String, String> dnameAndLocation, List<Employee> listOfEmployees) {
        this.deptID = deptID;
        this.deptName = deptName;
        this.dnameAndLocation = dnameAndLocation;
        this.listOfEmployees = listOfEmployees;
    }

    public int getDeptID() {
        return deptID;
    }

    public String getDeptName() {
        return deptName;
    }

    public Map<String, String> getDnameAndLocation() {
        return dnameAndLocation;
    }

    public List<Employee> getListOfEmployees() {
        return listOfEmployees;
    }

    @Override
    public String toString() {
        return "\nDepartmentID: " + deptID + " Name=" + deptName +
               " Deptname&Location=" + dnameAndLocation +
               "\nListOfEmployees=" + listOfEmployees;
    }
}
