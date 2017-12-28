package com.epam.training.homework.gk.bank;

import com.epam.training.homework.gk.bank.transfer.Transfer;

public interface BankService extends AccountService, UserService {

	void doTransaction(Transfer transfer);

}
