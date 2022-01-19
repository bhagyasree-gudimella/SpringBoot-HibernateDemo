package com.lavanya.gudimella.PatientService.hibernate.config;

import java.util.Properties; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@PropertySource(value = "classpath:application.properties")
public class PatientHibernateConfiguration {

	@Autowired
	private Environment environment;

	@Bean
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
		dataSource.setUrl(environment.getProperty("spring.datasource.url"));
		dataSource.setUsername(environment.getProperty("spring.datasource.username"));
		dataSource.setPassword(environment.getProperty("spring.datasource.password"));
		return dataSource;
	}

	@Bean
	public Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.putIfAbsent("hibernate.dialect", environment.getProperty("spring.jpa.properties.hibernate.dialect"));
		properties.putIfAbsent("hibernate.show-sql", environment.getProperty("spring.jpa.properties.hibernate.show-sql"));
		properties.putIfAbsent("hibernate.hbm2ddl.auto", environment.getProperty("spring.jpa.properties.hibernate.hbm2ddl.auto"));
		return properties;
	}
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setPackagesToScan(new String[] {"com.lavanya.gudimella.PatientService"});
		sessionFactory.setHibernateProperties(getHibernateProperties());
		return sessionFactory;
	}
}
