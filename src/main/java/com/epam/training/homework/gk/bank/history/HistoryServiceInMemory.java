package com.epam.training.homework.gk.bank.history;

import java.util.ArrayList;
import java.util.List;

import com.epam.training.homework.gk.bank.ServiceSuperClass;
import com.epam.training.homework.gk.bank.account.Account;

public class HistoryServiceInMemory extends ServiceSuperClass implements HistoryService{
	List<HistoryDao> history = new ArrayList<>();
	
	@Override
	public History[] getWhere(Account account) {
		List<HistoryDao> toReturn = new ArrayList<>();
		for (HistoryDao historyDao : history) {
			if ((historyDao.getDao().getFromAccount() == account) || (historyDao.getDao().getToAccount() == account)) {
				toReturn.add(historyDao);
			}
		}
		return toReturn.toArray(new HistoryDao[toReturn.size()]);
	}

	@Override
	public History[] getWhereFrom(Account account) {
		List<HistoryDao> toReturn = new ArrayList<>();
		for (HistoryDao historyDao : history) {
			if (historyDao.getDao().getFromAccount() == account) {
				toReturn.add(historyDao);
			}
		}
		return toReturn.toArray(new HistoryDao[toReturn.size()]);
	}

	@Override
	public History[] getWhereTo(Account account) {
		List<HistoryDao> toReturn = new ArrayList<>();
		for (HistoryDao historyDao : history) {
			if (historyDao.getDao().getToAccount() == account) {
				toReturn.add(historyDao);
			}
		}
		return toReturn.toArray(new HistoryDao[toReturn.size()]);
	}
}
