package com.epam.training.homework.gk.dao;

import java.math.BigDecimal;

import com.epam.training.homework.gk.dto.AccountDto;
import com.epam.training.homework.gk.dto.HistoryDto;
import com.epam.training.homework.gk.interfaces.Account;
import com.epam.training.homework.gk.interfaces.Transaction;

public class AccountDao extends AccountDto implements Account {

	@Override
	public void change(Transaction transactionData) {
		this.balance = this.balance.add(transactionData.getValue());
		addToHistory(transactionData);
	}

	private void addToHistory(Transaction transactionData) {
		history.add(new HistoryDao(transactionData, this.balance));
	}

	@Override
	public HistoryDto[] getHistory() {

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

}
