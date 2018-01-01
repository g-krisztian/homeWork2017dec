package com.epam.training.homework.gk.bank.in_memory.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.epam.training.homework.gk.bank.in_memory.account.Account;
import com.epam.training.homework.gk.bank.in_memory.account.AccountDaoPersist;

@Entity
public class UserDaoPersist implements User {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private boolean active;
	
	@OneToMany 
	@JoinColumn(name="id")
	private List<AccountDaoPersist> accounts;
	
	public UserDaoPersist() {
		accounts = new ArrayList<AccountDaoPersist>();
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
		this.accounts.add((AccountDaoPersist) account);
	}

	@Override
	public Account[] getAccounts() {
		return accounts.toArray(new Account[accounts.size()]);

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
		return "\nUserDao [id=" + id + ", name=" + name + ", active=" + active + ",\n accounts=" + accounts + "]";
	}

}
