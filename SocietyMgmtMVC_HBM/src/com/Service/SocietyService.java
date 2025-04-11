package com.Service;

import java.util.List;

import org.springframework.ui.Model;

import com.Model.SocietyManager;

public interface SocietyService {
	
	public String addMember(SocietyManager manager,Model model);
	public String loginToProfile(String username,String password,Model model);

}
