package com.epam.training.homework.gk.bank.services;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.user.User;

public interface UserService {

	void addAccountToUser(Account account, User user);

	User createUser(String name);

	void deleteUser(User user);

	User[] getAllUsers();

	User getUserById(int id);

}