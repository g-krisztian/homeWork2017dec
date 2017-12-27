package com.epam.training.homework.gk.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.epam.training.homework.gk.bank.AccountInterface;
import com.epam.training.homework.gk.bank.HistoryJdo;
import com.epam.training.homework.gk.bank.TransactionInterface;
import com.epam.training.homework.gk.dto.AccountDto;

public class BankAccountDao extends AccountDto implements AccountInterface {


	@Override
	public void change(TransactionInterface transactionData) {
		this.balance = this.balance.add(transactionData.getValue());
		addToHistory(transactionData);
	}

	private void addToHistory(TransactionInterface transactionData) {
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

	@Override
	public void setId(int id) {
		this.id = id;

	}

	@Override
	public int getId(int id) {
		return this.id;
	}

}
