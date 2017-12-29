package com.epam.training.homework.gk.bank.transfer;

import com.epam.training.homework.gk.bank.services.Services;

public interface TransferStrategy {


	void doTransfer(TransferDao dao, Services service);


	// void putMoney(Transaction transactionData);
	//
	// void takeOutMoney(Transaction transactionData);
	//
	// void sendGift(Transaction transactionData);
	//
	// void lentToBank(Transaction transactionData);
	//
	// void borrowFromBank(Transaction transactionData);
	//

}
