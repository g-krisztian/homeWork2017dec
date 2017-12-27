package com.epam.training.homework.gk.interfaces;

import java.math.BigDecimal;
import java.util.List;

import com.epam.training.homework.gk.dao.HistoryDao;

public interface AccountInterface {
	
	void setId(int id);
	
	int getId(int id);
	
	void change(TransactionInterface transactionData);

	List<HistoryDao> getHistory();
	
	BigDecimal getBalance();
}
