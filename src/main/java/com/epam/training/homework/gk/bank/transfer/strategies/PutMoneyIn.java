package com.epam.training.homework.gk.bank.transfer.strategies;

import com.epam.training.homework.gk.bank.application.Services;
import com.epam.training.homework.gk.bank.transfer.Transfer;

public class PutMoneyIn implements TransferStrategy {

	@Override
	public void doTransfer(Transfer dao, Services service) {
		dao.getToAccount().change(dao);
	}

	@Override
	public String toString() {
		return "PutMoneyIn";
	}

}
