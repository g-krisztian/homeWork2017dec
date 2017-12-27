package com.epam.training.homework.gk.interfaces;

import java.math.BigDecimal;
import java.util.List;

import com.epam.training.homework.gk.dto.HistoryDto;

public interface Account {
	
	void setId(int id);
	
	int getId(int id);
	
	void change(Transaction transactionData);

	HistoryDto[] getHistory();
	
	BigDecimal getBalance();
}
