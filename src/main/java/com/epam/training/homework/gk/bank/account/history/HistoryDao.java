package com.epam.training.homework.gk.bank.account.history;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.epam.training.homework.gk.bank.transfer.Transfer;

@Entity
public class HistoryDao {
	@Id
	@GeneratedValue
	private int id;
	private BigDecimal balance;
	private Transfer transferDao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HistoryDao(Transfer transferDao, BigDecimal balance) {
		this.transferDao = transferDao;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "\nHistoryDao [transferDao=" + transferDao + ", balance=" + balance + "]";
	}

}
