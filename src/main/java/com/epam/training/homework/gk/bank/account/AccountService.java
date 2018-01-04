package com.epam.training.homework.gk.bank.account;

import java.util.List;

public interface AccountService {

	Account create();

	void delete(Account account);

	Account getById(Long fromAccountId);

	List<Account> getAll();

}