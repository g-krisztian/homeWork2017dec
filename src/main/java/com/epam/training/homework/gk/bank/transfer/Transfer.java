package com.epam.training.homework.gk.bank.transfer;

import java.math.BigDecimal;

import com.epam.training.homework.gk.bank.BankService;

public class Transfer {

	TransferDao dao;
	TransferStrategy strategy;

	public Transfer(TransferDao dao) {
		this.dao = dao;
	}

	public TransferStrategy getStrategy() {
		return strategy;
	}

	public void setType(TransferStrategy type) {
		this.strategy = type;
	}

	public int getId() {
		return this.dao.getId();
	}

	public BigDecimal getValue() {

		return this.dao.getValue();
	}

	public void doTransfer(BankService bankService) {
		strategy.doTransfer(this.dao, bankService);

		
	}



}
