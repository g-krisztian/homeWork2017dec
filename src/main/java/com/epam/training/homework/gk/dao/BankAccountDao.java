package com.epam.training.homework.gk.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.epam.training.homework.gk.dto.AccountDto;
import com.epam.training.homework.gk.interfaces.AccountInterface;
import com.epam.training.homework.gk.interfaces.TransactionInterface;

public class BankAccountDao extends AccountDto implements AccountInterface {


	@Override
	public void change(TransactionInterface transactionData) {
		this.balance = this.balance.add(transactionData.getValue());
		addToHistory(transactionData);
	}

	private void addToHistory(TransactionInterface transactionData) {
		history.add(new HistoryDao(transactionData, this.balance));
	}

	@Override
	public List<HistoryDao> getHistory() {
		List<HistoryDao> history = new ArrayList<>();
		history.addAll(this.history);
		return history;
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

}
