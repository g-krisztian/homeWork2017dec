package com.epam.training.homework.gk.bank.application;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.account.AccountService;
import com.epam.training.homework.gk.bank.account.AccountServiceInMemory;
import com.epam.training.homework.gk.bank.datastore.DataStore;
import com.epam.training.homework.gk.bank.datastore.DataStoreInMemory;
import com.epam.training.homework.gk.bank.transfer.Transfer;
import com.epam.training.homework.gk.bank.transfer.TransferDaoBuilder;
import com.epam.training.homework.gk.bank.transfer.strategies.PutMoneyIn;
import com.epam.training.homework.gk.bank.transfer.strategies.SendGift;
import com.epam.training.homework.gk.bank.transfer.strategies.TakeMoneyOut;
import com.epam.training.homework.gk.bank.user.User;
import com.epam.training.homework.gk.bank.user.UserService;
import com.epam.training.homework.gk.bank.user.UserServiceInMemory;

public class Application {
	public static void main(String[] args) {
		List<User> users = new ArrayList<>();
		List<Account> accounts = new ArrayList<>();
		List<Transfer> transfers = new ArrayList<>();

		DataStore dataStore = new DataStoreInMemory(users, accounts, transfers);
		UserService userService = new UserServiceInMemory(dataStore);
		AccountService accountService = new AccountServiceInMemory(dataStore);
		//TransferService transferService = new TransferServiceInMemory();
		
		//Services service = new Services(userService, accountService, transferService);

		User pista = userService.create("Pista");
		Account pistaAccount = accountService.create();
		userService.addAccountToUser(pistaAccount, pista);

		User julcsa = userService.create("Julcsa");
		Account julcsaAccount = accountService.create();
		userService.addAccountToUser(julcsaAccount, julcsa);

		TransferDaoBuilder builder = new TransferDaoBuilder();
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
