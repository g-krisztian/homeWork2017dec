package com.epam.training.homework.gk.bank.aop;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AopLogger {
	
	private Logger logger;

	public AopLogger() {
		logger = LoggerFactory.getLogger(this.getClass());
		
	}
	
	public void startAopPersistence(JoinPoint jp) {
		logger.warn("Strarting: " +jp.getSourceLocation());
		
	}

	public void stopAopPersistence(JoinPoint jp) {
		logger.warn("Stopping: " +jp.getSourceLocation());
	}
	
}
