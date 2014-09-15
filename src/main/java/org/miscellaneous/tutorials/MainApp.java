package org.miscellaneous.tutorials;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;
import org.miscellaneous.tutorials.jdbc.BookJdbcTemplate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class MainApp {
	public static Log logger = LogFactory.getLog(MainApp.class.getName());
	
	public static void main(String[] args){
		//ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
		//applicationContext.addApplicationListener(new MyApplicationStartListener());
		applicationContext.setParent(new ClassPathXmlApplicationContext("WEB-INF/application-context.xml"));
		applicationContext.start();
		
		HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");
		helloWorld.sayHello();
		
		/*BookJdbcTemplate bookJdbcTemplate = new BookJdbcTemplate();
		JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
		bookJdbcTemplate.setJdbcTemplate(jdbcTemplate);
		System.out.println("Total pages are: " + bookJdbcTemplate.getTotalPages((long)11));
		logger.debug("Total pages are: " + bookJdbcTemplate.getTotalPages((long)11));*/
	}
}