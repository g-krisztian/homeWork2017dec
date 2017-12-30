package com.epam.training.homework.gk.bank.history;

import java.math.BigDecimal;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.transfer.Transfer;

public interface HistoryService {
	
	void store(History history);

	History[] getWhere(Account account);

	History[] getWhereFrom(Account account);

	History[] getWhereTo(Account account);

	History create(Transfer dao, BigDecimal balance);

}
