package com.epam.training.homework.gk.bank.services;

import java.util.List;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.account.AccountDao;
import com.epam.training.homework.gk.bank.transfer.Transfer;
import com.epam.training.homework.gk.bank.user.User;

public class AccountServiceInMemory implements AccountService {

	List<Account> allAccounts;
	List<Integer> userAccounts;
	List<User> users;
	List<Transfer> transfers;

	public AccountServiceInMemory(DataStoreInMemory datastore) {
		this.allAccounts = datastore.getAllAccounts();
		this.users = datastore.getUsers();
		this.transfers = datastore.getTransfers();
	}

	@Override
	public Account createAccount() {
		Account account = new AccountDao();
		account.setId(getMaxId(allAccounts) + 1);
		allAccounts.add(account);
		return account;
	}

	@Override
	public Account getAccountById(int id) {
		Account account = null;
		for (int a : userAccounts) {
			if (a == id) {
				account = allAccounts.get(a);
				break;
			}
		}
		return account;
	}

	@Override
	public Account[] getAllAccounts() {
		return userAccounts.toArray(new Account[userAccounts.size()]);
	}

	@Override
	public void deleteAccountById(int id) {
		userAccounts.remove(id);
	}

	int getMaxId(List<? extends Persist> lst) {
		int max = 0;
		for (Persist p : lst) {
			if (max < p.getId()) {
				max = p.getId();
			}
		}
		return max;
	}
}
