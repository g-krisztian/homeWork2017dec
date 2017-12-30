package com.epam.training.homework.gk.bank;

import java.util.List;

public class ServiceSuperClass {

	protected int getMaxId(List<? extends Persist> lst) {
		int max = 0;
		for (Persist p : lst) {
			if (max < p.getId()) {
				max = p.getId();
			}
		}
		return max;
	}


}