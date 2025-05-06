package com.DAOLayer;

import java.util.List;

import com.Model.User;

public interface Userdao {

	public void addUserInDao(User user);

	public List<User>  loginUserInDao();
	
}
