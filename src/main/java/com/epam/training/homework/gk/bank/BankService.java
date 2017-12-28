package com.epam.training.homework.gk.bank;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.transfer.Transfer;
import com.epam.training.homework.gk.bank.user.User;

public interface BankService extends AccountService, UserService {

	void doTransaction(Transfer transfer);

	void addAccountToBank(Account account);
	void addAccountToUser(Account account,User user);
}
