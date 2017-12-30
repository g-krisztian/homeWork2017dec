package com.epam.training.homework.gk.bank.services;

import java.util.List;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.user.User;

public interface DataStore {

	List<User> getUsers();

	List<Account> getAccounts();
	
}