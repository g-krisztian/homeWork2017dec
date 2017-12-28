package com.epam.training.homework.gk.interfaces;

public interface User {

	int getId();

	void setId(int id);

	String getName();

	void setName(String name);

	void addAccount(Account account);

	void removeAccount(Account account);

	Account[] getAccounts();

}
