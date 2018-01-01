package com.epam.training.homework.gk.bank.in_memory.transfer;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.epam.training.homework.gk.bank.in_memory.Persist;
import com.epam.training.homework.gk.bank.in_memory.Services;
import com.epam.training.homework.gk.bank.in_memory.account.Account;
import com.epam.training.homework.gk.bank.in_memory.account.AccountDaoPersist;
import com.epam.training.homework.gk.bank.in_memory.transfer.strategies.TransferStrategy;
@Entity
public class TransferDao implements Transfer, Persist {
	@Id
	@GeneratedValue
	Long id;
	boolean active;
	@Transient
	TransferStrategy strategy;
	@Transient
	private Services service;
	@ManyToOne
	private AccountDaoPersist fromAccount;
	@ManyToOne
	private AccountDaoPersist toAccount;
	private String reason;
	private BigDecimal value;
	private BigDecimal interest;
	private Date date;

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public void setActive(boolean b) {
		this.active = b;

	}

	@Override
	public TransferStrategy getStrategy() {
		return this.strategy;
	}

	@Override
	public Transfer setStrategy(TransferStrategy strategy) {
		this.strategy = strategy;
		return this;
	}

	@Override
	public Services getService() {

		return this.service;
	}

	@Override
	public Transfer setService(Services service) {
		this.service = service;
		return this;
	}

	@Override
	public Account getFromAccount() {
		return this.fromAccount;
	}

	@Override
	public Transfer setFrom(Account from) {
		this.fromAccount = (AccountDaoPersist) from;
		return this;
	}

	@Override
	public Account getTo() {
		return this.toAccount;
	}

	@Override
	public Transfer setTo(Account account) {
		this.toAccount = (AccountDaoPersist) account;
		return this;
	}

	@Override
	public Transfer setReason(String reason) {
		this.reason=reason;
		return this;
	}

	@Override
	public String getReason() {
		return this.reason;
	}

	@Override
	public BigDecimal getValue() {

		return this.value;
	}

	@Override
	public Transfer setValue(BigDecimal value) {
		this.value=value;
		return this;
	}

	@Override
	public BigDecimal getInterest() {
		return this.interest;
	}

	@Override
	public Transfer setInterest(BigDecimal interest) {
		this.interest=interest;
		return this;
	}

	@Override
	public Date getDate() {
		return this.date;
	}

	@Override
	public Transfer setDate(Date date) {
		this.date=date;
		return this;
	}


	@Override
	public void doTransfer() {
		this.strategy.doTransfer(this, service);
	}

	@Override
	public Transfer build() {

		
		return this;
	}
	
	@Override
    public String toString() {
            StringBuilder builder = new StringBuilder();
            if (id != null)
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
