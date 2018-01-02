package com.epam.training.homework.gk.bank.transfer;

import java.math.BigDecimal;
import java.util.Date;

import com.epam.training.homework.gk.bank.Persist;
import com.epam.training.homework.gk.bank.Services;
import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.history.HistoryService;

public class TransferDao implements Transfer, Persist {
	
	
	private HistoryService historyService;

	public TransferDao() {

	}

	public TransferDao(HistoryService historyService) {
		this.historyService = historyService;
	}

	Long id;
	boolean active;
	
	TransferStrategy strategy;
	
	private Services service;
	
	private Account fromAccount;
	
	private Account toAccount;
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
		this.historyService=service.getHistoryService();
		return this;
	}

	@Override
	public Account getFromAccount() {
		return this.fromAccount;
	}

	@Override
	public Transfer setFrom(Account from) {
		this.fromAccount =  from;
		return this;
	}

	@Override
	public Account getTo() {
		return this.toAccount;
	}

	@Override
	public Transfer setTo(Account account) {
		this.toAccount = account;
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
	public Transfer setValue(double i) {
		this.setValue(BigDecimal.valueOf(i));
		return this;
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
		this.strategy.doTransfer(this);
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
            
            builder.append("]");
            return builder.toString();
    }

	public HistoryService getHistoryService() {
		return historyService;
	}

	public void setHistoryService(HistoryService historyService) {
		this.historyService = historyService;
	}

	


}
