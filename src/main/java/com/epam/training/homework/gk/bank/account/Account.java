package com.epam.training.homework.gk.bank.account;

import java.math.BigDecimal;
import java.util.List;

import com.epam.training.homework.gk.bank.Persist;
import com.epam.training.homework.gk.bank.transfer.Transfer;

public interface Account extends Persist {

	BigDecimal getBalance();

	void setActive(boolean b);

	@Override
	String toString();

    BigDecimal getInterest();

    public List<Transfer> getHistory();
    public void setHistory(List<Transfer> history);

    boolean isActive();

    void setBalance(BigDecimal balance);

    void setInterest(BigDecimal interest);
    
    void addTransfer(Transfer transfer);

	void change(Transfer dao);


}
