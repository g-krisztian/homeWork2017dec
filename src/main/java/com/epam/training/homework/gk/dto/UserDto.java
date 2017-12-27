package com.epam.training.homework.gk.dto;
import java.util.List;

import com.epam.training.homework.gk.bank.AccountInterface;

public abstract class UserDto {
	
	int id;
	String name;
	List<AccountInterface> accounts;

}
