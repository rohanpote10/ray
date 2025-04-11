package com.dao;

import java.util.List;
import java.util.Map;
import java.util.Objects;

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
		Query<Accounts> query = session.createQuery(hql);
		List<Accounts> listOfAccount = query.getResultList();
		String page = "";
		for (Accounts account : listOfAccount) {
			if (account.getUsername().equals(unameUI) && account.getPassword().equals(passUI)
					&& account.getName().equalsIgnoreCase("admin")) {
				page = "adminPortal";
				return "redirect:/adminDashboard";
			} else if (account.getUsername().equals(unameUI) && account.getPassword().equals(passUI)) {
				httpSession.setAttribute("accountObj", account);
				page = "Dashboard";
				return page;
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

		Session session = sf.openSession();
		Transaction trns = session.beginTransaction();

		try {
			account.setAadharFileName(pancard.getOriginalFilename());
			account.setAadharFileData(pancard.getBytes());

			account.setPanFileName(aadhar.getOriginalFilename());
			account.setPanFileData(aadhar.getBytes());

			session.saveOrUpdate(account);
			trns.commit();
		} catch (Exception msg) {
			trns.rollback();
			System.out.println(msg);
		}
		return "Upload";
	}

	@Override
	public String forgotPasswordExistingUser(Accounts account, String newPassword, String username, String oldPassword,
			Model model) {
		Session session = sf.openSession();
		Transaction trns = session.beginTransaction();
		String page = "";
		try {
			if (account.getPassword().equals(oldPassword)) {
				account.setPassword(newPassword);
				session.update(account);
				trns.commit();
				model.addAttribute("changedMessage", "Password changed successfully !! Please Login");
				session.close();
				Thread.sleep(3000);
			} else {
				model.addAttribute("changedMessage", "Password can't be changed !!");
				session.close();
				Thread.sleep(3000);
				return "Login";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Login";
	}

	@Override
	public String forgotPasswordNonExisting(String newPassword, String username, String oldPassword, Model model) {

		Session session = sf.openSession();
		Transaction trns = session.beginTransaction();

		String hqlQuery = " FROM Accounts WHERE username=:uname";
		Query<Accounts> query = session.createQuery(hqlQuery, Accounts.class);
		query.setParameter("uname", username);
		Accounts account = query.getSingleResult();
		String page = "";
		if (account != null) {
			if (account.getUsername().equals(username) && account.getPassword().equals(oldPassword)) {
				account.setPassword(newPassword);
				account.setOldPassword(oldPassword);
				session.update(account);
				trns.commit();
				page = "Login";
				model.addAttribute("changedMessage", "Password changed successfully !! Please Login");
				session.close();
				return page;
			} else {
				page = "Login";
				model.addAttribute("errorMessage", "Invalid Credentials !! Please Try again");
			}
		} else {
			model.addAttribute("changedMessage", "User doesn't exist !!");
			page = "Login";
		}
		return page;
	}

	@Override
	public String addAdminToDB(Accounts account, Model model) {
		Session session = sf.openSession();
		Transaction trns = session.beginTransaction();
		session.save(account);
		System.out.println("Account registered successfully !!");
		model.addAttribute("success", "Account registered successfully !! Please Login");
		trns.commit();
		return "adminRegister";
	}

	@Override
	public String getAllUsersFromDB(Model model) {
		
		Session session=sf.openSession();
		Transaction trns=session.beginTransaction();
		String hql="SELECT COUNT(userID) FROM Accounts  WHERE aadhar IS NOT NULL";
		Query<Long> query=session.createQuery(hql,Long.class);
		Long totalAccounts=query.uniqueResult();
		model.addAttribute("totalAccounts",totalAccounts);
		
		String accType1="Savings";
		hql="SELECT COUNT(userID) FROM Accounts WHERE acctype=:accType1";
		Query<Long> queryType1=session.createQuery(hql,Long.class);
		queryType1.setParameter("accType1", accType1);
		Long savingsAcc=queryType1.uniqueResult();
		model.addAttribute("savingsAcc",savingsAcc);
		
		String accType2="Current";
		hql="SELECT COUNT(userID) FROM Accounts WHERE acctype=:accType2";
		Query<Long> queryType2=session.createQuery(hql,Long.class);
		queryType2.setParameter("accType2", accType2);
		Long currentAcc=queryType2.uniqueResult();
		model.addAttribute("currentAcc",currentAcc);
	
		String accType3 = "Fixed Deposit";
		hql = "SELECT COUNT(userID) FROM Accounts WHERE acctype = :accType3";
		Query<Long> queryType3 = session.createQuery(hql, Long.class);
		queryType3.setParameter("accType3", accType3);
		Long fdAcc = queryType3.uniqueResult();
		model.addAttribute("fdAcc", fdAcc);
		
		List<String> minBals = session.createQuery("SELECT minbal FROM Accounts ", String.class).list();
		Double total = minBals.stream()
		    .filter(Objects::nonNull)
		    .mapToDouble(val -> {
		        try {
		            return Double.parseDouble(val);
		        } catch (NumberFormatException e) {
		            return 0.0;
		        }
		    }).sum();
		model.addAttribute("balance", String.valueOf(total));
		
		hql="FROM Accounts WHERE aadhar IS NOT NULL";
		Query<Accounts> queryAll=session.createQuery(hql);
		List<Accounts>listOfAccounts=queryAll.getResultList();
		model.addAttribute("listOfAcc",listOfAccounts);
		return "adminPortal";
	}

}
