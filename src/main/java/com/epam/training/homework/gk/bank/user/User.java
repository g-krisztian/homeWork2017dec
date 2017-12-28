package com.epam.training.homework.gk.bank.user;

import com.epam.training.homework.gk.bank.account.Account;

public interface User {

	int getId();

	void setId(int id);

	String getName();

	void setName(String name);

	void addNewAccount(Account account);

	void removeAccount(Account account);

	Account[] getAccounts();

}
