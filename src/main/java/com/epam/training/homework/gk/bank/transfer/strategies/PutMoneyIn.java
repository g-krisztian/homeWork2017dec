package com.epam.training.homework.gk.bank.transfer.strategies;

import java.math.BigDecimal;

import com.epam.training.homework.gk.bank.history.History;
import com.epam.training.homework.gk.bank.transfer.Transfer;

public class PutMoneyIn implements TransferStrategy {

	@Override
	public void doTransfer(Transfer dao) {
		dao.getTo().change(dao);
		BigDecimal balance=dao.getTo().getBalance();
		History history = dao.getHistoryService().create(dao, balance);
		dao.getHistoryService().store(history);
	}

	@Override
	public String toString() {
		return "PutMoneyIn";
	}

}
