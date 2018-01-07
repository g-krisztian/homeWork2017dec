package com.epam.training.homework.gk.bank.account.transfer;

import java.util.List;

import com.epam.training.homework.gk.bank.ServiceSuperClass;
import com.epam.training.homework.gk.bank.Services;
import com.epam.training.homework.gk.bank.account.Account;
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
	public List<Transfer> getAll() {
		return transfers;
	}

	@Override
	public TransferStrategy[] getAllStrategies() {
		return Strategies.values();
	}

	@Override
	public Transfer create(Services service) {
		this.selfBuild = new TransferDao(service);
		selfBuild.setId(getMaxId(transfers) + 1);
		transfers.add(selfBuild);
		return this.selfBuild;
	}

	@Override
	public void doTransfer(Transfer transfer) {
		TransferStrategy strategy = transfer.getStrategy();
		List<Change> changes = strategy.doTransfer(transfer);
		System.out.println("changes: " + changes);
		for (Change change : changes) {
			System.out.println("change: " + change);
			doIt(change.getAccount(), change.getTransfer());
		}
		System.out.println("\nmost elhagyom\n");
	}

	public void doIt(Account account, Transfer transfer) {
		System.out.println("\nmost vagyok a TransfeServiceben!!!\n");
		account.change(transfer);
		transfer.setBalance(account.getBalance());
	}

}
