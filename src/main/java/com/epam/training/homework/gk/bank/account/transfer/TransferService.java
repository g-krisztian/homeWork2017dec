package com.epam.training.homework.gk.bank.account.transfer;

import java.util.List;

import com.epam.training.homework.gk.bank.Services;
import com.epam.training.homework.gk.bank.account.Account;

public interface TransferService {

	Transfer create(Services service);
	
	Transfer create();

	Transfer getById(Long id);

	List<Transfer> getAll();
	
	TransferStrategy[] getAllStrategies();

	void doTransfer(Transfer transfer);
	
}
