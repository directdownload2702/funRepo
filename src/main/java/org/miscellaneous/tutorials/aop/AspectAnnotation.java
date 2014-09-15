package org.miscellaneous.tutorials.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.miscellaneous.tutorials.domain.Book;
import org.aspectj.lang.ProceedingJoinPoint;

@Aspect
public class AspectAnnotation {
	Log logger = LogFactory.getLog(this.getClass().getName());
	
	@Pointcut("execution(* org.miscellaneous.tutorials.service.BookServiceImpl.getBook(long))")
	public void getBookPointCut() {
		
	}
	
	@Around("getBookPointCut()")
	public Book inspectBooksList(ProceedingJoinPoint proceedingJoinPoint){
		Object returnValue = null;
		logger.error("In Aspect annotation: Before method execution");
		try {
			returnValue = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			logger.error("Error in AspectAnnotation: " + e.getMessage());
		}
		return (Book) returnValue;
	}

}
