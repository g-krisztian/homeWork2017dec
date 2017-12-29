package com.epam.training.homework.gk.bank.services;

import java.util.List;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.transfer.Transfer;
import com.epam.training.homework.gk.bank.user.User;
import com.epam.training.homework.gk.bank.user.customer.Customer;

public class UserServiceInMemory implements UserService {
	List<Account> allAccounts;
	List<Integer> userAccounts;
	List<Integer> virtualAccounts;
	List<User> users;
	List<Transfer> transfers;

	public UserServiceInMemory(DataStoreInMemory datastore) {
		this.allAccounts = datastore.getAllAccounts();
		this.users = datastore.getUsers();
		this.transfers = datastore.getTransfers();
	}

	@Override
	public User createUser(String name) {
		User user = new Customer();
		user.setName(name);
		user.setId(getMaxId(users) + 1);
		users.add(user);
		return user;
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
	public void addAccountToUser(int accountId, User user) {
		userAccounts.add(accountId);
		user.addNewAccount(accountId);
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
