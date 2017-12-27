package com.epam.training.homework.gk.interfaces;

import java.math.BigDecimal;

import com.epam.training.homework.gk.dao.HistoryDao;

public interface Account {
	
	void setId(int id);
	
	int getId(int id);
	
	HistoryDao[] getHistory();
	
	BigDecimal getBalance();
}
