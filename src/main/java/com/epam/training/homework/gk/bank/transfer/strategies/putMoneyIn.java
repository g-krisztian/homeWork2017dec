package com.epam.training.homework.gk.bank.transfer.strategies;

import com.epam.training.homework.gk.bank.BankService;
import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.transfer.TransferDao;
import com.epam.training.homework.gk.bank.transfer.TransferStrategy;

public class putMoneyIn implements TransferStrategy {

	@Override
	public void doTransfer(TransferDao dao, BankService bankService) {
		int id = dao.getToAccountId();
		Account account = bankService.getAccountById(id);
		account.change(dao);
	}

}
