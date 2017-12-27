package com.epam.training.homework.gk.bank;

import java.math.BigDecimal;

public class HistoryJdo {
	Transaction transactionDao;
	BigDecimal balance;
	
	public HistoryJdo(Transaction transactionDao, BigDecimal balance) {
		this.transactionDao= transactionDao;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "HistoryJdo [transactionDao=" + transactionDao + ", balance=" + balance + "]";
	}
	
	
}
