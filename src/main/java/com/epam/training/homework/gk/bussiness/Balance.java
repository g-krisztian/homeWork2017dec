package com.epam.training.homework.gk.bussiness;

import java.math.BigDecimal;
import java.util.List;

public interface Balance {
	void increase(BigDecimal value);

	void decrease(BigDecimal value);

	List<Balance> getHistory();

}
