package com.epam.training.homework.gk.bank;

import java.util.List;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.account.AccountDao;
import com.epam.training.homework.gk.bank.transfer.Transfer;
import com.epam.training.homework.gk.bank.user.User;
import com.epam.training.homework.gk.bank.user.customer.Customer;

public class BankServiceInMemory implements BankService {
	List<Account> accounts;
	List<User> users;
	List<Transfer> transfers;

	public BankServiceInMemory(List<Account> accounts, List<User> users, List<Transfer> transfers) {
		this.accounts = accounts;
		this.users = users;
		this.transfers = transfers;
	}

	@Override
	public Account createAccount() {
		Account account = new AccountDao();
		account.setId(getMaxId(accounts) + 1);
		accounts.add(account);
		return account;
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

	@Override
	public void deleteAccountById(int id) {
		accounts.remove(getAccountById(id));
	}

	@Override
	public User createUser(String name) {
		User user = new Customer();
		user.setName(name);
		user.setId(getMaxId(users) + 1);
		users.add(user);
		return user;
	}

	private int getMaxId(List<? extends Persist> lst) {
		int max = 0;
		for (Persist p : lst) {
			if (max < p.getId()) {
				max = p.getId();
			}
		}
		return max;
	}

	@Override
	public User getUserById(int id) {
		User user = null;
		for (User u : users) {
			if (u.getId() == id) {
				user = u;
				break;
			}
		}
		return user;
	}

	@Override
	public User[] getAllUsers() {
		return users.toArray(new User[users.size()]);
	}

	@Override
	public void deleteUserById(int id) {
		users.remove(getUserById(id));
	}

	@Override
	public void doTransaction(Transfer transfer) {
		transfer.doTransfer(this);
	}

}
