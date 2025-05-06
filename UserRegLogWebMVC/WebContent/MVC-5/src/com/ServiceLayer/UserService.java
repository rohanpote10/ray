package com.ServiceLayer;

import java.util.List;

import com.Model.User;

public interface UserService {

	public int addUserInService(User user);

	public List<User> loginUserInService(String uname, String password);
	
}
