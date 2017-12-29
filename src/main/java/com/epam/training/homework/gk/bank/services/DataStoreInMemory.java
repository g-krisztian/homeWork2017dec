package com.epam.training.homework.gk.bank.services;

import java.util.List;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.transfer.Transfer;
import com.epam.training.homework.gk.bank.user.User;

public class DataStoreInMemory {
	List<Account> allAccounts;
	List<Integer> userAccounts;
	List<Integer> virtualAccounts;
	List<User> users;
	List<Transfer> transfers;

	public List<Account> getAllAccounts() {
		return allAccounts;
	}

	public void setAllAccounts(List<Account> allAccounts) {
		this.allAccounts = allAccounts;
	}

	public List<Integer> getUserAccounts() {
		return userAccounts;
	}

	public void setUserAccounts(List<Integer> userAccounts) {
		this.userAccounts = userAccounts;
	}

	public List<Integer> getVirtualAccounts() {
		return virtualAccounts;
	}

	public void setVirtualAccounts(List<Integer> virtualAccounts) {
		this.virtualAccounts = virtualAccounts;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Transfer> getTransfers() {
		return transfers;
	}

	public void setTransfers(List<Transfer> transfers) {
		this.transfers = transfers;
	}
}
