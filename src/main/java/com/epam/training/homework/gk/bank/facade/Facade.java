package com.epam.training.homework.gk.bank.facade;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.history.History;
import com.epam.training.homework.gk.bank.transfer.Transfer;
import com.epam.training.homework.gk.bank.transfer.TransferStrategy;
import com.epam.training.homework.gk.bank.user.User;

public interface Facade {
	
	User addUser(String name);
	User getUserById(Long id);
	void deleteUser(User user);
	User[] listAllUsers();
	
	Account addAccount(User user);
	Account getAccountById(Long id);
	void removeAccount(Account account);
	Account[] listAllAccounts(User user);
	
	TransferStrategy[] listAllStrategies();
	Transfer addTransfer();
	void doTransfer(Transfer transfer);
	
	
	History[] listHistory(Account account);
	History[] listHistoryFrom(Account account);
	History[] listHistoryTo(Account account);
}
