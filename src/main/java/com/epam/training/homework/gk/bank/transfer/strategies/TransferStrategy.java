package com.epam.training.homework.gk.bank.transfer.strategies;

import java.math.BigDecimal;

import com.epam.training.homework.gk.bank.Services;
import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.history.History;
import com.epam.training.homework.gk.bank.history.HistoryService;
import com.epam.training.homework.gk.bank.transfer.Transfer;

public interface TransferStrategy {

	void doTransfer(Transfer dao);

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
	
	enum Strategies implements TransferStrategy{
		BorrowFromBank{

			@Override
			public void doTransfer(Transfer dao) {
				Account fromAccount = dao.getService().getAccountService().create();
				dao.setFrom(fromAccount);
				Account toAccount = dao.getTo();
				toAccount.change(dao);
				
				dao.setValue(dao.getValue().negate());
				fromAccount.change(dao);
				
			}},
		LentToBank{

			@Override
			public void doTransfer(Transfer dao) {
				Account toAccount = dao.getService().getAccountService().create();
				dao.setTo(toAccount);
				toAccount.change(dao);
				dao.setValue(dao.getValue().negate());
				Account fromAccount = dao.getFromAccount();
				fromAccount.change(dao);
				
			}},
		PutMoneyIn{

			@Override
			public void doTransfer(Transfer dao) {
				dao.getTo().change(dao);
				BigDecimal balance=dao.getTo().getBalance();
				History history = dao.getHistoryService().create(dao, balance);
				dao.getHistoryService().store(history);				
			}},
		SendGift{

			@Override
			public void doTransfer(Transfer dao) {
				HistoryService historyService = dao.getService().getHistoryService();
				Account toAccount = dao.getTo();
				toAccount.change(dao);
				BigDecimal toBalance = toAccount.getBalance();
				History toHistory = historyService.create(dao, toBalance);
				historyService.store(toHistory);

				Account fromAccount = dao.getFromAccount();
				Transfer fromDao = copyDao(dao,dao.getService());
				fromDao.setValue(fromDao.getValue().negate());
				fromAccount.change(fromDao);
				BigDecimal fromBalance = fromAccount.getBalance();
				History fromHistory = historyService.create(fromDao, fromBalance);
				historyService.store(fromHistory);
				
			}},
		TakeMoneyOut{

			@Override
			public void doTransfer(Transfer dao) {
				dao.setValue(dao.getValue().negate());
				dao.getFromAccount().change(dao);
				BigDecimal balance = dao.getFromAccount().getBalance();
				History history = dao.getService().getHistoryService().create(dao, balance);
				dao.getService().getHistoryService().store(history);
				
				
				
			}};
		

		
		

		
		
		
	}

	default Transfer copyDao(Transfer dao, Services service) {
		Transfer newDao = service.getTransferService().create(dao.getHistoryService());
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
