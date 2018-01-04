package com.epam.training.homework.gk.bank.transfer;

import java.math.BigDecimal;
import java.util.ArrayList;
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
	public Transfer[] getAll() {
		return transfers.toArray(new Transfer[transfers.size()]);
	}

	@Override
	public Transfer build() {
		return selfBuild;
	}

	@Override
	public Transfer setFrom(Account from) {
		selfBuild.setFrom(from);
		return selfBuild;
	}

	@Override
	public Transfer setId(Long id) {
		selfBuild.setId(id);
		return selfBuild;
	}

	@Override
	public Transfer setInterest(BigDecimal interest) {
		selfBuild.setInterest(interest);
		return selfBuild;
	}

	@Override
	public Transfer setReason(String reason) {
		selfBuild.setReason(reason);
		return selfBuild;
	}

	@Override
	public Transfer setTo(Account to) {
		selfBuild.setTo(to);
		return selfBuild;
	}

	@Override
	public Transfer setValue(BigDecimal value) {
		selfBuild.setValue(value);
		return selfBuild;
	}

	@Override
	public Transfer setStrategy(TransferStrategy strategy) {
		selfBuild.setStrategy(strategy);
		return selfBuild;
	}
	
	@Override
	public TransferStrategy[] getAllStrategies() {
		return TransferStrategy.Strategies.values();
	}

	@Override
	public Transfer create(Services service) {
		this.selfBuild = new TransferDao(service);
		selfBuild.setId(getMaxId(transfers)+1);
		transfers.add(selfBuild);
		return this.selfBuild;
	}

	@Override
	public Transfer create() {
		this.selfBuild = new TransferDao();
		selfBuild.setId(getMaxId(transfers)+1);
		transfers.add(selfBuild);
		return this.selfBuild;
	}

	@Override
	public List<Transfer> getWhere(Account account) {
		List<Transfer> history = new ArrayList<>();
		for (Transfer transfer : this.transfers) {
			if ((transfer.getFromAccount()==account)||(transfer.getToAccount()==account)) {
				history.add(transfer);
			}
		}
		return history;
	}

	@Override
	public List<Transfer> getWhereFrom(Account account) {
		List<Transfer> history = new ArrayList<>();
		for (Transfer transfer : this.transfers) {
			if (transfer.getFromAccount()==account) {
				history.add(transfer);
			}
		}
		return history;
	}

	@Override
	public List<Transfer> getWhereTo(Account account) {
		List<Transfer> history = new ArrayList<>();
		for (Transfer transfer : this.transfers) {
			if (transfer.getToAccount()==account) {
				history.add(transfer);
			}
		}
		return history;
	}

	
	
}
