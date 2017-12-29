package com.epam.training.homework.gk.bank.transfer.strategies;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.services.Services;
import com.epam.training.homework.gk.bank.transfer.TransferDao;
import com.epam.training.homework.gk.bank.transfer.TransferStrategy;

public class SendGift implements TransferStrategy {

	@Override
	public void doTransfer(TransferDao dao, Services service) {
		int fromId = dao.getFromAccountId();
		int toId = dao.getToAccountId();
		Account fromAccount = service.getAccountService().getAccountById(fromId);
		Account toAccount = service.getAccountService().getAccountById(toId);
		toAccount.change(dao);
		dao.setValue(dao.getValue().negate());
		fromAccount.change(dao);
	}
}
