package com.epam.training.homework.gk.bank.account;

import java.math.BigDecimal;

import com.epam.training.homework.gk.bank.Persist;
import com.epam.training.homework.gk.bank.transfer.Transfer;

public class AccountDao implements Account, Persist {

	private Long id;
	BigDecimal balance;
	BigDecimal interest;
	boolean active;

	public AccountDao() {
		active = true;
		balance = new BigDecimal("0");
		interest = BigDecimal.ZERO;
	}

	@Override
	public void change(Transfer dao) {
		BigDecimal balance = this.balance.add(dao.getValue());
		this.balance = balance;
	}

	@Override
	public BigDecimal getBalance() {
		return this.balance;
	}

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
    @Override
	public boolean isActive() {
		return active;
	}

	@Override
	public void setActive(boolean active) {
		this.active = active;
	}
    @Override
	public BigDecimal getInterest() {
		return interest;
	}
    @Override
	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nAccount [id=");
		builder.append(id);
		builder.append(", balance=");
		builder.append(balance);
		builder.append(", interest=");
		builder.append(interest);
		builder.append(", active=");
		builder.append(active);
		builder.append("]");
		return builder.toString();
	}
    @Override
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	
	
}
