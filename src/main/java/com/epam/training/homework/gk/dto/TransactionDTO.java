package com.epam.training.homework.gk.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.epam.training.homework.gk.bank.BankAccount;

public class TransactionDTO {
	
	protected BankAccount from;
	protected BankAccount to;
	protected String reason;
	protected BigDecimal value;
	protected double interest;
	protected Date date;

}
