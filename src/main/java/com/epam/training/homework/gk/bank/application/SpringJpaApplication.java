package com.epam.training.homework.gk.bank.application;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.training.homework.gk.bank.ui.UserInterface;

public class SpringJpaApplication {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/beans.xml");
		UserInterface cli = (UserInterface) ctx.getBean("ui");
		
		cli.start();
		
		ctx.close();
	}

}
