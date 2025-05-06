package com.configuration;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitialize implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext arg) throws ServletException {

		  AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
	        context.register(AppConfig.class); 

	        
	        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

	        
	        ServletRegistration.Dynamic registration = arg.addServlet("dispatcherServlet", dispatcherServlet);
	        registration.setLoadOnStartup(1);
	        registration.addMapping("/");
		
//		AnnotationConfigWebApplicationContext apc = new AnnotationConfigWebApplicationContext();
//		//configuration class => Beans => viewResolver , dataSource , sessionFactor etc
//		apc.register(AppConfig.class);
//		arg.addServlet("dispatcherServlet", new DispatcherServlet()).addMapping("/");
	}

}
