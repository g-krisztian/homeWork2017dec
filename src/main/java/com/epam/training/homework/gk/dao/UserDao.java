package com.epam.training.homework.gk.dao;

import com.epam.training.homework.gk.dto.UserDto;
import com.epam.training.homework.gk.interfaces.Account;
import com.epam.training.homework.gk.interfaces.User;

public class UserDao extends UserDto implements User {

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
	public void addAccount(Account account) {
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
