package com.service;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.model.Accounts;

public interface AccountService {

	
	public String addUser(Accounts account,Model model); 

	public String userLogin(String unameUI, String passUI,Model model,HttpSession httpSession);

	public String despositMoney(Accounts account,String depositAmt, Model model);

	public String withdrawMoney(Accounts account, String withdrawAmt, Model model);

	public String editDetails(Accounts account, String fname, String dateOfBirth, String emailID, String contact,Model model);

	public String uploadDocs(Accounts account, MultipartFile pancard, MultipartFile aadhar, Model model);

	public String forgotPasswordExisting(Accounts account, String newPassword, String username, String oldPassword,
			Model model);
}
