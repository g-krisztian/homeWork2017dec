package com.epam.training.homework.gk.bank.account.transfer;

import java.util.List;

import com.epam.training.homework.gk.bank.ServiceSuperClass;
import com.epam.training.homework.gk.bank.Services;
import com.epam.training.homework.gk.bank.datastore.DataStore;

public class TransferServiceInMemory extends ServiceSuperClass implements TransferService {
	Transfer selfBuild;
	List<Transfer> transfers;

	public TransferServiceInMemory(DataStore dataStore) {
		this.transfers = dataStore.getTransfers();
	}

	public TransferServiceInMemory() {
	}

	@Override
	public Transfer getById(Long id) {
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

	@Override
	public TransferStrategy[] getAllStrategies() {
		return TransferStrategy.Strategies.values();
	}

	@Override
	public Transfer create(Services service) {
		this.selfBuild = new TransferDao(service);
		selfBuild.setId(getMaxId(transfers) + 1);
		transfers.add(selfBuild);
		return this.selfBuild;
	}

	@Override
	public Transfer create() {
		this.selfBuild = new TransferDao();
		selfBuild.setId(getMaxId(transfers) + 1);
		transfers.add(selfBuild);
		return this.selfBuild;
	}

	@Override
	public void doTransfer(Transfer transfer) {
		transfer.doTransfer();
	}

}
