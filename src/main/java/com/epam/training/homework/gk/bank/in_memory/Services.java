package com.epam.training.homework.gk.bank.in_memory;

import com.epam.training.homework.gk.bank.in_memory.account.AccountService;
import com.epam.training.homework.gk.bank.in_memory.history.HistoryService;
import com.epam.training.homework.gk.bank.in_memory.transfer.TransferService;
import com.epam.training.homework.gk.bank.in_memory.user.UserService;

public class Services {
	AccountService accountService;
	UserService userService;
	TransferService transferService;
	HistoryService historyService;

	public Services() {

	}

	public Services(UserService userService, AccountService accountService, TransferService transferService, HistoryService historyService) {
		this.userService = userService;
		this.accountService = accountService;
		this.transferService = transferService;
		this.historyService = historyService;
	}

	public AccountService getAccountService() {
		return accountService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public TransferService getTransferService() {
		return transferService;
	}

	public void setTransferService(TransferService transferService) {
		this.transferService = transferService;
	}

	public HistoryService getHistoryService() {
		return historyService;
	}

	public void setHistoryService(HistoryService historyService) {
		this.historyService = historyService;
	}

}
