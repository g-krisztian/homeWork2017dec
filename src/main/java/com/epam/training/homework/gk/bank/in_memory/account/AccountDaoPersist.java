package com.epam.training.homework.gk.bank.in_memory.account;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.epam.training.homework.gk.bank.in_memory.Persist;
import com.epam.training.homework.gk.bank.in_memory.transfer.Transfer;

@Entity
public class AccountDaoPersist implements Account, Persist {

	@Id
	@GeneratedValue
	private Long id;
	BigDecimal balance;
	boolean active;

	public AccountDaoPersist() {
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
	public Long  getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
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
