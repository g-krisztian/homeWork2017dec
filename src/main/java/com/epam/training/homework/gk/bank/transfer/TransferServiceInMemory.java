package com.epam.training.homework.gk.bank.transfer;

import java.util.ArrayList;
import java.util.List;

import com.epam.training.homework.gk.bank.ServiceSuperClass;

public class TransferServiceInMemory extends ServiceSuperClass implements TransferService {

	List<Transfer> transfers = new ArrayList<>();


	@Override
	public Transfer getById(int id) {
		Transfer transfer = null;
		for (Transfer t : transfers) {
			if (t.getId() == id) {
				transfer = t;
				break;
			}
		}
		return transfer;
	}

	@Override
	public Transfer[] getAll() {
		return transfers.toArray(new Transfer[transfers.size()]);
	}



}
