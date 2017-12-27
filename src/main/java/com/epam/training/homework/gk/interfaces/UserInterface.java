package com.epam.training.homework.gk.interfaces;

public interface UserInterface {

	int getId();

	void setId(int id);

	String getName();

	void setName(String name);

	void addAccount(AccountInterface account);

	void removeAccount(AccountInterface account);

	AccountInterface[] getAccounts();

}
