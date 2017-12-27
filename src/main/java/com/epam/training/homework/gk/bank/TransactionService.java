package com.epam.training.homework.gk.bank;

import java.math.BigDecimal;

public interface TransactionService {
	
	void putMoney(TransactionInterface transactionData);

	void takeOutMoney(TransactionInterface transactionData);

	void sendGift(TransactionInterface transactionData);

	void lentToBank(TransactionInterface transactionData);

	BigDecimal borrowFromBank(TransactionInterface transactionData);

	TransactionInterface getBalance();
	
	@Override
	String toString();
}
