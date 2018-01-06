package com.epam.training.homework.gk.bank.user;

import java.util.List;

import com.epam.training.homework.gk.bank.ServiceSuperClass;
import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.datastore.DataStore;

public class UserServiceInMemory extends ServiceSuperClass implements UserService {
	List<User> users;

	public UserServiceInMemory(DataStore datastore) {
		this.users = datastore.getUsers();
	}

	@Override
	public void addAccountToUser(Account account, User user) {
		user.addNewAccount(account);
	}

	@Override
	public User create(String name) {
		User user = new UserDao();
		user.setName(name);
		user.setId(getMaxId(users) + 1);
		users.add(user);
		return user;
	}

	@Override
	public void delete(User user) {
		user.setActive(false);
	}

	@Override
	public List<User> getAll() {
		return users;
	}

	@Override
	public List<Account> getAccounts(User user) {
		return user.getAccounts();
	}

	@Override
	public User getById(Long id) {
		User nuser = null;
		for (User user : users) {
			if (user.getId() == id) {
				nuser = user;
				break;
			}
		}
		return nuser;
	}
	
}
