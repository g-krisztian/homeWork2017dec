package com.epam.training.homework.gk.bank;

import com.epam.training.homework.gk.bank.user.User;

public interface UserService {

	User createUser(String name);

	User getUserById(int id);

	User[] getAllUsers();

	void deleteUserById(int id);

}