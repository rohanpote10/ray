package com.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.Company;

public class MainController {
	public static void main(String[] args) {

		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		Company company=context.getBean("company", Company.class);
		System.out.println(company);
	}
}
