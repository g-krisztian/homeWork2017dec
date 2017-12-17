package com.epam.training.homework.gk.bank;

import java.math.BigDecimal;

public interface Transactions {
	void putMoney(TransactionData transactionData);

	void takeOutMoney(TransactionData transactionData);

	void sendGift(TransactionData transactionData);

	void lentToBank(TransactionData transactionData);

	BigDecimal borrowFromBank(TransactionData transactionData);

	TransactionData getBalance();
}
