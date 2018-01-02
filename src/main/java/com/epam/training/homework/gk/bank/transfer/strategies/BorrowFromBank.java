package com.epam.training.homework.gk.bank.transfer.strategies;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.transfer.Transfer;

public class BorrowFromBank implements TransferStrategy {

	@Override
	public void doTransfer(Transfer dao) {
		Account fromAccount = dao.getService().getAccountService().create();
		dao.setFrom(fromAccount);
		Account toAccount = dao.getTo();
		toAccount.change(dao);
		
		dao.setValue(dao.getValue().negate());
		fromAccount.change(dao);
	}

	@Override
	public String toString() {
	
		
		return "BorrowFromBank";
	}

}
