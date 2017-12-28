package com.epam.training.homework.gk.interfaces;

public interface TransferType {

	void doTransfer(Transaction transaction, TransactionService bankService);

	// void putMoney(Transaction transactionData);
	//
	// void takeOutMoney(Transaction transactionData);
	//
	// void sendGift(Transaction transactionData);
	//
	// void lentToBank(Transaction transactionData);
	//
	// BigDecimal borrowFromBank(Transaction transactionData);
	//
	// Transaction getBalance(Transaction transactionData);
	//
	// @Override
	// String toString();
}
