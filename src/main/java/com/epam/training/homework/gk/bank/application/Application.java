package com.epam.training.homework.gk.bank.application;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.services.AccountService;
import com.epam.training.homework.gk.bank.services.AccountServiceInMemory;
import com.epam.training.homework.gk.bank.services.DataStore;
import com.epam.training.homework.gk.bank.services.DataStoreInMemory;
import com.epam.training.homework.gk.bank.services.UserService;
import com.epam.training.homework.gk.bank.services.UserServiceInMemory;
import com.epam.training.homework.gk.bank.transfer.Transfer;
import com.epam.training.homework.gk.bank.transfer.TransferBuilder;
import com.epam.training.homework.gk.bank.transfer.strategies.PutMoneyIn;
import com.epam.training.homework.gk.bank.transfer.strategies.SendGift;
import com.epam.training.homework.gk.bank.transfer.strategies.TakeMoneyOut;
import com.epam.training.homework.gk.bank.user.User;

public class Application {
	public static void main(String[] args) {
		List<User> users = new ArrayList<>();
		List<Account> accounts = new ArrayList<>();
		DataStore dataStore = new DataStoreInMemory(users, accounts);
		UserService userService = new UserServiceInMemory(dataStore);
		AccountService accountService = new AccountServiceInMemory(dataStore);
		// Services service = new Services(userService, accountService);

		User pista = userService.createUser("Pista");
		Account pistaAccount = accountService.createAccount();
		userService.addAccountToUser(pistaAccount, pista);

		User julcsa = userService.createUser("Julcsa");
		Account julcsaAccount = accountService.createAccount();
		userService.addAccountToUser(julcsaAccount, julcsa);

		TransferBuilder builder = new TransferBuilder();
		Transfer transfer = builder.setTo(pistaAccount).setReason("PayDay").setValue(BigDecimal.valueOf(250000))
				.setStrategy(new PutMoneyIn()).build();
		transfer.doTransfer();

		builder.clear();
		transfer = builder.setFrom(pistaAccount).setTo(julcsaAccount).setReason("Gift")
				.setValue(BigDecimal.valueOf(12000)).setStrategy(new SendGift()).build();
		transfer.doTransfer();

		builder.clear();
		transfer = builder.setFrom(julcsaAccount).setStrategy(new TakeMoneyOut()).setValue(BigDecimal.valueOf(9000))
				.build();
		transfer.doTransfer();
		
		soutList(users);

	}

	private static void soutList(List<?> users) {
		System.out.println(users);
	}
}
