package com.epam.training.homework.gk.bank.transfer.strategies;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.transfer.Transfer;

public class LentToBank implements TransferStrategy {

	@Override
	public void doTransfer(Transfer dao) {
		Account toAccount = dao.getService().getAccountService().create();
		dao.setTo(toAccount);
		toAccount.change(dao);
		dao.setValue(dao.getValue().negate());
		Account fromAccount = dao.getFromAccount();
		fromAccount.change(dao);
	}

	@Override
	public String toString() {
		return "LentToBank";
	}

}
