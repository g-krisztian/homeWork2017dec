package com.epam.training.homework.gk.bank;

import com.epam.training.homework.gk.bank.account.AccountService;
import com.epam.training.homework.gk.bank.transfer.TransferService;
import com.epam.training.homework.gk.bank.user.UserService;

public class Services {
	AccountService accountService;
	UserService userService;
	TransferService transferService;


	public Services() {

	}

	public Services(UserService userService, AccountService accountService, TransferService transferService) {
		this.userService = userService;
		this.accountService = accountService;
		this.transferService = transferService;

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
}
