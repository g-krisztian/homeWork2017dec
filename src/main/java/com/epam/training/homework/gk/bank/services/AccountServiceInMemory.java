package com.epam.training.homework.gk.bank.services;

import java.util.List;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.account.AccountDao;

public class AccountServiceInMemory implements AccountService {

	List<Account> accounts;

	public AccountServiceInMemory(DataStore datastore) {
		this.accounts = datastore.getAccounts();
	}

	@Override
	public Account createAccount() {
		Account account = new AccountDao();
		account.setId(getMaxId(accounts) + 1);
		account.setActive(true);
		accounts.add(account);
		return account;
	}

	@Override
	public void deleteAccount(Account account) {
		account.setActive(false);
	}

	@Override
	public Account getAccountById(int id) {
		Account account = null;
		for (Account a : accounts) {
			if (a.getId() == id) {
				account = a;
				break;
			}
		}
		return account;
	}

	@Override
	public Account[] getAllAccounts() {
		return accounts.toArray(new Account[accounts.size()]);
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
