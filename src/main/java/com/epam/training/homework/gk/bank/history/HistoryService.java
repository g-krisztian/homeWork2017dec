package com.epam.training.homework.gk.bank.history;

import com.epam.training.homework.gk.bank.account.Account;

public interface HistoryService {
	
	//void store(Transfer transfer);

	History[] getWhere(Account account);

	History[] getWhereFrom(Account account);

	History[] getWhereTo(Account account);

}
