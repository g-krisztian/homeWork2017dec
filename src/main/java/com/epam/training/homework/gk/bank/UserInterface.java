package com.epam.training.homework.gk.bank;

import java.util.List;

public interface UserInterface {

	int getId();

	void setId(int Id);

	String getName();

	void setName(String name);

	void addAccount(AccountInterface account);

	void removeAccount(AccountInterface account);

	List<AccountInterface> getAccounts();

}
