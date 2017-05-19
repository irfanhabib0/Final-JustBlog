package com.niit.JustBlogBackEnd;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.service.internal.SessionFactoryServiceRegistryBuilderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.JustBlogBackEnd.model.UserDetails;

@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement



public class ApplicationContextConfig {
	

	@Bean(name = "dataSource")
	public DataSource getOracleDataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");

		dataSource.setUsername("irfan"); // Schema name
		dataSource.setPassword("1234");
		
		return dataSource;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {

		
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		Properties connectionProperties = new Properties();

		connectionProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		connectionProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		connectionProperties.setProperty("hibernate.show_sql", "true");
		connectionProperties.setProperty("hibernate.format_sql", "true");
		sessionBuilder.addProperties(connectionProperties);

		sessionBuilder.scanPackages("com.niit.JustBlogBackEnd.model");
		
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {

		
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		
		return transactionManager;
	}


	

}

