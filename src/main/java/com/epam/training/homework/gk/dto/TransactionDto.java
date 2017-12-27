package com.epam.training.homework.gk.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.epam.training.homework.gk.bank.AccountInterface;

public class TransactionDto {
	protected int id;
	protected AccountInterface fromId;
	protected AccountInterface toId;
	protected String reason;
	protected BigDecimal value;
	protected BigDecimal interest;
	protected Date date;

}
