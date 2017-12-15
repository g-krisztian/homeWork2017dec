package com.epam.training.homework.gk.bussiness;

import java.math.BigDecimal;
import java.util.Date;

public interface User {

	void putMoney(BigDecimal value);

	void takeOutMoney(BigDecimal value);

	void sendGift(BigDecimal value, User user);

	void lentToBank(BigDecimal value, Date days);

	BigDecimal borrowFromBank(BigDecimal value);

	BigDecimal getBalance();

	
}
