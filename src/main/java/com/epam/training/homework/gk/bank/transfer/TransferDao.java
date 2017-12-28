package com.epam.training.homework.gk.bank.transfer;

import java.math.BigDecimal;
import java.util.Date;

public class TransferDao implements Transfer {
	private int id;
	private int fromAccountId;
	private int toAccountId;
	private String reason;
	private BigDecimal value;
	private BigDecimal interest;
	private Date date;

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int getFromAccountId() {
		return fromAccountId;
	}

	@Override
	public void setFromAccountId(int fromId) {
		this.fromAccountId = fromId;
	}

	@Override
	public int getToAccountId() {
		return toAccountId;
	}

	@Override
	public void setToAccountId(int toId) {
		this.toAccountId = toId;
	}

	@Override
	public String getReason() {
		return reason;
	}

	@Override
	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public BigDecimal getValue() {
		return value;
	}

	@Override
	public void setValue(BigDecimal value) {
		this.value = value;
	}

	@Override
	public BigDecimal getInterest() {
		return interest;
	}

	@Override
	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}

	@Override
	public Date getDate() {
		return date;
	}

	@Override
	public void setDate(Date date) {
		this.date = date;
	}

}
