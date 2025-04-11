package com.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.dao.ServiceDAO;
import com.model.Accounts;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private ServiceDAO sd;

	@Override
	public String addUser(Accounts account, Model model) {

		String resultPage = "";
		if (account != null) {
			resultPage = sd.addUsersToDB(account, model);
			if (resultPage.equals("Register")) {
				model.addAttribute("success", "Account registered successfully !! Please Login");
				return "Register";
			} else {
				model.addAttribute("loginMessage", "Account already exists !!! Please Login");
				return "Login";
			}

		} else {
			System.out.println("Account Invalid !!");
			model.addAttribute("message", "Invalid Account Details !! Re-register");
			return "Register";
		}
	}

	@Override
	public String userLogin(String unameUI, String passUI, Model model, HttpSession httpSession) {

		String result = sd.loginToDB(unameUI, passUI, model, httpSession);
		if (result.equals("Dashboard")) {
			return "Dashboard";
		} else {
			return "Login";
		}
	}

	@Override
	public String despositMoney(Accounts account, String depositAmt, Model model) {
		return sd.depositMoneyToDB(account, depositAmt, model);
	}

	@Override
	public String withdrawMoney(Accounts account, String withdrawAmt, Model model) {
		return sd.withdrawMoneyFromDB(account, withdrawAmt, model);
	}

	@Override
	public String editDetails(Accounts account, String fname, String dateOfBirth, String emailID, String contact,
			Model model) {
		return sd.editDetailsInDB(account, fname, dateOfBirth, emailID, contact, model);

	}

	@Override
	public String uploadDocs(Accounts account, MultipartFile pancard, MultipartFile aadhar, Model model) {

		return sd.uploadDocsToDB(account,pancard,aadhar,model);
	}

}
