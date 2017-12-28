package com.epam.training.homework.gk.transfertypes;

import com.epam.training.homework.gk.interfaces.Account;
import com.epam.training.homework.gk.interfaces.Transaction;
import com.epam.training.homework.gk.interfaces.TransactionService;
import com.epam.training.homework.gk.interfaces.TransferType;

public class putMoneyIn implements TransferType {

	@Override
	public void doTransfer(Transaction transaction, TransactionService bankService) {

		int toAccount = transaction.getToAccountId();
		Account account = bankService.getAccount(toAccount);
		bankService.askChange(transaction);
	}

}
