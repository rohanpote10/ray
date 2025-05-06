package com.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.Model.SocietyManager;

@Repository
public class SocietyDAOImpl implements SocietyDAO {

	@Autowired
	private SessionFactory sf;

	@Override
	public String addMemberToDB(SocietyManager manager, Model model) {
		System.out.println("SocietyDAOImpl : addMemberToDB");
		Session session = sf.openSession();
		int counter = 0;
		session.beginTransaction();

		try {

			String hql = "SELECT COUNT(*) FROM SocietyManager WHERE username = :username";
			Query<Long> query = session.createQuery(hql, Long.class);
			query.setParameter("username", manager.getUsername());
			Long count = query.uniqueResult();

			if (count > 0) {
				model.addAttribute("message", "Member already exists !!");
				session.getTransaction().rollback();
				session.close();
				return "Register";
			}
			session.save(manager);
			session.getTransaction().commit();
			session.close();
			System.out.println("User Added to database");
			return "Login";

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			model.addAttribute("message", "Error Occurred! Try again.");
			return "Register";
		} finally {
			session.close();
		}
	}

	@Override
	public List<SocietyManager> getAllMembers() {
		Session session = sf.openSession();
		Query<SocietyManager> query = session.createQuery("FROM SocietyManager");
		List<SocietyManager> managersList = query.getResultList();
		return managersList;
	}
}
