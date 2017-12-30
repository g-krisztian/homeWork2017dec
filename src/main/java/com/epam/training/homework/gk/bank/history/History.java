package com.epam.training.homework.gk.bank.history;

import java.math.BigDecimal;

import com.epam.training.homework.gk.bank.Persist;
import com.epam.training.homework.gk.bank.transfer.Transfer;

public interface History extends Persist{

	int getId();

	void setId(int id);

	String toString();

	BigDecimal getBalance();

	void setBalance(BigDecimal balance);

	Transfer getDao();

	void setDao(Transfer dao);

}