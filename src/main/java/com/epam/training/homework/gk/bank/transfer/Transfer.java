package com.epam.training.homework.gk.bank.transfer;

import java.math.BigDecimal;

import com.epam.training.homework.gk.bank.BankService;

public class Transfer {

	TransferDao dao;
	TransferType transferType;

	public Transfer(TransferDao dao) {
		this.dao = dao;
	}

	public TransferType getType() {
		return transferType;
	}

	public void setType(TransferType type) {
		this.transferType = type;
	}

	public int getId() {
		return this.dao.getId();
	}

	public BigDecimal getValue() {

		return this.dao.getValue();
	}

	public void doTransfer(BankService bankService) {
		
		
		
	}



}
