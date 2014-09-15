package org.miscellaneous.tutorials;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.miscellaneous.tutorials.Listeners.MyApplicationStartListener;
import org.miscellaneous.tutorials.aop.AspectAnnotation;
import org.miscellaneous.tutorials.dao.BookDaoImpl;
import org.miscellaneous.tutorials.jdbc.dao.BookDao;
import org.miscellaneous.tutorials.service.BookServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class MyConfig {
	private static final String VIEW_PREFIX = "/WEB-INF/pages/";
	private static final String VIEW_SUFFIX = ".jsp";
	private static final String DRIVER_CLASS_NAME = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/miscellaneousDb";
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "postgres";
	private static final String ANNOTATED_PACKAGE = "org.miscellaneous.tutorials.domain";
	private static final String PROP_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String PROP_VALUE_HIBERNATE_DIALECT = "org.hibernate.dialect.PostgreSQLDialect";
	
	@Bean
	public MyApplicationStartListener getMyAppStartListener() {
		return new MyApplicationStartListener();
	}
	
	/*@Bean
	public DataSource dataSource(){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(DRIVER_CLASS_NAME);
		dataSource.setUrl(URL);
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres");
		return dataSource;
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(DRIVER_CLASS_NAME);
		dataSource.setUrl(URL);
		dataSource.setUsername(USERNAME);
		dataSource.setPassword(PASSWORD);
		return dataSource;
	}
	
	@Bean
	public Properties hibernateProperties(){
		Properties hibernateProperties = new Properties();
		hibernateProperties.put(PROP_NAME_HIBERNATE_DIALECT, PROP_VALUE_HIBERNATE_DIALECT);
		return hibernateProperties;
	}	
	@Bean
	public AnnotationSessionFactoryBean sessionFactory(){
		AnnotationSessionFactoryBean sessionFactory = new AnnotationSessionFactoryBean();
		sessionFactory.setAnnotatedClasses(org.miscellaneous.tutorials.domain.Book.class);
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}
	
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) throws SQLException{
		System.out.println("Data source name is: " + dataSource.getConnection());
		return  new JdbcTemplate(dataSource);
	}*/
	
	@Bean
	public BookServiceImpl bookServiceImpl(){
		return new BookServiceImpl();
	}
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix(VIEW_PREFIX);
		viewResolver.setSuffix(VIEW_SUFFIX);
		return viewResolver;
	}
	
	@Bean
	public AspectAnnotation aspectAnnotation() {
		return new AspectAnnotation();
	}
	
}