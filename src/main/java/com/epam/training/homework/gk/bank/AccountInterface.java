package com.epam.training.homework.gk.bank;

import java.math.BigDecimal;
import java.util.List;

public interface AccountInterface {
	
	void setId(int id);
	
	int getId(int id);
	
	void change(TransactionInterface transactionData);

	List<HistoryJdo> getHistory();
	
	BigDecimal getBalance();
}
