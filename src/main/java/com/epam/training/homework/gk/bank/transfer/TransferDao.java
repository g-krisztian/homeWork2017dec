package com.epam.training.homework.gk.bank.transfer;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.epam.training.homework.gk.bank.account.Account;

@Entity
public class TransferDao {
	@Id
	@GeneratedValue
	private int id;
	@OneToOne
	private Account toAccount;
	@OneToOne
	private Account fromAccount;
	private String reason;
	private BigDecimal value;
	private BigDecimal interest;
	private Date date;

	public Date getDate() {
		return date;
	}

	public Account getFromAccount() {
		return fromAccount;
	}

	public int getId() {
		return id;
	}

	public BigDecimal getInterest() {
		return interest;
	}

	public String getReason() {
		return reason;
	}

	public Account getToAccount() {
		return toAccount;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setFromAccount(Account from) {
		this.fromAccount = from;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public void setToAccount(Account to) {
		this.toAccount = to;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

}
