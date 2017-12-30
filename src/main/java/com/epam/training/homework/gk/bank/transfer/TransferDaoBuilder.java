package com.epam.training.homework.gk.bank.transfer;

import java.math.BigDecimal;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.transfer.strategies.TransferStrategy;

public class TransferDaoBuilder {

	TransferDao self;

	public TransferDaoBuilder() {
		self = new TransferDao();
	}
	
	public TransferDaoBuilder clear() {
		self = new TransferDao();
		return this;
	}

	public Transfer build() {
		return self;
	}

	public TransferDaoBuilder setFrom(Account from) {
		self.setFromAccount(from);
		return this;
	}

	public TransferDaoBuilder setId(int id) {
		self.setId(id);
		return this;
	}

	public TransferDaoBuilder setInterest(BigDecimal interest) {
		self.setInterest(interest);
		return this;
	}

	public TransferDaoBuilder setReason(String reason) {
		self.setReason(reason);
		return this;
	}

	public TransferDaoBuilder setTo(Account to) {
		self.setToAccount(to);
		return this;
	}

	public TransferDaoBuilder setValue(BigDecimal value) {
		self.setValue(value);
		return this;
	}
	public TransferDaoBuilder setStrategy(TransferStrategy strategy) {
		self.strategy = strategy;
		return this;
	}
}
