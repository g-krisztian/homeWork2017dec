package com.epam.training.homework.gk.bank.transfer;

import com.epam.training.homework.gk.bank.services.Services;

public class Transfer {

	TransferDao dao;
	TransferStrategy strategy;
	Services service;

	public Transfer() {

	}

	public Transfer(TransferDao dao, TransferStrategy strategy, Services service) {
		this.dao = dao;
		this.strategy = strategy;
		this.service = service;
	}

	public void setService(Services service) {
		this.service = service;
	}

	public void setDao(TransferDao dao) {
		this.dao = dao;
	}

	public void setStrategy(TransferStrategy strategy) {
		this.strategy = strategy;
	}

	public void doTransfer() {
		strategy.doTransfer(dao, service);
	}

}
