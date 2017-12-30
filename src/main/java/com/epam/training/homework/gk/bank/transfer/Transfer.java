package com.epam.training.homework.gk.bank.transfer;

import java.math.BigDecimal;
import java.util.Date;

import com.epam.training.homework.gk.bank.Persist;
import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.application.Services;
import com.epam.training.homework.gk.bank.history.History;
import com.epam.training.homework.gk.bank.transfer.strategies.TransferStrategy;

public interface Transfer extends Persist {

	Date getDate();

	TransferStrategy getStrategy();

	void setStrategy(TransferStrategy strategy);

	Services getService();

	void setService(Services service);

	Account getFromAccount();

	BigDecimal getInterest();

	String getReason();

	Account getToAccount();

	BigDecimal getValue();

	void setDate(Date date);

	void setFromAccount(Account from);

	void setInterest(BigDecimal interest);

	void setReason(String reason);

	void setToAccount(Account to);

	void setValue(BigDecimal value);
	
	History[] getHistory(Account account);

	void doTransfer();

	String toString();

}