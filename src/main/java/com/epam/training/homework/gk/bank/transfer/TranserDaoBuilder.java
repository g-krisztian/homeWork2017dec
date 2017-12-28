package com.epam.training.homework.gk.bank.transfer;

import java.math.BigDecimal;

public class TranserDaoBuilder {

	TransferDao self;

	public TranserDaoBuilder() {
		self = new TransferDao();
	}

	public TranserDaoBuilder setId(int id) {
		self.setId(id);
		return this;
	}

	public TranserDaoBuilder setFromId(int fromId) {
		self.setFromAccountId(fromId);
		return this;
	}

	public TranserDaoBuilder setToId(int toId) {
		self.setToAccountId(toId);
		return this;
	}

	public TranserDaoBuilder setReason(int toId) {
		self.setToAccountId(toId);
		return this;
	}

	public TranserDaoBuilder setValue(BigDecimal value) {
		self.setValue(value);
		return this;
	}

	public TranserDaoBuilder setInterest(BigDecimal interest) {
		self.setInterest(interest);
		return this;
	}

	public TransferDao build() {
		return self;
	}
}
