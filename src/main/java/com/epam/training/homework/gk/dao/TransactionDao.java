package com.epam.training.homework.gk.dao;

import java.math.BigDecimal;
import java.util.Date;

import com.epam.training.homework.gk.interfaces.Transaction;

public class TransactionDao implements Transaction {
	protected int id;
	protected int fromId;
	protected int toId;
	protected String reason;
	protected BigDecimal value;
	protected BigDecimal interest;
	protected Date date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFromAccountId() {
		return fromId;
	}

	public void setFromAccountId(int fromId) {
		this.fromId = fromId;
	}

	public int getToAccountId() {
		return toId;
	}

	public void setToAccountId(int toId) {
		this.toId = toId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getInterest() {
		return interest;
	}

	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
