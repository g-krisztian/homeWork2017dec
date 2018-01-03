package com.epam.training.homework.gk.bank.account;

import java.math.BigDecimal;

import com.epam.training.homework.gk.bank.Persist;
import com.epam.training.homework.gk.bank.transfer.Transfer;

public interface Account extends Persist {

    void change(Transfer dao);

	BigDecimal getBalance();

	void setActive(boolean b);

	@Override
	String toString();

    BigDecimal getInterest();



    boolean isActive();

    void setBalance(BigDecimal balance);

    void setInterest(BigDecimal interest);

}
