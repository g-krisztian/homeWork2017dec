package com.epam.training.homework.gk.bank;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.account.AccountDao;
import com.epam.training.homework.gk.bank.transfer.Transfer;
import com.epam.training.homework.gk.bank.user.User;
import com.epam.training.homework.gk.bank.user.customer.Customer;

@Entity
public class BankServicePersistence implements BankService {
	@OneToMany
	List<Account> allAccounts;
	@OneToMany
	List<Integer> userAccounts;
	@OneToMany
	List<Integer> virtualAccounts;
	@OneToMany
	List<User> users;
	@OneToMany
	List<Transfer> transfers;

	public BankServicePersistence(List<Integer> accounts, List<User> users, List<Transfer> transfers) {
		this.userAccounts = accounts;
		this.users = users;
		this.transfers = transfers;
	}

	@Override
	public Account createAccount() {
		Account account = new AccountDao();
		account.setId(getMaxId(allAccounts) + 1);
		allAccounts.add(account);
		return account;
	}

	@Override
	public void addAccountToBank(int accountId) {
		virtualAccounts.add(accountId);
	}

	@Override
	public void addAccountToUser(int accountId, User user) {
		userAccounts.add(accountId);
		user.addNewAccount(accountId);
	}

	@Override
	public Account getAccountById(int id) {
		Account account = null;
		for (Integer a : userAccounts) {
			if (a == id) {
				account = allAccounts.get(id);
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
