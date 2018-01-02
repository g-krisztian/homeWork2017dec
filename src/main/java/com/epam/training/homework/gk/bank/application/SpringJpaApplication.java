package com.epam.training.homework.gk.bank.application;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.training.homework.gk.bank.facade.Facade;
import com.epam.training.homework.gk.bank.ui.UserInterface;

public class SpringJpaApplication {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/beans.xml");
		
		Facade facade = (Facade) ctx.getBean("facade");
		
		facade.addUser("Bank");
		
		UserInterface cli = (UserInterface) ctx.getBean("ui");
		
		cli.start();
		
		ctx.close();
	}

}
