package com.epam.training.homework.gk.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.epam.training.homework.gk.interfaces.Account;
import com.epam.training.homework.gk.interfaces.Transaction;

public class AccountDao implements Account {
	private int id;
	private List<HistoryDao> history = new ArrayList<>();
	private BigDecimal balance;

	@Override
	public HistoryDao[] getHistory() {
		return history.toArray(new HistoryDao[history.size()]);
	}

	@Override
	public BigDecimal getBalance() {
		return this.balance;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int getId(int id) {
		return this.id;
	}

	@Override
	public void change(Transaction transaction) {
		BigDecimal balance = this.balance.add(transaction.getValue());
		this.history.add(new HistoryDao(transaction.getId(), balance));
		this.balance = balance;

	}

}
