package com.epam.training.homework.gk.bank;

import java.math.BigDecimal;

public class HistoryJdo {
	TransactionDao transactionData;
	BigDecimal balance;

	public HistoryJdo(TransactionDao transactionData, BigDecimal balance) {
		this.transactionData = transactionData;
		this.balance = balance;
	}
}
