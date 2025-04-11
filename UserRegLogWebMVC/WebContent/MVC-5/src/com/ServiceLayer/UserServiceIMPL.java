package com.ServiceLayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DAOLayer.Userdao;
import com.Model.User;

@Service
public class UserServiceIMPL implements UserService {

	@Autowired
	private Userdao ud;

	private static final String un = "admin";

	private static final String ps = "admin123";

	@Override
	public int addUserInService(User user) {

		System.out.println("I am in Service Layer");
		System.out.println(user);
		System.out.println("------------------------");

		if (user != null) {
			ud.addUserInDao(user);
			return 0;
		} else {
			return 1;
		}

	}

	@Override
	public List<User> loginUserInService(String uname, String password) {

		System.out.println("I am in Service :: Log()");
		if (uname.equals(un) && password.equals(ps)) {

			List<User> ulist = ud.loginUserInDao();

			return ulist;

		} else {
			return null;
		}

	}

}
