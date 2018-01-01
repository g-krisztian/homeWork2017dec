package com.epam.training.homework.gk.bank.in_memory.transfer.strategies;

import java.math.BigDecimal;

import com.epam.training.homework.gk.bank.in_memory.Services;
import com.epam.training.homework.gk.bank.in_memory.history.History;
import com.epam.training.homework.gk.bank.in_memory.transfer.Transfer;

public class PutMoneyIn implements TransferStrategy {

	@Override
	public void doTransfer(Transfer dao, Services service) {
		dao.getTo().change(dao);
		BigDecimal balance=dao.getTo().getBalance();
		History history = service.getHistoryService().create(dao, balance);
		service.getHistoryService().store(history);
	}

	@Override
	public String toString() {
		return "PutMoneyIn";
	}

}
