package com.epam.training.homework.gk.bank;

import java.math.BigDecimal;
import java.util.Date;

public interface Transaction {
	void setAccountFrom(BankAccount from);

	void setAccountTo(BankAccount to);

	void setReason(String reason);

	void setValue(BigDecimal value);

	BigDecimal getValue();
	
	void setInterest(double interest);

	void setDate(Date date);
	
	

	@Override
	String toString();

	double getInterest();

}
