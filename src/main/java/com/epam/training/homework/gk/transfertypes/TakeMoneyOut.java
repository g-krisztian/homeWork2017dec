package com.epam.training.homework.gk.transfertypes;

import com.epam.training.homework.gk.interfaces.Account;
import com.epam.training.homework.gk.interfaces.Transaction;
import com.epam.training.homework.gk.interfaces.TransactionService;
import com.epam.training.homework.gk.interfaces.TransferType;

public class TakeMoneyOut implements TransferType {

	@Override
	public void doTransfer(Transaction transaction, TransactionService bankService) {
		int fromAccount = transaction.getFromAccountId();
		Account account = bankService.getAccount(fromAccount);
		transaction.setValue(transaction.getValue().negate());
		account.change(transaction);
	}
}
