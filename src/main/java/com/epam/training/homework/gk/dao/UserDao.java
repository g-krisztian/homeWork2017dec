package com.epam.training.homework.gk.dao;

import com.epam.training.homework.gk.dto.UserDto;
import com.epam.training.homework.gk.interfaces.AccountInterface;
import com.epam.training.homework.gk.interfaces.UserInterface;

public class UserDao extends UserDto implements UserInterface {

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
	public void addAccount(AccountInterface account) {
		this.accounts.add(account);
	}

	@Override
	public void removeAccount(AccountInterface account) {
		this.accounts.remove(account);

	}

	@Override
	public AccountInterface[] getAccounts() {
		return (AccountInterface[]) accounts.toArray(new AccountInterface[accounts.size()]); 

	}

}
