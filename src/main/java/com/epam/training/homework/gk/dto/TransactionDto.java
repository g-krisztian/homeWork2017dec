package com.epam.training.homework.gk.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.epam.training.homework.gk.interfaces.Account;

public class TransactionDto {
	protected int id;
	protected Account fromId;
	protected Account toId;
	protected String reason;
	protected BigDecimal value;
	protected BigDecimal interest;
	protected Date date;

}
