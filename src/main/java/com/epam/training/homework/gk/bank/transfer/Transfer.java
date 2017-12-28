package com.epam.training.homework.gk.bank.transfer;

import java.math.BigDecimal;
import java.util.Date;

public interface Transfer {

	void setId(int id);

	int getId();

	int getFromAccountId();

	void setFromAccountId(int from);

	int getToAccountId();

	void setToAccountId(int to);

	String getReason();

	void setReason(String reason);

	void setValue(BigDecimal value);

	BigDecimal getValue();

	void setInterest(BigDecimal interest);

	BigDecimal getInterest();

	Date getDate();

	void setDate(Date date);

	@Override
	String toString();

}
