package com.epam.training.homework.gk.bank.account;

import java.util.ArrayList;
import java.util.List;

import com.epam.training.homework.gk.bank.ServiceSuperClass;
import com.epam.training.homework.gk.bank.account.transfer.Transfer;
import com.epam.training.homework.gk.bank.datastore.DataStore;

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
	public Account getById(Long id) {
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
	public List<Account> getAll() {
		return accounts;
	}

	@Override
	public void delete(Account account) {
		account.setActive(false);

	}

	@Override
	public void addTransfer(Account account, Transfer transfer) {
		account.addTransfer(transfer);
	}

	@Override
	public List<Transfer> getHistory(Account account) {
		return account.getHistory();
	}

	@Override
	public List<Transfer> getHistoryFrom(Account account) {
		List<Transfer> history = account.getHistory();
		List<Transfer> historyFrom = new ArrayList<>();
		for (Transfer transfer : history) {
			if (transfer.getFromAccount() == account)
				historyFrom.add(transfer);
		}
		return history;
	}

	@Override
	public List<Transfer> getHistoryTo(Account account) {
		List<Transfer> history = account.getHistory();
		List<Transfer> historyTo = new ArrayList<>();
		for (Transfer transfer : history) {
			if (transfer.getToAccount() == account)
				historyTo.add(transfer);
		}
		return history;
	}

}
