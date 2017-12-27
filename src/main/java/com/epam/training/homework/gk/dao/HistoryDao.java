package com.epam.training.homework.gk.dao;

import java.math.BigDecimal;

import com.epam.training.homework.gk.dto.HistoryDto;
import com.epam.training.homework.gk.interfaces.TransactionInterface;

public class HistoryDao extends HistoryDto{

	public HistoryDao(TransactionInterface transactionDao, BigDecimal balance) {
		this.transactionDao= transactionDao;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "HistoryJdo [transactionDao=" + transactionDao + ", balance=" + balance + "]";
	}
	
	
}
