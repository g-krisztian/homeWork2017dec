package com.epam.training.homework.gk.bank.transfer.strategies;

import com.epam.training.homework.gk.bank.BankService;
import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.transfer.TransferDao;
import com.epam.training.homework.gk.bank.transfer.TransferStrategy;

public class TakeMoneyOut implements TransferStrategy {

	@Override
	public void doTransfer(TransferDao dao, BankService bankService) {
		int id = dao.getFromAccountId();
		dao.setValue(dao.getValue().negate());
		Account account = bankService.getAccountById(id);
		account.change(dao);
	}

}
