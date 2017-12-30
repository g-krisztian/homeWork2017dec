package com.epam.training.homework.gk.bank.services;

import java.util.List;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.user.User;

public class DataStoreInMemory implements DataStore {
	List<Account> accounts;
	List<User> users;

	public DataStoreInMemory(List<User> users, List<Account> accounts) {
		super();
		this.accounts = accounts;
		this.users = users;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public List<User> getUsers() {
		return users;
	}

}
