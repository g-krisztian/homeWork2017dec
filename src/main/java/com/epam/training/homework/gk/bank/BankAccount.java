package com.epam.training.homework.gk.bank;

import java.math.BigDecimal;
import java.util.List;

public interface BankAccount {
	
	void change(Transaction transactionData);

	List<HistoryJdo> getHistory();
	
	BigDecimal getBalance();
}
