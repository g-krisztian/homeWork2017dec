package com.epam.training.homework.gk.bank.transfer;

import java.math.BigDecimal;
import java.util.List;

import com.epam.training.homework.gk.bank.Services;
import com.epam.training.homework.gk.bank.account.Account;

public interface TransferService {

	Transfer create(Services service);
	
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

	TransferStrategy[] getAllStrategies();
	
	List<Transfer> getWhere(Account account);

	List<Transfer> getWhereFrom(Account account);

	List<Transfer> getWhereTo(Account account);

}
