package com.epam.training.homework.gk.bank.datastore;

import java.util.List;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.transfer.Transfer;
import com.epam.training.homework.gk.bank.user.User;

public interface DataStore {

	List<User> getUsers();

	List<Account> getAccounts();
	
	List<Transfer> getTransfers();

}