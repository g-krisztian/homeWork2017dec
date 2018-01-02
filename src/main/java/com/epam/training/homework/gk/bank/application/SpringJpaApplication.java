package com.epam.training.homework.gk.bank.application;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.training.homework.gk.bank.facade.Facade;
import com.epam.training.homework.gk.bank.ui.UserInterface;
import com.epam.training.homework.gk.bank.user.User;

public class SpringJpaApplication {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/beans.xml");
		Facade facade = (Facade) ctx.getBean("facade");
		UserInterface cli = (UserInterface) ctx.getBean("ui");
		
		User Bank = facade.addUser("Bank");
		facade.addAccount(Bank);
		
		User nyunyesz = facade.addUser("nyunyesz");
		facade.addAccount(nyunyesz);

		cli.start();

		ctx.close();
	}

}
