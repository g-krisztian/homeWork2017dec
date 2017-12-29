package com.epam.training.homework.gk.bank.transfer.strategies;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.services.Services;
import com.epam.training.homework.gk.bank.transfer.TransferDao;
import com.epam.training.homework.gk.bank.transfer.TransferStrategy;

public class TakeMoneyOut implements TransferStrategy {

	@Override
	public void doTransfer(TransferDao dao, Services service) {
		int id = dao.getFromAccountId();
		dao.setValue(dao.getValue().negate());
		Account account = service.getAccountService().getAccountById(id);
		account.change(dao);
	}

}
