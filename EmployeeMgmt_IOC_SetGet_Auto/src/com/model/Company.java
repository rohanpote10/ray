package com.model;

import java.util.List;

public class Company {
    
    private int companyID;
    private String companyName;
    private List<Department> listOfDepartments;

    public Company(int companyID, String companyName, List<Department> listOfDepartments) {
        this.companyID = companyID;
        this.companyName = companyName;
        this.listOfDepartments = listOfDepartments;
    }

    public int getCompanyID() {
        return companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public List<Department> getListOfDepartments() {
        return listOfDepartments;
    }

    @Override
    public String toString() {
        return "CompanyID=" + companyID + " Name=" + companyName +
               "\nListOfDepartments=" + listOfDepartments;
    }
}
