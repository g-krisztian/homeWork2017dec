package com.epam.training.homework.gk.bank.in_memory.account;


public interface AccountService {

	Account create();

	void delete(Account account);

	Account getById(int fromAccountId);

	Account[] getAll();

}