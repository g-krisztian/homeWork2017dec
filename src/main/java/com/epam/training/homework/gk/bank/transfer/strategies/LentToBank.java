package com.epam.training.homework.gk.bank.transfer.strategies;

import com.epam.training.homework.gk.bank.BankService;
import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.transfer.TransferDao;
import com.epam.training.homework.gk.bank.transfer.TransferStrategy;

public class LentToBank implements TransferStrategy {

	@Override
	public void doTransfer(TransferDao dao, BankService bankService) {

		Account account = bankService.createAccount();
		dao.setToAccountId(account.getId());
		account.change(dao);
		int id = dao.getFromAccountId();
		account = bankService.getAccountById(id);
		dao.setValue(dao.getValue().negate());
		account.change(dao);
	}

}
