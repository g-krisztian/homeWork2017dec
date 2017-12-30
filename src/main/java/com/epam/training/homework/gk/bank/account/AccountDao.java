package com.epam.training.homework.gk.bank.account;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.epam.training.homework.gk.bank.Persist;
import com.epam.training.homework.gk.bank.transfer.Transfer;

@Entity
public class AccountDao implements Account, Persist{

	@Id
	@GeneratedValue
	private int id;
	BigDecimal balance;
	@OneToMany
	boolean active;

	public AccountDao() {
		active = true;
		balance = new BigDecimal("0");
	}

	@Override
	public void change(Transfer dao) {
		BigDecimal balance = this.balance.add(dao.getValue());
		this.balance = balance;
	}

	@Override
	public BigDecimal getBalance() {
		return this.balance;
	}


	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	@Override
	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "\nAccountDao [id=" + id + ", balance=" + balance + ", active=" + active + "]";
	}
}
