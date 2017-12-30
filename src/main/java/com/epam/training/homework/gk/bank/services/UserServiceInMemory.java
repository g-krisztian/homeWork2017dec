package com.epam.training.homework.gk.bank.services;

import java.util.List;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.user.UserDao;
import com.epam.training.homework.gk.bank.user.User;

public class UserServiceInMemory implements UserService {
	List<User> users;

	public UserServiceInMemory(DataStore datastore) {
		this.users = datastore.getUsers();
	}

	@Override
	public void addAccountToUser(Account account, User user) {
		user.addNewAccount(account);
	}

	@Override
	public User createUser(String name) {
		User user = new UserDao();
		user.setName(name);
		user.setId(getMaxId(users) + 1);
		users.add(user);
		return user;
	}

	@Override
	public void deleteUser(User user) {
		user.setActive(false);
	}

	@Override
	public User[] getAllUsers() {
		return users.toArray(new User[users.size()]);
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
