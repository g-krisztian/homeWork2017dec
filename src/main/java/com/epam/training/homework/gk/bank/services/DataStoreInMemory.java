package com.epam.training.homework.gk.bank.services;

import java.util.List;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.user.User;

public class DataStoreInMemory {
	List<Account> accounts;
	List<User> users;

	public List<Account> getAccounts() {
		return accounts;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setAccounts(List<Account> allAccounts) {
		this.accounts = allAccounts;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
