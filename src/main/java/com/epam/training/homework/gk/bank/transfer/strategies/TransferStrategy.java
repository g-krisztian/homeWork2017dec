package com.epam.training.homework.gk.bank.transfer.strategies;

import com.epam.training.homework.gk.bank.application.Services;
import com.epam.training.homework.gk.bank.transfer.Transfer;
import com.epam.training.homework.gk.bank.transfer.TransferDao;

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
	// 	HistoryDao[] getHistory();

	default Transfer copyDao(Transfer dao) {
		Transfer newDao = new TransferDao();
		newDao.setDate(dao.getDate());
		newDao.setFromAccount(dao.getFromAccount());
		newDao.setInterest(dao.getInterest());
		newDao.setReason(dao.getReason());
		newDao.setService(dao.getService());
		newDao.setStrategy(dao.getStrategy());
		newDao.setToAccount(dao.getToAccount());
		newDao.setValue(dao.getValue());
		return newDao;
	}

}
