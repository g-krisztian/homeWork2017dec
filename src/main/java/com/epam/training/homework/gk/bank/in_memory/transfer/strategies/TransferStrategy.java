package com.epam.training.homework.gk.bank.in_memory.transfer.strategies;

import com.epam.training.homework.gk.bank.in_memory.Services;
import com.epam.training.homework.gk.bank.in_memory.transfer.Transfer;

public interface TransferStrategy {

	void doTransfer(Transfer dao, Services service);

	// void putMoney(Transaction transactionData);
	//
	// void takeOutMoney(Transaction transactionData);
	//
	// void sendGift(Transaction transactionData);
	//
	// void lentToBank(Transaction transactionData);
	//
	// void borrowFromBank(Transaction transactionData);
	//
	// HistoryDao[] getHistory();

	default Transfer copyDao(Transfer dao, Services service) {
		Transfer newDao = service.getTransferService().create();
		newDao.setDate(dao.getDate());
		newDao.setFrom(dao.getFromAccount());
		newDao.setInterest(dao.getInterest());
		newDao.setReason(dao.getReason());
		newDao.setService(dao.getService());
		newDao.setStrategy(dao.getStrategy());
		newDao.setTo(dao.getTo());
		newDao.setValue(dao.getValue());
		return newDao;
	}

}
