package com.epam.training.homework.gk.dao;

import java.math.BigDecimal;
import java.util.Date;

import com.epam.training.homework.gk.dto.TransactionDto;
import com.epam.training.homework.gk.interfaces.Account;
import com.epam.training.homework.gk.interfaces.Transaction;

public class TransacionDao extends TransactionDto implements Transaction {
	


	@Override
	public void setAccountFromId(Account from) {
		this.fromId = from;
	}

	@Override
	public void setAccountToId(Account to) {
		this.toId = to;
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
	public BigDecimal getInterest() {
		return interest;
	}
	
	@Override
	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}


	@Override
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "TransacionDaoDefult [from=" + fromId + ", to=" + toId + ", reason=" + reason + ", value=" + value
				+ ", date=" + date + "]";
	}

	@Override
	public void setId(int id) {
		this.id=id;
	}

	@Override
	public int getId() {
		return this.id;
	}

}
