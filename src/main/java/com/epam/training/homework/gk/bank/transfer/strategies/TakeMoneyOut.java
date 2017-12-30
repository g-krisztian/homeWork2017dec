package com.epam.training.homework.gk.bank.transfer.strategies;

import java.math.BigDecimal;

import com.epam.training.homework.gk.bank.Services;
import com.epam.training.homework.gk.bank.history.History;
import com.epam.training.homework.gk.bank.transfer.Transfer;

public class TakeMoneyOut implements TransferStrategy {

	@Override
	public void doTransfer(Transfer dao, Services service) {
		dao.setValue(dao.getValue().negate());
		dao.getFromAccount().change(dao);
		BigDecimal balance = dao.getFromAccount().getBalance();
		History history = service.getHistoryService().create(dao, balance);
		service.getHistoryService().store(history);
		
		
	}

	@Override
	public String toString() {
		return "TakeMoneyOut";
	}

}
