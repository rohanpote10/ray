package com.configuration;

import java.util.Properties;

import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.model.Accounts;

@Configuration
@EnableWebMvc
@ComponentScan(value = "com")
public class AppConfig {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource source = new DriverManagerDataSource();
		source.setDriverClassName("com.mysql.jdbc.Driver");
		source.setUrl("jdbc:mysql://localhost:3306/sbibankjavabased");
		source.setUsername("root");
		source.setPassword("root");
		return source;
	}

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setDataSource(dataSource());
		Properties prop = new Properties();
		prop.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
		prop.setProperty(Environment.HBM2DDL_AUTO, "update");
		prop.setProperty(Environment.SHOW_SQL, "true");

		sf.setHibernateProperties(prop);
		sf.setAnnotatedClasses(Accounts.class);
		//sf.setAnnotatedPackages("com.model");
		return sf;
	}
}
