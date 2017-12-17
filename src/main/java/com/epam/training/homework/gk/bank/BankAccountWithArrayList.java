package com.epam.training.homework.gk.bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankAccountWithArrayList implements BankAccount {

	private List<HistoryJdo> history = new ArrayList<>();
	private BigDecimal balance;

	@Override
	public void change(TransactionDao transactionData) {
		this.balance = this.balance.add(transactionData.getValue());
		addToHistory(transactionData);
	}

	private void addToHistory(TransactionDao transactionData) {
		history.add(new HistoryJdo(transactionData, this.balance));
	}

	@Override
	public List<HistoryJdo> getHistory() {
		List<HistoryJdo> history = new ArrayList<>();
		history.addAll(this.history);
		return history;
	}

	@Override
	public BigDecimal getBalance() {
		return this.balance;
	}

}
