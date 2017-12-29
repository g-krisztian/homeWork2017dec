package com.epam.training.homework.gk.bank.services;

public class Services {
	AccountService accountService;
	UserService userService;

	public Services() {

	}

	public Services(UserService userService, AccountService accountService) {
		this.userService = userService;
		this.accountService = accountService;
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

}
