package com.epam.training.homework.gk.bank;

import com.epam.training.homework.gk.bank.transfer.Transfer;
import com.epam.training.homework.gk.bank.user.User;

public interface BankService extends AccountService, UserService {

	void doTransaction(Transfer transfer);

	void addAccountToBank(int accountId);
	void addAccountToUser(int accountId,User user);
}
