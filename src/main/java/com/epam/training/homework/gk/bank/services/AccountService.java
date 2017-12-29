package com.epam.training.homework.gk.bank.services;

import com.epam.training.homework.gk.bank.account.Account;

public interface AccountService {

	Account createAccount();

	void deleteAccount(Account account);

	Account getAccountById(int fromAccountId);

	Account[] getAllAccounts();

}