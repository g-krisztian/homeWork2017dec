package com.epam.training.homework.gk.bank.application;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.aop.AopPersistence;
import com.epam.training.homework.gk.bank.facade.Facade;
import com.epam.training.homework.gk.bank.jpa.DbConnector;
import com.epam.training.homework.gk.bank.transfer.Strategies;
import com.epam.training.homework.gk.bank.transfer.Transfer;
import com.epam.training.homework.gk.bank.ui.UserInterface;
import com.epam.training.homework.gk.bank.user.User;

//TODO create aop 

public class SpringJpaApplication {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/beans.xml");
		UserInterface cli = (UserInterface) ctx.getBean("ui");

		// testrun(ctx);

		//cli.start();
		
		Facade facade = (Facade) ctx.getBean("facade");
		System.out.println(facade.listHistory(facade.getAccountById(2L)));
		

		ctx.close();
	}

	@SuppressWarnings("unused")
	private static void testrun(ClassPathXmlApplicationContext ctx) {
		Facade facade = (Facade) ctx.getBean("facade");

		User bank = facade.addUser("Bank");
		User nyunyesz = facade.addUser("nyunyesz");

		Account nyunyesza = facade.addAccountToUser(nyunyesz);

		Transfer transfer = facade.addTransferToAccount(nyunyesza);
		transfer.setStrategy(Strategies.PutMoneyIn).setTo(nyunyesza).setReason("PayDay")
				.setValue(250000).setDate(new Date()).build();

		facade.doTransfer(transfer);

		Account nyunyeszb = facade.addAccountToUser(nyunyesz);
	}

}
