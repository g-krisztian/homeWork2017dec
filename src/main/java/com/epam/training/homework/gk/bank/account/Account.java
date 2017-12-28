package com.epam.training.homework.gk.bank.account;

import java.math.BigDecimal;

import com.epam.training.homework.gk.bank.account.history.HistoryDao;
import com.epam.training.homework.gk.bank.transfer.Transfer;

public interface Account {

	void setId(int id);

	int getId();

	HistoryDao[] getHistory();

	BigDecimal getBalance();

	void change(Transfer transaction);
}
