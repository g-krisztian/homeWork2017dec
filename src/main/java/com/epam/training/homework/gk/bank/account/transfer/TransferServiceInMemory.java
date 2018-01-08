package com.epam.training.homework.gk.bank.account.transfer;

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
	public void doTransfer(Transfer transfer) {
		TransferStrategy strategy = transfer.getStrategy();
		List<Change> changes = strategy.getChanges(transfer);
		System.out.println("changes: " + changes);
		for (Change change : changes) {
			System.out.println("change: " + change);
			doIt(change);
		}
		System.out.println("\nmost elhagyom\n");
	}

	public Change doIt(Change change) {
		System.out.println("\nmost vagyok a TransfeServiceben!!!\n");
		Transfer transfer= change.getTransfer();
		Account account = change.getAccount();
		System.out.println("Doit: "+transfer);
		System.out.println("Doit: "+account);
		account.change(transfer);
		transfer.setBalance(account.getBalance());
		System.out.println("Doit: "+transfer);
		System.out.println("Doit: "+account);
		return change;
	}

}
