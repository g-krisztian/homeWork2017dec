package com.epam.training.homework.gk.bussiness;

import java.math.BigDecimal;
import java.util.List;

public interface Balance {
	void increase(BigDecimal value, String reason);

	void decrease(BigDecimal value, String reason);

	List<Balance> getHistory();

}
