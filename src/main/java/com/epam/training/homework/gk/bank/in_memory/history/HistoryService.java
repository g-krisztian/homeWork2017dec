package com.epam.training.homework.gk.bank.in_memory.history;

import java.math.BigDecimal;

import com.epam.training.homework.gk.bank.in_memory.account.Account;
import com.epam.training.homework.gk.bank.in_memory.transfer.Transfer;

public interface HistoryService {
	
	void store(History history);

	History[] getWhere(Account account);

	History[] getWhereFrom(Account account);

	History[] getWhereTo(Account account);

	History create(Transfer dao, BigDecimal balance);

}
