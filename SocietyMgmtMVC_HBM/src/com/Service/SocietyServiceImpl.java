package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.DAO.SocietyDAO;
import com.Model.SocietyManager;

@Service
public class SocietyServiceImpl implements SocietyService {

	@Autowired
	private SocietyDAO sd;
	public static final String uname = "admin@64";
	public static final String upass = "admin123";

	@Override
	public String addMember(SocietyManager manager, Model model) {

		System.out.println("SocietyServiceImpl : addMember()");
		String result = sd.addMemberToDB(manager, model);
		if ("Register".equals(result)) {
			return "Register";
		} else
			return "Login";
	}

	@Override
	public String loginToProfile(String username, String password, Model model) {
		List<SocietyManager> managerList = null;
		if (username.equals(uname) && password.equals(upass)) {
			managerList = sd.getAllMembers();
		}
		if (managerList.isEmpty()) {
			model.addAttribute("errorMessage", "No members added, add members first !!");
			return "Register";
		} else {
			model.addAttribute("resultList", managerList);
			return "Dashboard";
		}

	}

}
