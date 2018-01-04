package com.epam.training.homework.gk.bank.application;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.facade.Facade;
import com.epam.training.homework.gk.bank.jpa.DbConnector;
import com.epam.training.homework.gk.bank.transfer.Transfer;
import com.epam.training.homework.gk.bank.transfer.TransferStrategy;
import com.epam.training.homework.gk.bank.user.User;


//TODO create JPA aop 
//TODO remove id creation in it


public class SpringJpaApplication {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/beans.xml");
        ctx.getBean("ui");

        testrun(ctx);

        //cli.start();

        ctx.close();
    }

	private static void testrun(ClassPathXmlApplicationContext ctx) {
		Facade facade = (Facade) ctx.getBean("facade");
        DbConnector dbconnector = (DbConnector) ctx.getBean("dbConnector");
        EntityManager em = dbconnector.getEm();
        EntityTransaction transaction = em.getTransaction();

        User Bank = facade.addUser("Bank");
        facade.addAccount(Bank);

        User nyunyesz = facade.addUser("nyunyesz");
        Account nyunyesza = facade.addAccount(nyunyesz);
        Transfer transfer = facade.addTransfer();

        transfer.setTo(nyunyesza).setReason("PayDay").setValue(250000).setStrategy(TransferStrategy.Strategies.PutMoneyIn).setDate(new Date())
                .build();

        facade.doTransfer(transfer);

        transfer.setId(null);

        transaction.begin();

        em.persist(transfer);

        User[] listAllUsers = facade.listAllUsers();
        for (User user : listAllUsers) {
            for (Account account : facade.listUserAccounts(user)) {
                System.out.println(account);
                account.setId(null);
                em.persist(account);
            }

            if (user.getName() == null) {
                //   user.setName("Bank");
            }
            System.out.println(user);
            user.setId(null);
            em.persist(user);
            
        }
        
        

        em.flush();
        transaction.commit();
        
        Account nyunyeszb = facade.addAccount(nyunyesz);
        nyunyeszb.setId(null);
        transaction = em.getTransaction();
        transaction.begin();
        
        em.persist(nyunyeszb);
        em.flush();
        transaction.commit();
        
        em.close();
        dbconnector.close();
	}

}
