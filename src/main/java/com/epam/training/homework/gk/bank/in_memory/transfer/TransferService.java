package com.epam.training.homework.gk.bank.in_memory.transfer;

import java.math.BigDecimal;

import com.epam.training.homework.gk.bank.in_memory.account.Account;
import com.epam.training.homework.gk.bank.in_memory.transfer.strategies.TransferStrategy;

public interface TransferService {

	Transfer create();

	Transfer getById(Long id);

	Transfer[] getAll();
	
	Transfer build();

	Transfer setFrom(Account from);

	Transfer setId(Long id);

	Transfer setInterest(BigDecimal interest);

	Transfer setReason(String reason);

	Transfer setTo(Account to);

	Transfer setValue(BigDecimal value);

	Transfer setStrategy(TransferStrategy strategy);

}
