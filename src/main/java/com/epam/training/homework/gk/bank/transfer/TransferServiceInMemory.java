package com.epam.training.homework.gk.bank.transfer;

import java.util.List;

import com.epam.training.homework.gk.bank.ServiceSuperClass;
import com.epam.training.homework.gk.bank.Services;
import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.datastore.DataStore;

public class TransferServiceInMemory extends ServiceSuperClass implements TransferService {

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
	public List<Transfer> getAll() {
		return transfers;
	}

	@Override
	public TransferStrategy[] getAllStrategies() {
		return Strategies.values();
	}

	@Override
	public Transfer create(Services service) {
		Transfer transfer = new TransferDao(service);
		transfer.setId(getMaxId(transfers) + 1);
		transfers.add(transfer);
		return transfer;
	}

	@Override
	public List<Change> doTransfer(Transfer transfer) {
		TransferStrategy strategy = transfer.getStrategy();
		List<Change> changes = strategy.getChanges(transfer);
		for (Change change : changes) {
			System.out.println("change: " + change);
			doIt(change);
		}
		return changes;
	}

	public void doIt(Change change) {

		Transfer transfer= change.getTransfer();
		Account account = change.getAccount();
		account.change(transfer);
		transfer.setBalance(account.getBalance());
	}

}
