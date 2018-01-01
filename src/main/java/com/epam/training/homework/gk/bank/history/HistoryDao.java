package com.epam.training.homework.gk.bank.history;

import java.math.BigDecimal;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.transfer.Transfer;


public class HistoryDao implements History {

	private Long  id;
	private BigDecimal balance;
	private Transfer transfer;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public HistoryDao(Transfer transfer, BigDecimal balance) {
		this.transfer = transfer;
		this.balance = balance;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n");
		builder.append("HistoryDao [id=");
		builder.append(id);
		builder.append(", balance=");
		builder.append(balance);
		builder.append(", transfer=");
		builder.append(transfer);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public BigDecimal getBalance() {
		return balance;
	}

	@Override
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public void setActive(boolean b) {

	}


	@Override
	public Account getToAccount() {
		return this.transfer.getTo();
	}

	@Override
	public Account getFromAccount() {
		return this.transfer.getFromAccount();
	}

}
