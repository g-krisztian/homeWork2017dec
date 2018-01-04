package com.epam.training.homework.gk.bank.datastore;

import java.util.List;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.transfer.Transfer;
import com.epam.training.homework.gk.bank.user.User;

public class DataStoreInMemory implements DataStore {
	List<Account> accounts;
	List<User> users;
	List<Transfer> transfers;

	public DataStoreInMemory(List<User> users, List<Account> accounts, List<Transfer> transfers) {
		this.accounts = accounts;
		this.users = users;
		this.transfers = transfers;

	}

	public DataStoreInMemory() {

	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public List<User> getUsers() {
		return users;
	}

	@Override
	public List<Transfer> getTransfers() {
		return transfers;
	}


}
