package com.epam.training.homework.gk.bank.transfer.strategies;

import com.epam.training.homework.gk.bank.BankService;
import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.transfer.TransferDao;
import com.epam.training.homework.gk.bank.transfer.TransferStrategy;

public class LentToBank implements TransferStrategy {

	@Override
	public void doTransfer(TransferDao dao, BankService bankService) {

		Account toAccount = bankService.createAccount();
		bankService.addAccountToBank(toAccount);
		dao.setToAccountId(toAccount.getId());
		toAccount.change(dao);

		Account fromAccount = bankService.getAccountById(dao.getFromAccountId());
		dao.setValue(dao.getValue().negate());
		fromAccount.change(dao);
	}

}
