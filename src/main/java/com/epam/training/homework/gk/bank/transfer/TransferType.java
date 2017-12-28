package com.epam.training.homework.gk.bank.transfer;

import com.epam.training.homework.gk.bank.BankService;

public interface TransferType {

	void doTransfer(Transfer transaction, BankService bankService);

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
