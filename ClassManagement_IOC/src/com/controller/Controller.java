package com.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.Batch;
import com.model.Course;
import com.model.Faculty;
import com.model.Student;

public class Controller {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("-----------------Student Object Called---------------------------");
		Student student = context.getBean("student", Student.class);
		System.out.println(student);
		System.out.println("-----------------Batch Object Called---------------------------");
		Batch batch = context.getBean("batch", Batch.class);
		System.out.println(batch);
		System.out.println("-----------------Faculty Object Called---------------------------");
		Faculty faculty = context.getBean("faculty", Faculty.class);
		System.out.println(faculty);
		System.out.println("-----------------Course Object Called---------------------------");
		Course course = context.getBean("course", Course.class);
		System.out.println(course);
		System.out.println("------------------------------------------------------------------------");
	}
}
