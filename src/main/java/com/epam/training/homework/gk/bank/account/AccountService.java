package com.epam.training.homework.gk.bank.account;


public interface AccountService {

	Account create();

	void delete(Account account);

	Account getById(int fromAccountId);

	Account[] getAll();

}