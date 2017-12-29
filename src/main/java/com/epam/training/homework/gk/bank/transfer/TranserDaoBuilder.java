package com.epam.training.homework.gk.bank.transfer;

import java.math.BigDecimal;

import com.epam.training.homework.gk.bank.account.Account;

public class TranserDaoBuilder {

	TransferDao self;

	public TranserDaoBuilder() {
		self = new TransferDao();
	}

	public TransferDao build() {
		return self;
	}

	public TranserDaoBuilder setFrom(Account from) {
		self.setFromAccount(from);
		return this;
	}

	public TranserDaoBuilder setId(int id) {
		self.setId(id);
		return this;
	}

	public TranserDaoBuilder setInterest(BigDecimal interest) {
		self.setInterest(interest);
		return this;
	}

	public TranserDaoBuilder setReason(String reason) {
		self.setReason(reason);
		return this;
	}

	public TranserDaoBuilder setTo(Account to) {
		self.setToAccount(to);
		return this;
	}

	public TranserDaoBuilder setValue(BigDecimal value) {
		self.setValue(value);
		return this;
	}
}
