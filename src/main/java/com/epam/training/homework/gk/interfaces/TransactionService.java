package com.epam.training.homework.gk.interfaces;

import java.math.BigDecimal;

public interface TransactionService {
	
	void putMoney(Transaction transactionData);

	void takeOutMoney(Transaction transactionData);

	void sendGift(Transaction transactionData);

	void lentToBank(Transaction transactionData);

	BigDecimal borrowFromBank(Transaction transactionData);

	Transaction getBalance();
	
	@Override
	String toString();
}
