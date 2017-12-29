package com.epam.training.homework.gk.bank.user;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.services.Persist;

public interface User extends Persist{

	String getName();

	void setName(String name);

	void addNewAccount(int accountId);

	void removeAccount(int accountId);

	Account[] getAccounts();

}
