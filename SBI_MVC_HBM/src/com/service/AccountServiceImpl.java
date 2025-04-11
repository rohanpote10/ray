package com.service;

import java.util.List;

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

		return sd.loginToDB(unameUI, passUI, model, httpSession);
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

		return sd.uploadDocsToDB(account, pancard, aadhar, model);
	}

	@Override
	public String forgotPasswordExisting(Accounts account, String newPassword, String username, String oldPassword,
			Model model) {

		return sd.forgotPasswordExistingUser(account, newPassword, username, oldPassword, model);
	}

	@Override
	public String forgotPasswordNonExisting(String newPassword, String username, String oldPassword, Model model) {
		sd.forgotPasswordNonExisting(newPassword, username, oldPassword, model);
		return null;
	}

	@Override
	public String addAdmin(Accounts account, Model model) {
		return sd.addAdminToDB(account, model);
	}

	@Override
	public String getAllUsers(Model model) {
		System.out.println("Im here in accSreviceImpl");
		return sd.getAllUsersFromDB(model);
		
	}

	@Override
    public Accounts getAccountById(int id) {
        return sd.getAccountById(id);
    }

    @Override
    public List<Accounts> updateAccount(Accounts account) {
        return sd.updateAccountInDB(account);
    }


}
