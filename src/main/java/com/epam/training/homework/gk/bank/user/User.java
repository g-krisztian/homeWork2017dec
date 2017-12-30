package com.epam.training.homework.gk.bank.user;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.services.Persist;

public interface User extends Persist {

	void addNewAccount(Account account);

	Account[] getAccounts();

	String getName();

	void removeAccount(Account account);

	void setName(String name);

	void setActive(boolean b);
	
	@Override
	String toString();

}
