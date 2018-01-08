package com.epam.training.homework.gk.bank.facade;

import java.util.List;

import com.epam.training.homework.gk.bank.Services;
import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.transfer.Transfer;
import com.epam.training.homework.gk.bank.transfer.TransferStrategy;
import com.epam.training.homework.gk.bank.user.User;

public class BankFacade implements Facade {

	Services service;

	BankFacade(Services service) {
		super();
		this.service = service;

	}

	@Override
	public User addUser(String name) {
		return service.getUserService().create(name);
	}

	@Override
	public User getUserById(Long id) {
		return service.getUserService().getById(id);
	}

	@Override
	public void deleteUser(User user) {
		service.getUserService().delete(user);

	}

	@Override
	public List<User> listAllUsers() {
		return service.getUserService().getAll();
	}

	@Override
	public User getBank() {
		return service.getUserService().getBank();
	}

	@Override
	public Account addAccountToUser(User user) {
		Account account = service.getAccountService().create();
		service.getUserService().addAccountToUser(account, user);
		return account;
	}

	@Override
	public Account addBankAccount() {
		return addAccountToUser(service.getUserService().getBank());
	}

	@Override
	public Account getAccountById(Long id) {
		return service.getAccountService().getById(id);
	}

	@Override
	public void removeAccount(Account account) {
		service.getAccountService().delete(account);
	}

	@Override
	public List<Account> listUserAccounts(User user) {
		return service.getUserService().getAccounts(user);
	}

	@Override
	public TransferStrategy[] listAllStrategies() {
		return service.getTransferService().getAllStrategies();
	}

	@Override
	public Transfer addTransferToAccount(Account account) {
		Transfer transfer = service.getTransferService().create(service);
		service.getAccountService().addTransferToAccount(transfer, account);
		return transfer;
	}

	@Override
	public void doTransfer(Transfer transfer) {
		service.getTransferService().doTransfer(transfer);
	}

	@Override
	public List<Transfer> listHistory(Account account) {
		return service.getAccountService().getHistoryFull(account);
	}

	@Override
	public List<Transfer> listHistoryFrom(Account account) {
		return service.getAccountService().getHistoryFrom(account);
	}

	@Override
	public List<Transfer> listHistoryTo(Account account) {
		return service.getAccountService().getHistoryTo(account);
	}
}
