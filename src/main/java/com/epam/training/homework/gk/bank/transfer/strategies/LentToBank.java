package com.epam.training.homework.gk.bank.transfer.strategies;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.services.Services;
import com.epam.training.homework.gk.bank.transfer.TransferDao;
import com.epam.training.homework.gk.bank.transfer.TransferStrategy;

public class LentToBank implements TransferStrategy {

	@Override
	public void doTransfer(TransferDao dao, Services service) {
		Account toAccount = service.getAccountService().createAccount();
		dao.setToAccount(toAccount);
		toAccount.change(dao);
		dao.setValue(dao.getValue().negate());
		Account fromAccount = dao.getFromAccount();
		fromAccount.change(dao);
	}

}
