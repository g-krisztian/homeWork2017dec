package com.epam.training.homework.gk.bank.facade;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.history.History;
import com.epam.training.homework.gk.bank.transfer.Transfer;
import com.epam.training.homework.gk.bank.user.User;

public interface Facade {
	
	User addUser(String name);
	void deleteUser(User user);
	User[] listAllUsers();
	
	Account addAccount(User user);
	void removeAccount(Account account);
	Account[] listAllAccounts(User user);
	
	Transfer addTransfer();
	void doTransfer(Transfer transfer);
	History[] getHistory(Account account);
	History[] getHistoryFrom(Account account);
	History[] getHistoryTo(Account account);
}
