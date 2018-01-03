package com.epam.training.homework.gk.bank.transfer;

import java.math.BigDecimal;
import java.util.Date;

import com.epam.training.homework.gk.bank.Persist;
import com.epam.training.homework.gk.bank.Services;
import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.history.HistoryService;

public interface Transfer extends Persist {

	TransferStrategy getStrategy();

	Transfer setStrategy(TransferStrategy strategy);

	Services getService();

	Transfer setService(Services service);

	Account getFromAccount();

	Transfer setFrom(Account from);

	Account getToAccount();

	Transfer setTo(Account account);

	Transfer setReason(String reason);

	String getReason();

	BigDecimal getValue();

	Transfer setValue(BigDecimal value);

	BigDecimal getInterest();

	Transfer setInterest(BigDecimal interest);

	Date getDate();

	Transfer setDate(Date date);

	void doTransfer();

	Transfer build();

	String toString();

	Transfer setValue(double i);
	
	HistoryService getHistoryService();
	
	void setHistoryService(HistoryService historyService);


}