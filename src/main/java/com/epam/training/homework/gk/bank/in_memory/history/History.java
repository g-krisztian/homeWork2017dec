package com.epam.training.homework.gk.bank.in_memory.history;

import java.math.BigDecimal;

import com.epam.training.homework.gk.bank.in_memory.Persist;
import com.epam.training.homework.gk.bank.in_memory.account.Account;

public interface History extends Persist{

	Long getId();

	void setId(Long id);

	String toString();

	BigDecimal getBalance();

	void setBalance(BigDecimal balance);

	Account getFromAccount();

	Account getToAccount();

}