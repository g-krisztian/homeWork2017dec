package com.epam.training.homework.gk.bank.in_memory.transfer.strategies;

import com.epam.training.homework.gk.bank.in_memory.Services;
import com.epam.training.homework.gk.bank.in_memory.account.Account;
import com.epam.training.homework.gk.bank.in_memory.transfer.Transfer;

public class BorrowFromBank implements TransferStrategy {

	@Override
	public void doTransfer(Transfer dao, Services service) {
		Account fromAccount = service.getAccountService().create();
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
