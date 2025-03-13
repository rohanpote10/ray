package com.service;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.model.Employee;
import com.util.HibernateUtil;

public class ServiceImpl {

	SessionFactory sf = HibernateUtil.getsessionSessionFactory();
	Scanner sc = new Scanner(System.in);

	public void insertStudent() {
		Session session = sf.openSession();
		System.out.println("Enter no of student you want to add- ");
		int employees = sc.nextInt();

		for (int i = 0; i < employees; i++) {
			Scanner sc1 = new Scanner(System.in);
			Employee e = new Employee();
			System.out.println("\nEnter Employee Name- ");
			e.setName(sc1.nextLine());
			System.out.println("Enter Employee Address- ");
			e.setAddress(sc.next());
			System.out.println("Enter Employee Salary- ");
			e.setSalary(sc.nextDouble());

			session.save(e);
		}
		session.beginTransaction().commit();
		session.close();
	}

	public void findMinSalary() {
		Session session = sf.openSession();

		Query<Double> sQuery = session.createQuery("select min (salary) from Employee");
		Double minSalary = sQuery.getSingleResult();

		System.out.println("Min Salary is " + minSalary);
		session.close();
	}

	public void findSecondHighestSalary() {
		Session session = sf.openSession();

		Query<Double> query = session
				.createQuery("select max(salary) from Employee where salary<(select max(salary) from Employee)");
		Double secondMaxSalary = query.getSingleResult();
		System.out.println("Second Max Salary- " + secondMaxSalary);
	}

	public void findThirdHighestSalaryWithEmployee() {
		Session session = sf.openSession();

		Query<Employee> query = session.createQuery("from Employee order by salary desc");
		query.setMaxResults(1); // works as a limit starts with 1
		query.setFirstResult(1); // works as a offset works on index starts with 0

		List<Employee> list = query.getResultList();
		for (Employee emp : list) {
			System.out.println(emp);
		}
		session.close();
	}

	public void findAllSalaryExceptLarger() {
		Session session = sf.openSession();

		Query<Double> query = session
				.createQuery("select salary from Employee where salary<(select max(salary) from Employee)");
		List<Double> list = query.getResultList();

		for (Double d : list) {
			System.out.println(d);
		}
		session.close();
	}

	public void descOrderByName() {
		Session session = sf.openSession();

		Query<Object> query = session.createQuery("from Employee order by name desc");
		List<Object> list = query.getResultList();

		for (Object obj : list) {
			System.out.println(obj);
		}
		session.close();
	}

	public void ascOrderBySalary() {
		Session session = sf.openSession();

		Query<Double> query = session.createQuery("select salary from Employee order by salary asc");
		List<Double> list = query.getResultList();

		for (Double d : list) {
			System.out.println(d);
		}
		session.close();
	}

	public void displaySumOfSalary() {
		Session session = sf.openSession();

		Query<Double> query = session.createQuery("select sum(salary) from Employee");
		List<Double> list = query.getResultList();

		for (Double d : list) {
			System.out.println(d);
		}
	}

	public void displayAllData() {
		Session session = sf.openSession();
		
//		Query<Employee> query= session.createNamedQuery("getALLEmployee");
//		List<Employee> list1 = query.getResultList();
//		System.out.println(list1);

		Query<Employee> query = session.createQuery("from Employee");
		List<Employee> list = query.getResultList();

		for (Employee emp : list) {
			System.out.println(emp);
		}
		session.close();
	}

	public void updateEmployee() {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();

		Query<?> query = session
				.createQuery("update Employee set name='rupsa',address='lotus',salary=25000 where id=2");
		query.executeUpdate();
		session.close();
	}

	public void displayEmployeesWhoesSalaryIsSmallerThan() {
		Session session = sf.openSession();

		Query<Object[]> query = session.createQuery("select name,salary from Employee where salary<75000");
		List<Object[]> list = query.getResultList();
		
//		when we are calling specific fields(objects) then you have to take Object[] in generic
//		when we are calling total data of single object then we can use that class name in generic
		
		for(Object[] objarr : list) {
			System.out.println(Arrays.toString(objarr));
		}
		session.close();
	}
	
	public void deleteSingleEmployee() {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();

		Query<?> query = session
				.createQuery("delete from Employee where id=4");
		query.executeUpdate();
		
		session.close();
	}
	
//	public void displaySpecificEmployeeNameAndAddress() {
//		Session session = sf.openSession();
//		Transaction tr = session.beginTransaction();
//		
//		Query<Object[]> query = session.createQuery("getSpeificEmployeeNameAndAddress");
//		System.out.println("Enter Id to display- ");
//		query.setParameter("id1", sc.nextInt());
//		List<Object[]> list = query.getResultList();
//		
//		for (Object[] objects : list) {
//			System.out.println(Arrays.toString(objects));
//		}
//		session.close();
//	}

}