package com.epam.training.homework.gk.bank.services;

public class Services {
	UserService userService;
	AccountService accountService;
	TransacionService transactionService;

	public Services() {

	}

	public Services(UserService userService, AccountService accountService, TransacionService transacionService) {
		super();
		this.userService = userService;
		this.accountService = accountService;
		this.transactionService = transactionService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public TransacionService getTransactionService() {
		return transactionService;
	}

	public void setTransactionService(TransacionService transactionService) {
		this.transactionService = transactionService;
	}

}
