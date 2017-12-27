package com.epam.training.homework.gk.dto;
import java.util.List;

import com.epam.training.homework.gk.interfaces.Account;


public abstract class UserDto {
	
	protected int id;
	protected String name;
	protected List<Account> accounts;

}
