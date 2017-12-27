package com.epam.training.homework.gk.bank;

import java.math.BigDecimal;

public interface Transactions {
	
	void putMoney(Transaction transactionData);

	void takeOutMoney(Transaction transactionData);

	void sendGift(Transaction transactionData);

	void lentToBank(Transaction transactionData);

	BigDecimal borrowFromBank(Transaction transactionData);

	Transaction getBalance();
	
	@Override
	String toString();
}
