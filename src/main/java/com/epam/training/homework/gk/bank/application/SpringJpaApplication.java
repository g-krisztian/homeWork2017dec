package com.epam.training.homework.gk.bank.application;

import java.util.Date;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.account.transfer.Transfer;
import com.epam.training.homework.gk.bank.account.transfer.TransferStrategy;
import com.epam.training.homework.gk.bank.facade.Facade;
import com.epam.training.homework.gk.bank.jpa.DbConnector;
import com.epam.training.homework.gk.bank.ui.UserInterface;
import com.epam.training.homework.gk.bank.user.User;


//TODO create aop 



public class SpringJpaApplication {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/beans.xml");
        UserInterface cli= (UserInterface) ctx.getBean("ui");

        //testrun(ctx);

        cli.start();

        ctx.close();
    }

	@SuppressWarnings("unused")
	private static void testrun(ClassPathXmlApplicationContext ctx) {
		Facade facade = (Facade) ctx.getBean("facade");
        DbConnector dbconnector = (DbConnector) ctx.getBean("dbConnector");


        User Bank = facade.addUser("Bank");
        facade.addAccount(Bank);

        User nyunyesz = facade.addUser("nyunyesz");
        Account nyunyesza = facade.addAccount(nyunyesz);

        Transfer transfer = facade.addTransfer();
        transfer.setTo(nyunyesza).setReason("PayDay").setValue(250000).setStrategy(TransferStrategy.Strategies.PutMoneyIn).setDate(new Date())
                .build();

        facade.doTransfer(transfer);
        dbconnector.saveTransfer(transfer);

        User[] listAllUsers = facade.listAllUsers();
        for (User user : listAllUsers) {
            for (Account account : facade.listUserAccounts(user)) {
                dbconnector.saveAccount(account);
                
            }
            dbconnector.saveUser(user);
            
        }
        
        


        
        Account nyunyeszb = facade.addAccount(nyunyesz);
        nyunyeszb.setId(null);

        
        dbconnector.saveAccount(nyunyeszb);

        
        System.out.println(dbconnector.getUsers());
        
        

        dbconnector.close();
	}

}
