package com.epam.training.homework.gk.bank.transfer.strategies;

import java.math.BigDecimal;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.history.History;
import com.epam.training.homework.gk.bank.history.HistoryService;
import com.epam.training.homework.gk.bank.transfer.Transfer;

public class SendGift implements TransferStrategy {

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
	}


	@Override
	public String toString() {
		return "SendGift";
	}
}
