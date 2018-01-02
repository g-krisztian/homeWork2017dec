package com.epam.training.homework.gk.bank.application;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.facade.Facade;
import com.epam.training.homework.gk.bank.history.History;
import com.epam.training.homework.gk.bank.transfer.Transfer;
import com.epam.training.homework.gk.bank.transfer.strategies.PutMoneyIn;
import com.epam.training.homework.gk.bank.user.User;

public class SpringJpaApplication {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/beans.xml");
		Facade facade = (Facade) ctx.getBean("facade");

		User joska = facade.addUser("Jóska");

		Account account = facade.addAccount(joska);

		History[] history = facade.getHistory(account);

		Transfer transfer = facade.addTransfer();

		transfer.setTo(account)
			.setReason("Pay day")
			.setValue(20000)
			.setStrategy(new PutMoneyIn())
			.build();
		transfer.doTransfer();

		System.out.println(joska);
		System.out.println(account);
		for (History h : history) {
			System.out.println(h);
		}

		ctx.close();
	}

}
