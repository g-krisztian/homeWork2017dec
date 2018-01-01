package com.epam.training.homework.gk.bank.in_memory.user;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

import com.epam.training.homework.gk.bank.in_memory.Persist;
import com.epam.training.homework.gk.bank.in_memory.account.Account;


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
