package com.epam.training.homework.gk.dao;

import java.math.BigDecimal;

public class HistoryDao {
	int transactionId;
	protected BigDecimal balance;

	public HistoryDao(int transactionId, BigDecimal balance) {
		this.transactionId = transactionId;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "HistoryDao [transactionId=" + transactionId + ", balance=" + balance + "]";
	}

}
