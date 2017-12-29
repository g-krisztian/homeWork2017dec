package com.epam.training.homework.gk.bank.services;

import com.epam.training.homework.gk.bank.account.Account;

public interface AccountService {

	Account createAccount();

	Account[] getAllAccounts();


	Account getAccountById(int fromAccountId);

	void deleteAccountById(int id);

}