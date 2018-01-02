package com.epam.training.homework.gk.bank.history;

import java.math.BigDecimal;

import com.epam.training.homework.gk.bank.Persist;
import com.epam.training.homework.gk.bank.account.Account;

public interface History extends Persist {

	Long getId();

	void setId(Long id);

	BigDecimal getBalance();

	void setBalance(BigDecimal balance);

	Account getFromAccount();

	Account getToAccount();
	
	@Override
	String toString();

}