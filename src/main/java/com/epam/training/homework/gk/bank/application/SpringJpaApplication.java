package com.epam.training.homework.gk.bank.application;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.account.transfer.Transfer;
import com.epam.training.homework.gk.bank.account.transfer.TransferStrategy;
import com.epam.training.homework.gk.bank.facade.Facade;
import com.epam.training.homework.gk.bank.ui.UserInterface;
import com.epam.training.homework.gk.bank.user.User;

//TODO create aop 

public class SpringJpaApplication {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/beans.xml");
		UserInterface cli = (UserInterface) ctx.getBean("ui");

		// testrun(ctx);

		cli.start();

		ctx.close();
	}

	@SuppressWarnings("unused")
	private static void testrun(ClassPathXmlApplicationContext ctx) {
		Facade facade = (Facade) ctx.getBean("facade");

		User bank = facade.addUser("Bank");
		User nyunyesz = facade.addUser("nyunyesz");

		Account nyunyesza = facade.addAccountUser(nyunyesz);

		Transfer transfer = facade.addTransfer(nyunyesza);
		transfer.setStrategy(TransferStrategy.Strategies.PutMoneyIn).setTo(nyunyesza).setReason("PayDay")
				.setValue(250000).setDate(new Date()).build();

		facade.doTransfer(nyunyesza, transfer);

		Account nyunyeszb = facade.addAccountUser(nyunyesz);
	}

}
