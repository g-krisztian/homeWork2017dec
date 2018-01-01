package com.epam.training.homework.gk.bank.in_memory.datastore;

import java.util.List;

import com.epam.training.homework.gk.bank.in_memory.account.Account;
import com.epam.training.homework.gk.bank.in_memory.history.History;
import com.epam.training.homework.gk.bank.in_memory.transfer.Transfer;
import com.epam.training.homework.gk.bank.in_memory.user.User;

public interface DataStore {

	List<User> getUsers();

	List<Account> getAccounts();
	
	List<Transfer> getTransfers();

	List<History> getHistory();
	
}