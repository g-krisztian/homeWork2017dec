package com.epam.training.homework.gk.bank.in_memory.account;

import java.math.BigDecimal;

import com.epam.training.homework.gk.bank.in_memory.Persist;
import com.epam.training.homework.gk.bank.in_memory.transfer.Transfer;

public interface Account extends Persist {

	
	void change(Transfer dao);

	BigDecimal getBalance();

	void setActive(boolean b);

	@Override
	String toString();
}
