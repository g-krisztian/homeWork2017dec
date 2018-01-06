package com.epam.training.homework.gk.bank.account;

import java.util.List;

import com.epam.training.homework.gk.bank.account.transfer.Transfer;

public interface AccountService {

	Account create();

	void delete(Account account);

	Account getById(Long Id);

	List<Account> getAll();

	List<Transfer> getHistory(Account account);

	List<Transfer> getHistoryFrom(Account account);

	List<Transfer> getHistoryTo(Account account);

	void addTransfer(Account account, Transfer transfer);

}