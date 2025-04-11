package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@RequestMapping(value = "/register")
	public void getRegistrationCall(@RequestParam("fname") String firstName, @RequestParam("lname") String lastName,
			@RequestParam("addr") String address, @RequestParam("cno") long contactNo,
			@RequestParam("gender") String gender, @RequestParam("emailID") String emailId,
			@RequestParam("pincode") int pincode, @RequestParam("aadharNo") long aadharNo,
			@RequestParam("pNo") String pancarNo, @RequestParam("savingsAcc") String savingAccount,
			@RequestParam("minBal") double minBalance) {

		System.out.println("FirstName: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Address: " + address);
		System.out.println("ContactNo: " + contactNo);
		System.out.println("Gender: " + gender);
		System.out.println("EmailID: " + emailId);
		System.out.println("Pincode: " + pincode);
		System.out.println("AadharCardNo: " + aadharNo);
		System.out.println("PancardNo: " + pancarNo);
		System.out.println("SavingsAccount: " + savingAccount);
		System.out.println("Minimum Balance: " + minBalance);
	}

	@RequestMapping(value = "/homeLoan")
	public void getHomeLoanCall(@RequestParam("employer") String employerName,
			@RequestParam("position") String position, @RequestParam("contact") String contactNo,
			@RequestParam("addr") String address, @RequestParam("aadhar") String aadharNo,
			@RequestParam("propAddr") String propertyAddr, @RequestParam("buyPrice") String buyingPrice,
			@RequestParam("typeOfLoan") String typeOfLoan, @RequestParam("downPrice") String downpaymentPrice) {

		System.out.println("Employer Name: " + employerName);
		System.out.println("Designation: " + position);
		System.out.println("ContactNo: " + contactNo);
		System.out.println("Addres: " + address);
		System.out.println("AadharCardNo: " + aadharNo);
		System.out.println("Property Address: " + propertyAddr);
		System.out.println("Property Cost: " + buyingPrice);
		System.out.println("Type of Loan: " + typeOfLoan);
		System.out.println("Down-payment price: " + downpaymentPrice);
	}

	@RequestMapping(value = "/carLoan")
	public void getCarLoanCall(@RequestParam("employer") String employerName, @RequestParam("position") String position, 
			@RequestParam("contact") String contactNo, @RequestParam("addr") String address,
			@RequestParam("pancard") String pancard, @RequestParam("model") String modelNo,
			@RequestParam("mileage") double mileage, @RequestParam("price") double price,
			@RequestParam("typeOfLoan") String typeOfLoan, @RequestParam("downPay") String downpaymentPrice) {

		System.out.println("Employer Name: " + employerName);
		System.out.println("Designation: " + position);
		System.out.println("ContactNo: " + contactNo);
		System.out.println("Addres: " + address);
		System.out.println("PancardNo: " + pancard);
		System.out.println("Model No: " + modelNo);
		System.out.println("Mileage: " + mileage);
		System.out.println("Price: " + price);
		System.out.println("Type of Loan: " + typeOfLoan);
		System.out.println("Down-payment price: " + downpaymentPrice);
	}

	@RequestMapping(value = "/personalLoan")
	public void getPersonalLoanCall(@RequestParam("fname") String fullName, @RequestParam("addr") String addr,
			@RequestParam("cno") String contactNo, @RequestParam("emailID") String emailID,
			@RequestParam("purpose") String purpose, @RequestParam("typeOfLoan") String typeOfLoan) {

		System.out.println("Full name: " + fullName);
		System.out.println("Address: " + addr);
		System.out.println("Contact No: " + contactNo);
		System.out.println("Email ID: " + emailID);
		System.out.println("Purpose: " + purpose);
		System.out.println("Type of Loan: " + typeOfLoan);
	}

}
