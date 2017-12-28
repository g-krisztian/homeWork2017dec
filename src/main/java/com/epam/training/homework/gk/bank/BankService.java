package com.epam.training.homework.gk.interfaces;

public interface TransactionService {

	Account getAccount(int toAccountId);

	void askChange(Transaction transaction);
	

}
