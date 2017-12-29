package com.epam.training.homework.gk.bank.transfer.strategies;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.services.Services;
import com.epam.training.homework.gk.bank.transfer.TransferDao;
import com.epam.training.homework.gk.bank.transfer.TransferStrategy;

public class SendGift implements TransferStrategy {

	@Override
	public void doTransfer(TransferDao dao, Services service) {
		Account fromAccount = dao.getFromAccount();
		Account toAccount = dao.getToAccount();
		toAccount.change(dao);
		dao.setValue(dao.getValue().negate());
		fromAccount.change(dao);
	}
}
