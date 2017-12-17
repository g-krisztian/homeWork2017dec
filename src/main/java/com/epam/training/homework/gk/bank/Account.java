package com.epam.training.homework.gk.bank;

import java.math.BigDecimal;
import java.util.List;

public interface Account {
	
	void change(TransactionData transactionData);
	
	BigDecimal getBalance();

	List<TransactionData> getHistory();

}
