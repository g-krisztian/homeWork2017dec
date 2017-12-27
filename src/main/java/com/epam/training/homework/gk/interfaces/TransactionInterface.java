package com.epam.training.homework.gk.interfaces;

import java.math.BigDecimal;
import java.util.Date;

public interface TransactionInterface {
	
	void setId(int id);
	
	int getId();
	
	void setAccountFromId(AccountInterface from);

	void setAccountToId(AccountInterface to);

	void setReason(String reason);

	void setValue(BigDecimal value);

	BigDecimal getValue();

	void setInterest(BigDecimal interest);

	BigDecimal getInterest();

	void setDate(Date date);

	@Override
	String toString();

}
