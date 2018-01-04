package com.epam.training.homework.gk.bank.facade;

import java.util.List;

import com.epam.training.homework.gk.bank.account.Account;
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
	List<Account> listUserAccounts(User user);
	List<Account> listAllAccounts(User user);
	
	TransferStrategy[] listAllStrategies();
	Transfer addTransfer();
	void doTransfer(Transfer transfer);
	
	
	List<Transfer> listHistory(Account account);
	List<Transfer> listHistoryFrom(Account account);
	List<Transfer> listHistoryTo(Account account);
}
