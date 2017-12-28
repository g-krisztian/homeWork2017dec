package com.epam.training.homework.gk.bank.account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.epam.training.homework.gk.bank.account.history.HistoryDao;
import com.epam.training.homework.gk.bank.transfer.TransferDao;

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
	public int getId() {
		return this.id;
	}

	@Override
	public void change(TransferDao dao) {
		BigDecimal balance = this.balance.add(dao.getValue());
		this.history.add(new HistoryDao(dao.getId(), balance));
		this.balance = balance;

	}

}
