package com.epam.training.homework.gk.bank.application;

import java.math.BigDecimal;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.facade.Facade;
import com.epam.training.homework.gk.bank.transfer.Transfer;
import com.epam.training.homework.gk.bank.transfer.TransferStrategy;
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
		Account nyunyesza = facade.addAccount(nyunyesz);
		Transfer transfer = facade.addTransfer();

		transfer.setTo(nyunyesza).setReason("PayDay").setValue(BigDecimal.valueOf(250000))
				.setStrategy(TransferStrategy.Strategies.PutMoneyIn).build();
		
		facade.doTransfer(transfer);

		cli.start();

		ctx.close();
	}

}
