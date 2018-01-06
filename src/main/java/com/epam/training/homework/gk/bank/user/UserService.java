package com.epam.training.homework.gk.bank.user;

import java.util.List;

import com.epam.training.homework.gk.bank.account.Account;

public interface UserService{

	void addAccountToUser(Account account, User user);

	User create(String name);

	void delete(User user);

	List<User> getAll();

	User getById(Long id);

	List<Account> getAccounts(User user);

}