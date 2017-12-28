package com.epam.training.homework.gk.bank.user.customer;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.user.User;

@Entity
public class Customer implements User {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@OneToMany
	private List<Account> accounts;

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void setId(int id) {
		this.id = id;

	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;

	}

	@Override
	public void addNewAccount(Account account) {
		this.accounts.add(account);
	}

	@Override
	public void removeAccount(Account account) {
		this.accounts.remove(account);

	}

	@Override
	public Account[] getAccounts() {
		return (Account[]) accounts.toArray(new Account[accounts.size()]);

	}

}
