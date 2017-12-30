package com.epam.training.homework.gk.bank.transfer;

import java.math.BigDecimal;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.transfer.strategies.TransferStrategy;

public interface TransferService {

	Transfer create();

	Transfer getById(int id);

	Transfer[] getAll();
	
	Transfer build();

	Transfer setFrom(Account from);

	Transfer setId(int id);

	Transfer setInterest(BigDecimal interest);

	Transfer setReason(String reason);

	Transfer setTo(Account to);

	Transfer setValue(BigDecimal value);

	Transfer setStrategy(TransferStrategy strategy);

}
