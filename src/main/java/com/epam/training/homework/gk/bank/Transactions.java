package com.epam.training.homework.gk.bank;

import java.math.BigDecimal;

public interface Transactions {
	
	void putMoney(TransactionDao transactionData);

	void takeOutMoney(TransactionDao transactionData);

	void sendGift(TransactionDao transactionData);

	void lentToBank(TransactionDao transactionData);

	BigDecimal borrowFromBank(TransactionDao transactionData);

	TransactionDao getBalance();
}
