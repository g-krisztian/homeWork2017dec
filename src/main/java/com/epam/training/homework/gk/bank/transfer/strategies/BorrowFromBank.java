package com.epam.training.homework.gk.bank.transfer.strategies;

import com.epam.training.homework.gk.bank.BankService;
import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.transfer.TransferDao;
import com.epam.training.homework.gk.bank.transfer.TransferStrategy;

public class BorrowFromBank implements TransferStrategy{

	@Override
	public void doTransfer(TransferDao dao, BankService bankService) {
		Account fromAccount = bankService.createAccount();
		Account toAccount= bankService.getAccountById(dao.getToAccountId());
		toAccount.change(dao);
		dao.setValue(dao.getValue().negate());
		fromAccount.change(dao);
	}

}
