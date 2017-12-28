package com.epam.training.homework.gk.bank.transfer.transfertypes;

import com.epam.training.homework.gk.bank.BankService;
import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.transfer.Transfer;
import com.epam.training.homework.gk.bank.transfer.TransferType;

public class TakeMoneyOut implements TransferType {

	@Override
	public void doTransfer(Transfer transaction, BankService bankService) {
		int fromAccount = transaction.getFromAccountId();
		Account account = bankService.getAccountById(fromAccount);
		transaction.setValue(transaction.getValue().negate());
		account.change(transaction);
	}
}
