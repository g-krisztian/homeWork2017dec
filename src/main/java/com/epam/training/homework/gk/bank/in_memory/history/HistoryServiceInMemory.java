package com.epam.training.homework.gk.bank.in_memory.history;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.epam.training.homework.gk.bank.in_memory.ServiceSuperClass;
import com.epam.training.homework.gk.bank.in_memory.account.Account;
import com.epam.training.homework.gk.bank.in_memory.datastore.DataStore;
import com.epam.training.homework.gk.bank.in_memory.transfer.Transfer;

public class HistoryServiceInMemory extends ServiceSuperClass implements HistoryService {
	List<History> history;
	
	public HistoryServiceInMemory(DataStore datastore) {
		this.history = datastore.getHistory();
	}
	
	@Override
	public History[] getWhere(Account account) {
		List<History> toReturn = new ArrayList<>();
		for (History h : history) {
			if ((h.getFromAccount() == account) || (h.getToAccount() == account)) {
				toReturn.add(h);
			}
		}
		return toReturn.toArray(new History[toReturn.size()]);
	}

	@Override
	public History[] getWhereFrom(Account account) {
		List<History> toReturn = new ArrayList<>();
		for (History h : history) {
			if (h.getFromAccount() == account) {
				toReturn.add(h);
			}
		}
		return toReturn.toArray(new History[toReturn.size()]);
	}

	@Override
	public History[] getWhereTo(Account account) {
		List<History> toReturn = new ArrayList<>();
		for (History h : history) {
			if (h.getToAccount() == account) {
				toReturn.add(h);
			}
		}
		return toReturn.toArray(new History[toReturn.size()]);
	}

	@Override
	public void store(History history) {
		this.history.add(history);
	}

	@Override
	public History create(Transfer transfer, BigDecimal balance) {
		History h = new HistoryDao(transfer, balance);
		h.setId(getMaxId(this.history) + 1);
		return h;
	}
}
