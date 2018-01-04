package com.epam.training.homework.gk.bank.user;

import java.util.List;

import com.epam.training.homework.gk.bank.Persist;
import com.epam.training.homework.gk.bank.account.Account;


public interface User extends Persist {

	void addNewAccount(Account account);

	List<Account> getAccounts();

	String getName();

	void removeAccount(Account account);

	void setName(String name);

	void setActive(boolean b);
	
	@Override
	String toString();

}
