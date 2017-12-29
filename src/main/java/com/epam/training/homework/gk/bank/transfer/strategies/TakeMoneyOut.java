package com.epam.training.homework.gk.bank.transfer.strategies;

import com.epam.training.homework.gk.bank.services.Services;
import com.epam.training.homework.gk.bank.transfer.TransferDao;
import com.epam.training.homework.gk.bank.transfer.TransferStrategy;

public class TakeMoneyOut implements TransferStrategy {

	@Override
	public void doTransfer(TransferDao dao, Services service) {
		dao.setValue(dao.getValue().negate());
		dao.getFromAccount().change(dao);
	}

}
