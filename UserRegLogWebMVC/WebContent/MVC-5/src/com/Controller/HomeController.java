package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Model.User;
import com.ServiceLayer.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService us;

	@RequestMapping(value = "/reg")
	public String AddUsers(@ModelAttribute User user) {

		System.out.println(user);

		int result = us.addUserInService(user);

		if (result == 1) {
			return "error";
		} else {
			return "Login";
		}

	}

	@RequestMapping(value = "/log")
	public String loginUser(@RequestParam("un") String uname, @RequestParam("ps") String password, Model model) {

		System.out.println("I am in Controller : Log()");

		List<User> ulist = us.loginUserInService(uname, password);

		if (ulist != null) {
			model.addAttribute("msg", ulist);
			return "Success";
		} else {

			model.addAttribute("msg", "Invalid Credentials");
			return "Login";
		}

	}

}
