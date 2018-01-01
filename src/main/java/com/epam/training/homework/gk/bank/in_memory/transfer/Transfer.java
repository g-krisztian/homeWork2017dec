package com.epam.training.homework.gk.bank.in_memory.transfer;

import java.math.BigDecimal;
import java.util.Date;

import com.epam.training.homework.gk.bank.in_memory.Persist;
import com.epam.training.homework.gk.bank.in_memory.Services;
import com.epam.training.homework.gk.bank.in_memory.account.Account;
import com.epam.training.homework.gk.bank.in_memory.transfer.strategies.TransferStrategy;

public interface Transfer extends Persist {

	TransferStrategy getStrategy();

	Transfer setStrategy(TransferStrategy strategy);

	Services getService();

	Transfer setService(Services service);

	Account getFromAccount();

	Transfer setFrom(Account from);

	Account getTo();

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


}