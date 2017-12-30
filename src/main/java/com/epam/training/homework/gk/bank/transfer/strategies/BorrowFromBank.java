package com.epam.training.homework.gk.bank.transfer.strategies;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.services.Services;
import com.epam.training.homework.gk.bank.transfer.Transfer;
import com.epam.training.homework.gk.bank.transfer.TransferStrategy;

public class BorrowFromBank implements TransferStrategy {

	@Override
	public void doTransfer(Transfer dao, Services service) {
		Account fromAccount = service.getAccountService().createAccount();
		dao.setFromAccount(fromAccount);
		Account toAccount = dao.getToAccount();
		toAccount.change(dao);
		dao.setValue(dao.getValue().negate());
		fromAccount.change(dao);
	}

	@Override
	public String toString() {
	
		
		return "BorrowFromBank";
	}

}
