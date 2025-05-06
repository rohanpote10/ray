package com.DAOLayer;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Model.User;

@Repository
public class UserdaoIMPL implements Userdao {

	@Autowired
	private SessionFactory sf;

	@Override
	public void addUserInDao(User user) {

		System.out.println("I am in Dao Layer");
		System.out.println(user);
		System.out.println("------------------------");

		Session s = sf.openSession();
		s.save(user);
		s.beginTransaction().commit();
		System.out.println("User added");

	}

	@Override
	public List<User>  loginUserInDao() {
		
		System.out.println(" Iam in DAO layer :: Log()");
		
		Session s = sf.openSession();
		Query query = s.createQuery("from User");
		List<User> ulist = query.getResultList();
		
		return ulist;
		
		
		
	}

}
