package com.epam.training.homework.gk.dao;

import java.math.BigDecimal;

public class TransacionDaoBuilder {

	TransactionDao self;

	public TransacionDaoBuilder() {
		self = new TransactionDao();
	}

	public TransacionDaoBuilder setId(int id) {
		self.setId(id);
		return this;
	}

	public TransacionDaoBuilder setFromId(int fromId) {
		self.setFromAccountId(fromId);
		return this;
	}

	public TransacionDaoBuilder setToId(int toId) {
		self.setToAccountId(toId);
		return this;
	}

	public TransacionDaoBuilder setReason(int toId) {
		self.setToAccountId(toId);
		return this;
	}

	public TransacionDaoBuilder setValue(BigDecimal value) {
		self.setValue(value);
		return this;
	}

	public TransacionDaoBuilder setInterest(BigDecimal interest) {
		self.setInterest(interest);
		return this;
	}

	public TransactionDao build() {
		return self;
	}
}
