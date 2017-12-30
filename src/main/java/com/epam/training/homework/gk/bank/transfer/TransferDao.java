package com.epam.training.homework.gk.bank.transfer;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.application.Services;
import com.epam.training.homework.gk.bank.history.History;
import com.epam.training.homework.gk.bank.transfer.strategies.TransferStrategy;

@Entity
public class TransferDao implements Transfer {
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
	TransferStrategy strategy;
	Services service;

	@Override
	public Date getDate() {
		return date;
	}

	@Override
	public TransferStrategy getStrategy() {
		return strategy;
	}

	@Override
	public void setStrategy(TransferStrategy strategy) {
		this.strategy = strategy;
	}

	@Override
	public Services getService() {
		return service;
	}

	@Override
	public void setService(Services service) {
		this.service = service;
	}

	@Override
	public Account getFromAccount() {
		return fromAccount;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public BigDecimal getInterest() {
		return interest;
	}

	@Override
	public String getReason() {
		return reason;
	}

	@Override
	public Account getToAccount() {
		return toAccount;
	}

	@Override
	public BigDecimal getValue() {
		return value;
	}

	@Override
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public void setFromAccount(Account from) {
		this.fromAccount = from;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}

	@Override
	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public void setToAccount(Account to) {
		this.toAccount = to;
	}

	@Override
	public void setValue(BigDecimal value) {
		this.value = value;
	}

	@Override
	public void doTransfer() {
		strategy.doTransfer(this, service);
	}

	@Override
	public void setActive(boolean b) {

	}

	@Override
	public History[] getHistory(Account account) {
		return null;

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if ((Integer) id != null)
			builder.append("Transfer [id=").append(id);
		if (fromAccount != null)
			builder.append(", fromAccount=").append(fromAccount.getId());
		if (toAccount != null)
			builder.append(", toAccount=").append(toAccount.getId());
		if (reason != null)
			builder.append(", reason=").append(reason);
		if (value != null)
			builder.append(", value=").append(value);
		if (interest != null)
			builder.append(", interest=").append(interest);
		if (date != null)
			builder.append(", date=").append(date);
		if (strategy != null)
			builder.append(", strategy=").append(strategy);
		if (service != null)
			builder.append(", service=").append(service);
		builder.append("]");
		return builder.toString();
	}

}
