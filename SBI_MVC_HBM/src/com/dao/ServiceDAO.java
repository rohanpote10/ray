package com.dao;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.model.Accounts;

public interface ServiceDAO {

	public String addUsersToDB(Accounts account,Model model);

	public String loginToDB(String unameUI, String passUI, Model model,HttpSession session);

	public String depositMoneyToDB(Accounts account,String depositAmt, Model model);
	
	public String withdrawMoneyFromDB(Accounts account,String depositAmt,Model model);

	public String editDetailsInDB(Accounts account, String fname, String dateOfBirth, String emailID, String contact,
			Model model);

	public String uploadDocsToDB(Accounts account, MultipartFile pancard, MultipartFile aadhar, Model model);

	public String forgotPasswordExistingUser(Accounts account, String newPassword, String username, String oldPassword,
			Model model);

	public String forgotPasswordNonExisting(String newPassword, String username, String oldPassword, Model model);

	public String addAdminToDB(Accounts account, Model model);

	public String getAllUsersFromDB(Model model);
}
