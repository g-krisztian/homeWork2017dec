package com.epam.training.homework.gk.bank;

import java.math.BigDecimal;
import java.util.Date;

public class TransacionDaoDefult implements TransactionDao {
	BankAccount from;
	BankAccount to;
	String reason;
	BigDecimal value;
	Date date;

	@Override
	public void setAccountFrom(BankAccount from) {
		this.from = from;
	}

	@Override
	public void setAccountTo(BankAccount to) {
		this.to = to;
	}

	@Override
	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
	@Override
	public BigDecimal getValue() {
		return this.value;
	}

	@Override
	public void setDate(Date date) {
		this.date = date;
	}


}
