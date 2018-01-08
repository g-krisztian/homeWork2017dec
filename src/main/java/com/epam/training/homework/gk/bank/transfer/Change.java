package com.epam.training.homework.gk.bank.transfer;

import com.epam.training.homework.gk.bank.account.Account;

public class Change {
	private Account account;
	private Transfer transfer;

	public Change(Account account, Transfer transfer) {
		this.account = account;
		this.transfer = transfer;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Transfer getTransfer() {
		return transfer;
	}

	public void setTransfer(Transfer transfer) {
		this.transfer = transfer;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Change [account=");
		builder.append(account);
		builder.append(", transfer=");
		builder.append(transfer);
		builder.append("]");
		return builder.toString();
	}
}
