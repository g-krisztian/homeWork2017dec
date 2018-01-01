package com.epam.training.homework.gk.bank.in_memory;

import java.util.List;

public class ServiceSuperClass {

	protected Long getMaxId(List<? extends Persist> lst) {
		Long max = 0L;
		for (Persist p : lst) {
			if (max < p.getId()) {
				max = p.getId();
			}
		}
		return max;
	}


}