package org.miscellaneous.tutorials.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.miscellaneous.tutorials.domain.Book;

public class LoggingAspect {
	Log logger = LogFactory.getLog(this.getClass().getName());
	
	public void doLogThis() {
		logger.error("Logging from doLogThis method");
	}
	
	public void doLogThisReturn(Object book) {
		logger.error("Logging returned value: " + book.toString());
	}
	
	public Book doLogAroundThis(ProceedingJoinPoint proceedingJoinPoint) {
		logger.error("In doLogAroundThis: before method execution");
		Object returnValue = null;
		try {
			 returnValue = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			logger.error("Error in executing " + proceedingJoinPoint.getTarget());
		}
		logger.error("In doLogAroundThis: after method execution with return value of: " + returnValue.toString());
		return (Book) returnValue;
	}

}
