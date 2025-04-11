package com.DAO;

import java.util.List;

import org.springframework.ui.Model;

import com.Model.SocietyManager;

public interface SocietyDAO {
	
	public String addMemberToDB(SocietyManager manager,Model model);
	public List<SocietyManager> getAllMembers();
}
