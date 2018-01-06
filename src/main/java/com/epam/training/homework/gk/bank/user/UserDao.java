package com.epam.training.homework.gk.bank.user;

import java.util.ArrayList;
import java.util.List;

import com.epam.training.homework.gk.bank.Persist;
import com.epam.training.homework.gk.bank.account.Account;


public class UserDao implements User,Persist {

	private Long id;
	private String name;

	private List<Account> accounts;
	private boolean active;
	
	public UserDao() {
		accounts = new ArrayList<Account>();
		active = true;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public void addNewAccount(Account account) {
		System.out.println(this.accounts);
		this.accounts.add(account);
	}

	@Override
	public List<Account> getAccounts() {
		return accounts;

	}

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void removeAccount(Account account) {
		this.accounts.remove(account);
	}

	@Override
	public void setId(Long id) {
		this.id = id;

	}

	@Override
	public void setName(String name) {
		this.name = name;

	}

	@Override
	public String toString() {
		return "\nUser "+ name+ ": [id=" + id + ", active=" + active +  "]";
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

}
