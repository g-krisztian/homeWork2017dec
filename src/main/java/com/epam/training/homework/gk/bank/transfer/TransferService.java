package com.epam.training.homework.gk.bank.transfer;

import java.util.List;

import com.epam.training.homework.gk.bank.Services;

public interface TransferService {

	Transfer create(Services service);
	
//	Transfer create();

	Transfer getById(Long id);

	List<Transfer> getAll();
	
	TransferStrategy[] getAllStrategies();

	List<Change> doTransfer(Transfer transfer);
	
}
