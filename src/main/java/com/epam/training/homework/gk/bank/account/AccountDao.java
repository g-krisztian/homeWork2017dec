package com.epam.training.homework.gk.bank.account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.epam.training.homework.gk.bank.account.history.HistoryDao;
import com.epam.training.homework.gk.bank.transfer.Transfer;

@Entity
public class AccountDao implements Account {

	@Id
	@GeneratedValue
	private int id;
	BigDecimal balance;
	@OneToMany
	List<HistoryDao> history;
	boolean active;

	public AccountDao() {
		active = true;
		history = new ArrayList<>();
		balance = new BigDecimal("0");
	}

	@Override
	public void change(Transfer dao) {
		BigDecimal balance = this.balance.add(dao.getValue());
		this.history.add(new HistoryDao(dao, balance));
		this.balance = balance;
	}

	@Override
	public BigDecimal getBalance() {
		return this.balance;
	}

	@Override
	public HistoryDao[] getHistory() {
		return history.toArray(new HistoryDao[history.size()]);
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	@Override
	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "\nAccountDao [id=" + id + ", balance=" + balance + ", active=" + active + ",\n history=" + history + "]";
	}
}
