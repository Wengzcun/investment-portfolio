package net.jr.investmentportfoliobackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages= {"net.kzn.shoppingbackend.dto"})
@EnableTransactionManagement

public class HibernateConfig {
	
	//Change the database as per your chosen database
	private final static String DATABASE_URL="jdbc:h2:tcp://localhost/~/investmentportfolio";
	private final static String DATABASE_DRIVER="org.h2.Driver";
	private final static String DATABASE_DIALECT="org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME="sa";
	private final static String DATABASE_PASSWORD="";
	
	//Get Source Bean
	@Bean
	private DataSource getDataSource()
	{
	//Providing the database connection information
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setDriverClassName(DATABASE_URL);
		dataSource.setDriverClassName(DATABASE_USERNAME);
		dataSource.setDriverClassName(DATABASE_PASSWORD);

		
		return dataSource;
	}
	//Session factory bean
	@Bean
	public SessionFactory getSessionFactory(DataSource datasource) 
	{
	LocalSessionFactoryBuilder builder= new LocalSessionFactoryBuilder(datasource);
	builder.addProperties(getHibernateProperties());
	builder.scanPackages("net.jr.investmentportfoliobackend.dto");
	
	return builder.buildSessionFactory();
	
	
	}
	
	//All Hibernate properties added to this
	private Properties getHibernateProperties() {
	
		Properties properties = new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		
		// TODO Auto-generated method stub
		return null;
	}

	//Transaction Manager Bean
	@Bean
	public HibernateTransactionManager getTransactionManager() {
		
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		
		return hibernateTransactionManager; 
	}
}