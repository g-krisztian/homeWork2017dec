package com.epam.training.homework.gk.bank.facade;

import java.util.List;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.account.transfer.Transfer;
import com.epam.training.homework.gk.bank.account.transfer.TransferStrategy;
import com.epam.training.homework.gk.bank.user.User;

public interface Facade {
	
	User addUser(String name);
	User getUserById(Long id);
	void deleteUser(User user);
	List<User> listAllUsers();
	User getBank();
	
	Account getAccountById(Long id);
	Account addAccountUser(User user);
	void removeAccount(Account account);
	List<Account> listUserAccounts(User user);
	
	TransferStrategy[] listAllStrategies();

	Transfer addTransfer(Account account);
	
	void doTransfer(Account account, Transfer transfer);
	
	List<Transfer> listHistory(Account account);
	List<Transfer> listHistoryFrom(Account account);
	List<Transfer> listHistoryTo(Account account);
}
