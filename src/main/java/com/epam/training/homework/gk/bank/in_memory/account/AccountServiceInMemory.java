package com.epam.training.homework.gk.bank.in_memory.account;

import java.util.List;

import com.epam.training.homework.gk.bank.in_memory.ServiceSuperClass;
import com.epam.training.homework.gk.bank.in_memory.datastore.DataStore;

public class AccountServiceInMemory extends ServiceSuperClass implements AccountService {

	List<Account> accounts;

	public AccountServiceInMemory(DataStore datastore) {
		this.accounts = datastore.getAccounts();
	}

	@Override
	public Account create() {
		Account account = new AccountDao();
		account.setId(getMaxId(accounts) + 1);
		account.setActive(true);
		accounts.add(account);
		return account;
	}

	@Override
	public Account getById(int id) {
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
	public Account[] getAll() {
		return accounts.toArray(new Account[accounts.size()]);
	}

	@Override
	public void delete(Account account) {
		account.setActive(false);

	}

}
