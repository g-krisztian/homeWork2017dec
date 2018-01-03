package com.epam.training.homework.gk.bank.application;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transaction;

import org.slf4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.facade.Facade;
import com.epam.training.homework.gk.bank.jpa.DbConnector;
import com.epam.training.homework.gk.bank.transfer.Transfer;
import com.epam.training.homework.gk.bank.transfer.TransferStrategy;
import com.epam.training.homework.gk.bank.ui.UserInterface;
import com.epam.training.homework.gk.bank.user.User;

public class SpringJpaApplication {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/beans.xml");
		Facade facade = (Facade) ctx.getBean("facade");
		ctx.getBean("ui");

		User Bank = facade.addUser("Bank");
		facade.addAccount(Bank);

		User nyunyesz = facade.addUser("nyunyesz");
		Account nyunyesza = facade.addAccount(nyunyesz);
		Transfer transfer = facade.addTransfer();

		transfer.setTo(nyunyesza).setReason("PayDay").setValue(BigDecimal.valueOf(250000))
				.setStrategy(TransferStrategy.Strategies.PutMoneyIn).build();
		
		facade.doTransfer(transfer);
		
		DbConnector dbconnector = (DbConnector) ctx.getBean("dbConnector");
		
		EntityManager em = dbconnector.getEm();
		EntityTransaction transaction = em.getTransaction();
		
		User[] listAllUsers = facade.listAllUsers();
		for (User user : listAllUsers) {
		    for (Account account: facade.listUserAccounts(user)) {
		    	System.out.println(account);
		    	account.setId(null);
		        em.merge(account);
		    }
		    
		        
		    
		    System.out.println(user);
		    user.setId(null);
		    em.merge(user);    
        }
		em.flush();
		transaction.commit();
		em.flush();
		em.close();
		dbconnector.close();
		

		//cli.start();

		ctx.close();
	}

}
