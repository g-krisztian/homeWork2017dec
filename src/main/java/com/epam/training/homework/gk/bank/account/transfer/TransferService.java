package com.epam.training.homework.gk.bank.account.transfer;

import com.epam.training.homework.gk.bank.Services;

public interface TransferService {

	Transfer create(Services service);
	
	Transfer create();

	Transfer getById(Long id);

	Transfer[] getAll();
	
	TransferStrategy[] getAllStrategies();

	void doTransfer(Transfer transfer);
	
}
