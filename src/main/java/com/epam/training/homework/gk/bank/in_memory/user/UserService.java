package com.epam.training.homework.gk.bank.in_memory.user;

import com.epam.training.homework.gk.bank.in_memory.account.Account;

public interface UserService{

	void addAccountToUser(Account account, User user);

	User create(String name);

	void delete(User user);

	User[] getAll();

	User getById(int id);

}