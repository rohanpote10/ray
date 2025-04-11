package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.User;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

	List<User> userList = new ArrayList<User>();

	@RequestMapping(value = "/login")
	public String userLogin(@RequestParam("uname") String uname, @RequestParam("pass") String pass, Model model) { 
		int counter=0;
		for (User user : userList) {
			if (user.getUname().equals(uname) && (user.getPass().equals(pass)))
				counter++;
		}
		if (counter == 1)
			return "profile";
		else {
			model.addAttribute("msg", "Invalid Credentials !!");
			return "Login";
		}
	}

	@RequestMapping(value = "/register")
	public String addUser(@ModelAttribute User user) {

		if (user != null) {
			userList.add(user);
			System.out.println(user);
			return "Login";
		} else
			return "error";
	}
}
