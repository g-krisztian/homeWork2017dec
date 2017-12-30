package com.epam.training.homework.gk.bank.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.epam.training.homework.gk.bank.account.Account;

@Entity
public class UserDao implements User {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@OneToMany
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
		this.accounts.add(account);
	}

	@Override
	public Account[] getAccounts() {
		return accounts.toArray(new Account[accounts.size()]);

	}

	@Override
	public int getId() {
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
	public void setId(int id) {
		this.id = id;

	}

	@Override
	public void setName(String name) {
		this.name = name;

	}

	@Override
	public String toString() {
		return "\nUserDao [id=" + id + ", name=" + name + ", active=" + active + ",\n accounts=" + accounts + "]";
	}

}