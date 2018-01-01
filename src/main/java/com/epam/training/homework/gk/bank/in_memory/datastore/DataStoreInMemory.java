package com.epam.training.homework.gk.bank.in_memory.datastore;

import java.util.List;

import com.epam.training.homework.gk.bank.in_memory.account.Account;
import com.epam.training.homework.gk.bank.in_memory.history.History;
import com.epam.training.homework.gk.bank.in_memory.transfer.Transfer;
import com.epam.training.homework.gk.bank.in_memory.user.User;

public class DataStoreInMemory implements DataStore {
	List<Account> accounts;
	List<User> users;
	List<Transfer> transfers;
	List<History> history;

	public DataStoreInMemory(List<User> users, List<Account> accounts, List<Transfer> transfers, List<History> history) {
		this.accounts = accounts;
		this.users = users;
		this.transfers = transfers;
		this.history = history;
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

	@Override
	public List<History> getHistory() {

		return history;
	}

}
