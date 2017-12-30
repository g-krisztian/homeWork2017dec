package com.epam.training.homework.gk.bank.history;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.epam.training.homework.gk.bank.transfer.Transfer;

@Entity
public class HistoryDao implements History {
	@Id
	@GeneratedValue
	private int id;
	private BigDecimal balance;
	private Transfer dao;

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	public HistoryDao(Transfer transferDao, BigDecimal balance) {
		this.dao = transferDao;
		this.balance = balance;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n");
		builder.append("HistoryDao [id=");
		builder.append(id);
		builder.append(", balance=");
		builder.append(balance);
		builder.append(", transferDao=");
		builder.append(dao);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public BigDecimal getBalance() {
		return balance;
	}

	@Override
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public Transfer getDao() {
		return dao;
	}

	@Override
	public void setDao(Transfer dao) {
		this.dao = dao;
	}

	@Override
	public void setActive(boolean b) {
	

	}

}
