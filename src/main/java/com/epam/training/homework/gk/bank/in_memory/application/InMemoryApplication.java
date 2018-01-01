package com.epam.training.homework.gk.bank.in_memory.application;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.epam.training.homework.gk.bank.in_memory.Services;
import com.epam.training.homework.gk.bank.in_memory.account.Account;
import com.epam.training.homework.gk.bank.in_memory.account.AccountService;
import com.epam.training.homework.gk.bank.in_memory.account.AccountServiceInMemory;
import com.epam.training.homework.gk.bank.in_memory.datastore.DataStore;
import com.epam.training.homework.gk.bank.in_memory.datastore.DataStoreInMemory;
import com.epam.training.homework.gk.bank.in_memory.history.History;
import com.epam.training.homework.gk.bank.in_memory.history.HistoryService;
import com.epam.training.homework.gk.bank.in_memory.history.HistoryServiceInMemory;
import com.epam.training.homework.gk.bank.in_memory.transfer.Transfer;
import com.epam.training.homework.gk.bank.in_memory.transfer.TransferService;
import com.epam.training.homework.gk.bank.in_memory.transfer.TransferServiceInMemory;
import com.epam.training.homework.gk.bank.in_memory.transfer.strategies.PutMoneyIn;
import com.epam.training.homework.gk.bank.in_memory.transfer.strategies.SendGift;
import com.epam.training.homework.gk.bank.in_memory.transfer.strategies.TakeMoneyOut;
import com.epam.training.homework.gk.bank.in_memory.user.User;
import com.epam.training.homework.gk.bank.in_memory.user.UserService;
import com.epam.training.homework.gk.bank.in_memory.user.UserServiceInMemory;

public class InMemoryApplication {
	public static void main(String[] args) {
		List<User> users = new ArrayList<>();
		List<Account> accounts = new ArrayList<>();
		List<Transfer> transfers = new ArrayList<>();
		List<History> history = new ArrayList<>();

		DataStore dataStore = new DataStoreInMemory(users, accounts, transfers, history);
		UserService userService = new UserServiceInMemory(dataStore);
		AccountService accountService = new AccountServiceInMemory(dataStore);
		TransferService transferService = new TransferServiceInMemory(dataStore);
		HistoryService historyService = new HistoryServiceInMemory(dataStore);

		Services services = new Services(userService, accountService, transferService, historyService);

		User pista = userService.create("Pista");
		Account pistaAccount = accountService.create();
		userService.addAccountToUser(pistaAccount, pista);

		User julcsa = userService.create("Julcsa");
		Account julcsaAccount = accountService.create();
		userService.addAccountToUser(julcsaAccount, julcsa);

		
		
		Transfer transfer = transferService.create();
		transfer.setTo(pistaAccount)
				.setService(services)
				.setReason("PayDay")
				.setValue(BigDecimal.valueOf(250000))
				.setStrategy(new PutMoneyIn())
				.build();
		transfer.doTransfer();
		
		

		transfer = transferService.create();
		transfer.setFrom(pistaAccount)
				.setService(services)
				.setTo(julcsaAccount)
				.setReason("Gift")
				.setValue(BigDecimal.valueOf(12000))
				.setStrategy(new SendGift())
				.build();
		transfer.doTransfer();

		transfer = transferService.create();
		transfer.setFrom(julcsaAccount)
				.setService(services)
				.setStrategy(new TakeMoneyOut())
				.setValue(BigDecimal.valueOf(9000))
				.build();
		transfer.doTransfer();

		soutList(users);
		soutList(history);

	}

	private static void soutList(List<?> users) {
		System.out.println(users);
	}
}
