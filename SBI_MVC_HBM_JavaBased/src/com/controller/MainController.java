package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.model.Accounts;
import com.service.AccountService;

@Controller
public class MainController {

	@Autowired
	private AccountService accService;

	@RequestMapping(value = "/register")
	public String addUser(@ModelAttribute Accounts account, Model model) { 
		String resultPage = accService.addUser(account, model);

		if (resultPage.equals("Register")) {
			model.addAttribute("success", "Account registered successfully !! Please Login");
			return "Register";
		} else {
			model.addAttribute("loginMessage", "Account already exists !!! Please Login");
			return "Login";
		}
	}

	@RequestMapping(value = "/login")
	public String userLogin(@RequestParam("email") String unameUI, @RequestParam("password") String passUI, Model model,
			HttpSession httpSession) {
		String result = accService.userLogin(unameUI, passUI, model, httpSession);
		if (result.equals("Dashboard")) {
			return "Dashboard";
		} else {
			return "Login";
		}
	}

	@RequestMapping(value = "/deposit")
	public String depositMoney(@RequestParam("amount") String depositAmt, Model model, HttpSession httpSession) {
		Accounts account = (Accounts) httpSession.getAttribute("accountObj");
		return accService.despositMoney(account, depositAmt, model);
	}

	@RequestMapping(value = "/withdraw")
	public String withdrawMoney(@RequestParam("amount") String withdrawAmt, Model model, HttpSession httpSession) {
		Accounts account = (Accounts) httpSession.getAttribute("accountObj");
		return accService.withdrawMoney(account, withdrawAmt, model);

	}

	@RequestMapping(value = "/edit")
	public String editDetails(@RequestParam("name") String fname, @RequestParam("dob") String dateOfBirth,
			@RequestParam("email") String emailID, @RequestParam("phone") String contact, HttpSession httpSession,
			Model model) {
		Accounts account = (Accounts) httpSession.getAttribute("accountObj");
		return accService.editDetails(account, fname, dateOfBirth, emailID, contact, model);
	}

	@RequestMapping(value="/uploadDocs")
	public String uploadKYCDocs(@RequestParam("pancard")MultipartFile pancardfile,@RequestParam("aadharcard")MultipartFile aadharfile,HttpSession session,Model model) {
		
		Accounts account=(Accounts)session.getAttribute("accountObj");
		return accService.uploadDocs(account,pancardfile,aadharfile,model);
		
	}

	
	
}
