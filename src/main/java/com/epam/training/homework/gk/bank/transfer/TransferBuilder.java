package com.epam.training.homework.gk.bank.transfer;

import java.math.BigDecimal;

import com.epam.training.homework.gk.bank.account.Account;

public class TransferBuilder {

	Transfer self;

	public TransferBuilder() {
		self = new Transfer();
	}
	
	public TransferBuilder clear() {
		self = new Transfer();
		return this;
	}

	public Transfer build() {
		return self;
	}

	public TransferBuilder setFrom(Account from) {
		self.setFromAccount(from);
		return this;
	}

	public TransferBuilder setId(int id) {
		self.setId(id);
		return this;
	}

	public TransferBuilder setInterest(BigDecimal interest) {
		self.setInterest(interest);
		return this;
	}

	public TransferBuilder setReason(String reason) {
		self.setReason(reason);
		return this;
	}

	public TransferBuilder setTo(Account to) {
		self.setToAccount(to);
		return this;
	}

	public TransferBuilder setValue(BigDecimal value) {
		self.setValue(value);
		return this;
	}
	public TransferBuilder setStrategy(TransferStrategy strategy) {
		self.strategy = strategy;
		return this;
	}
}
