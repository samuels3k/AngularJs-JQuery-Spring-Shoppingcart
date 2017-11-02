package com.samuel.spring.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
//import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages= {"com.samuel.spring.shoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {

	//Change the below based on your Data base
	private static final String DATABASE_URL="jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String DATABASE_DRIVER="oracle.jdbc.driver.OracleDriver";
	private static final String DATABASE_DIALECT="org.hibernate.dialect.Oracle12cDialect";
	private static final String DATABASE_USERNAME="system";
	private static final String DATABASE_PASSWORD="manager";
	
	//Data source bean will be avilable
	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		
		//providing the database connection information
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		
		return dataSource;
	}
	
	//Session Factory Bean
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.samuel.spring.shoppingbackend.dto");
		
		return builder.buildSessionFactory();
	}

	//All the hibernate properties will be returned in this method 
private Properties getHibernateProperties() {
	
	Properties properties = new Properties();
	properties.put("hibernate.dialect", DATABASE_DIALECT);
	properties.put("hibernate.show_sql", "true");
	properties.put("hibernate.format_sql", "true");
	return properties;
}

//transaction Manager bean
@Bean
public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
	HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
	
	return transactionManager;
}
}
