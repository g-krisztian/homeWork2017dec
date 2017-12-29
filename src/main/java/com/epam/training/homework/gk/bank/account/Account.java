package com.epam.training.homework.gk.bank.account;

import java.math.BigDecimal;

import com.epam.training.homework.gk.bank.account.history.HistoryDao;
import com.epam.training.homework.gk.bank.services.Persist;
import com.epam.training.homework.gk.bank.transfer.TransferDao;

public interface Account extends Persist {

	void change(TransferDao dao);

	BigDecimal getBalance();

	HistoryDao[] getHistory();

	void setActive(boolean b);
}
