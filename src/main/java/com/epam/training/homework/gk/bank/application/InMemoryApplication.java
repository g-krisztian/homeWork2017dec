package com.epam.training.homework.gk.bank.application;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.epam.training.homework.gk.bank.Services;
import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.account.AccountService;
import com.epam.training.homework.gk.bank.account.AccountServiceInMemory;
import com.epam.training.homework.gk.bank.account.transfer.Strategies;
import com.epam.training.homework.gk.bank.account.transfer.Transfer;
import com.epam.training.homework.gk.bank.account.transfer.TransferService;
import com.epam.training.homework.gk.bank.account.transfer.TransferServiceInMemory;
import com.epam.training.homework.gk.bank.datastore.DataStore;
import com.epam.training.homework.gk.bank.datastore.DataStoreInMemory;
import com.epam.training.homework.gk.bank.user.User;
import com.epam.training.homework.gk.bank.user.UserService;
import com.epam.training.homework.gk.bank.user.UserServiceInMemory;

public class InMemoryApplication {
	public static void main(String[] args) {
		List<User> users = new ArrayList<>();
		List<Account> accounts = new ArrayList<>();
		List<Transfer> transfers = new ArrayList<>();


		DataStore dataStore = new DataStoreInMemory(users, accounts, transfers);
		UserService userService = new UserServiceInMemory(dataStore);
		AccountService accountService = new AccountServiceInMemory(dataStore);
		TransferService transferService = new TransferServiceInMemory(dataStore);


		Services services = new Services(userService, accountService, transferService);

		User pista = userService.create("Pista");
		Account pistaAccount = accountService.create();
		userService.addAccountToUser(pistaAccount, pista);

		User julcsa = userService.create("Julcsa");
		Account julcsaAccount = accountService.create();
		userService.addAccountToUser(julcsaAccount, julcsa);

		
		
		Transfer transfer = transferService.create(services);
		transfer.setTo(pistaAccount)
				.setReason("PayDay")
				.setValue(BigDecimal.valueOf(250000))
				.setStrategy(Strategies.PutMoneyIn)
				.build();
		transferService.doTransfer(transfer);
		
		

		transfer = transferService.create(services);
		transfer.setFrom(pistaAccount)
				.setTo(julcsaAccount)
				.setReason("Gift")
				.setValue(BigDecimal.valueOf(12000))
				.setStrategy(Strategies.SendGift)
				.build();
		transferService.doTransfer(transfer);

		transfer = transferService.create(services);
		transfer.setFrom(julcsaAccount)
				.setStrategy(Strategies.TakeMoneyOut)
				.setValue(BigDecimal.valueOf(9000))
				.build();
		transferService.doTransfer(transfer);

		soutList(users);
		soutList(accounts);
		soutList(transfers);

	}

	private static void soutList(List<?> users) {
		System.out.println(users);
	}
}
