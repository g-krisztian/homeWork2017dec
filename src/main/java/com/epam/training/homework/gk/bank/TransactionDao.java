package com.epam.training.homework.gk.bank;

import java.math.BigDecimal;
import java.util.Date;

public interface TransactionDao {
	void setAccountFrom(BankAccount from);
	void setAccountTo(BankAccount to);
	void setReason(String reason);
	void setValue(BigDecimal value);
	BigDecimal getValue();
	void setDate(Date date);
	
	@Override
	String toString();
}
