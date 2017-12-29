package com.epam.training.homework.gk.bank.account.history;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
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
