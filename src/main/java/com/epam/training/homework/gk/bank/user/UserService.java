package com.epam.training.homework.gk.bank.user;

import com.epam.training.homework.gk.bank.account.Account;

public interface UserService{

	void addAccountToUser(Account account, User user);

	User create(String name);

	void delete(User user);

	User[] getAll();

	User getById(Long id);

}