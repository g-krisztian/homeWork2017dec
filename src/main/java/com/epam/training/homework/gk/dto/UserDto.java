package com.epam.training.homework.gk.dto;
import java.util.List;

import com.epam.training.homework.gk.interfaces.AccountInterface;


public abstract class UserDto {
	
	protected int id;
	protected String name;
	protected List<AccountInterface> accounts;

}
