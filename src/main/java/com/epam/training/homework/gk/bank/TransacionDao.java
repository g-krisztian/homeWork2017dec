package com.epam.training.homework.gk.bank;

import java.math.BigDecimal;
import java.util.Date;

import com.epam.training.homework.gk.dto.TransactionDTO;

public class TransacionDao extends TransactionDTO implements Transaction {
	


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
	public double getInterest() {
		return interest;
	}
	
	@Override
	public void setInterest(double interest) {
		this.interest = interest;
	}


	@Override
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "TransacionDaoDefult [from=" + from + ", to=" + to + ", reason=" + reason + ", value=" + value
				+ ", date=" + date + "]";
	}

}
