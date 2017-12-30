package com.epam.training.homework.gk.bank.transfer;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.services.Services;

@Entity
public class Transfer {
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
	

	public Date getDate() {
		return date;
	}

	public TransferStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(TransferStrategy strategy) {
		this.strategy = strategy;
	}

	public Services getService() {
		return service;
	}

	public void setService(Services service) {
		this.service = service;
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

	public void doTransfer() {
		strategy.doTransfer(this, service);
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
