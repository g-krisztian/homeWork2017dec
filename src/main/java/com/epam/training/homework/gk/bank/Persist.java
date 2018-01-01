package com.epam.training.homework.gk.bank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


public interface Persist {

	Long getId();

	void setId(Long id);

	void setActive(boolean b);

}
