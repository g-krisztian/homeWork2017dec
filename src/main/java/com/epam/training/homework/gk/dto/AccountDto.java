package com.epam.training.homework.gk.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.epam.training.homework.gk.bank.HistoryJdo;

public class AccountDto {
	protected int id;
	protected List<HistoryJdo> history = new ArrayList<>();
	protected BigDecimal balance;
}
