package com.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.model.Accounts;

@Repository
public class ServiceDAOImpl implements ServiceDAO {

	@Autowired
	private SessionFactory sf;

	@Override
	public String addUsersToDB(Accounts account, Model model) {

		Session session = sf.openSession();
		Transaction trns = session.beginTransaction();
		try {
			String hql = "SELECT COUNT(*) FROM Accounts WHERE email = :email";
			Query<Long> query = session.createQuery(hql, Long.class);
			query.setParameter("email", account.getEmail());
			Long count = query.getSingleResult();
			if (count > 0) {
				model.addAttribute("loginMessage", "Account already exists !!! Please Login");
				trns.rollback();
				return "Login";
			}
			session.save(account);
			System.out.println("Account registered successfully !!");
			model.addAttribute("success", "Account registered successfully !! Please Login");
			trns.commit();
			return "Register";

		} catch (Exception msg) {
			trns.rollback();
			System.out.println("Message: " + msg.getMessage());
			return "Register";
		} finally {
			session.close();
		}

	}

	@Override
	public String loginToDB(String unameUI, String passUI, Model model, HttpSession httpSession) {

		Session session = sf.openSession();
		String hql = "FROM Accounts";
		Query<Accounts> query = session.createQuery(hql,Accounts.class);
		List<Accounts> listOfAccount = query.getResultList();
		String page = "";
		for (Accounts account : listOfAccount) {
			if (account.getUsername().equals(unameUI) && account.getPassword().equals(passUI)) {
				httpSession.setAttribute("accountObj", account);
				return "Dashboard";
			}
		}
		model.addAttribute("message", "Incorrect login Credentials !!");
		page = "Login";
		return page;
	}

	@Override
	public String depositMoneyToDB(Accounts account, String depositAmt, Model model) {
		Session session = sf.openSession();
		int uID = account.getUserID();
		Transaction trns = session.beginTransaction();
		String page = "";

		String previousBalance = account.getMinbal();
		double updatedBal = Double.parseDouble(previousBalance) + Double.parseDouble(depositAmt);
		String finalBalance = String.valueOf(updatedBal);

		account.setMinbal(finalBalance);
		session.update(account);
		trns.commit();
		session.close();
		model.addAttribute("message", "Transaction sucessfull !!\n Current Balance Rs. " + account.getMinbal() + " /-");
		return "Deposit";

	}

	public String withdrawMoneyFromDB(Accounts account, String withdrawAmt, Model model) {

		Session session = sf.openSession();
		int uID = account.getUserID();
		Transaction trns = session.beginTransaction();
		String page = "";

		double prevBal = Double.parseDouble(account.getMinbal());
		double withdrawBal = Double.parseDouble(withdrawAmt);
		if (prevBal >= withdrawBal) {
			double updatedBalance = prevBal - withdrawBal;
			String balance = String.valueOf(updatedBalance);
			account.setMinbal(balance);
			session.update(account);
			trns.commit();
			session.close();
			model.addAttribute("message",
					"Transaction sucessfull !!\n Current Balance Rs. " + account.getMinbal() + " /-");
			page = "Withdraw";
			return page;
		} else {
			model.addAttribute("success", "Insufficient Balance !!");
			page = "Withdraw";
			return page;
		}
	}

	@Override
	public String editDetailsInDB(Accounts account, String fname, String dateOfBirth, String emailID, String contact,
			Model model) {
		Session session = sf.openSession();
		int uID = account.getUserID();
		Transaction trns = session.beginTransaction();
		account.setName(fname);
		account.setDob(dateOfBirth);
		account.setEmail(emailID);
		account.setContact(contact);
		session.update(account);
		trns.commit();
		session.close();
		model.addAttribute("message", "Details updated successfully !!");
		return "EditDetails";
	}

	@Override
	public String uploadDocsToDB(Accounts account, MultipartFile pancard, MultipartFile aadhar, Model model) {
		Session session=sf.openSession();
		Transaction trns=session.beginTransaction();
		
		try {
		account.setAadharFileName(pancard.getOriginalFilename());
		account.setAadharFileData(pancard.getBytes());
		
		account.setPanFileName(aadhar.getOriginalFilename());
		account.setPanFileData(aadhar.getBytes());
		
		session.saveOrUpdate(account);
		trns.commit();
		}
		catch(Exception msg) {
			trns.rollback();
			System.out.println(msg);
			}
		return "Upload";
	}
}
