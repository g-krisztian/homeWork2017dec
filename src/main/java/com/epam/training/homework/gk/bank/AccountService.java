package com.epam.training.homework.gk.bank;

import com.epam.training.homework.gk.bank.account.Account;

public interface AccountService {

	Account createAccount();

	Account getAccountById(int id);

	Account[] getAllAccounts();
	
	void deleteAccountById(int id);

}