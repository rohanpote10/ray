package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Model.SocietyManager;
import com.Service.SocietyService;

@Controller
public class HomeController {

	@Autowired
	private SocietyService service;

	@RequestMapping(value = "/login")
	public String adminLogin(@RequestParam("username") String username, @RequestParam("password") String password,Model model) {
		String result=service.loginToProfile(username, password,model);
		if(result.equals("Dashboard")) 
			return "Dashboard";
		else
			return "Register";
	}

	@RequestMapping(value = "/register")
	public String addMembers(@ModelAttribute SocietyManager manager, Model model) {
		System.out.println("HomeController: addMember()");

		String result = service.addMember(manager, model);
		if (result.equals("Register")) {
			return "Register";
		} else
			return "Login";
	}

}
