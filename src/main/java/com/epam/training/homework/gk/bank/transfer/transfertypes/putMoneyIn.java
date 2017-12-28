package com.epam.training.homework.gk.bank.transfer.transfertypes;

import com.epam.training.homework.gk.bank.BankService;
import com.epam.training.homework.gk.bank.transfer.Transfer;
import com.epam.training.homework.gk.bank.transfer.TransferType;

public class putMoneyIn implements TransferType {

	@Override
	public void doTransfer(Transfer transaction, BankService bankService) {
		bankService.doTransaction(transaction);
	}

}
