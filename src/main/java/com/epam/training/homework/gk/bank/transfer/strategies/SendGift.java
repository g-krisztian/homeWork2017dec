package com.epam.training.homework.gk.bank.transfer.strategies;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.application.Services;
import com.epam.training.homework.gk.bank.transfer.Transfer;

public class SendGift implements TransferStrategy {

	@Override
	public void doTransfer(Transfer dao, Services service) {
		Account fromAccount = dao.getFromAccount();
		Account toAccount = dao.getToAccount();
		toAccount.change(dao);

		Transfer newDao = copyDao(dao);
		newDao.setValue(newDao.getValue().negate());
		fromAccount.change(newDao);
	}

	@Override
	public String toString() {
		return "SendGift";
	}
}
