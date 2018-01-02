package com.epam.training.homework.gk.bank.ui.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.facade.Facade;
import com.epam.training.homework.gk.bank.history.History;
import com.epam.training.homework.gk.bank.ui.UserInterface;
import com.epam.training.homework.gk.bank.user.User;

public class CommandLineInterface implements UserInterface {

	StringBuilder prompt;
	User user;
	Account account;
	History history;
	String command;
	private BufferedReader br;

	Facade facade;

	public CommandLineInterface(Facade facade) {
		this.facade = facade;
		br = new BufferedReader(new InputStreamReader(System.in));
		prompt = new StringBuilder();
	}

	@Override
	public void start() {

		do {
			userSelectionMenu();
		} while (!command.toLowerCase().equals("quit"));
	}

	private void userSelectionMenu() {
		try {
			User[] users = facade.listAllUsers();

			prompt.setLength(0);
			prompt.append("Select user by Id, or type 'new' for create one: \n");
			for (User user : users) {
				prompt.append(user);
			}
			prompt.append("\ntype 'quit' for exit");
			

			System.out.println(prompt);
			command = br.readLine();

			if (command.equals("new")) {
				prompt.setLength(0);
				prompt.append("Add name to user:");
				System.out.println(prompt);
				String name = br.readLine();
				facade.addUser(name);
			} else {
				try {
					User userById = facade.getUserById(Long.valueOf(command));
					if (userById != null) {
						accountSelectionMenu(userById);
					}
				} catch (Exception e) {
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void accountSelectionMenu(User user) {
		do {
			Account[] accounts = facade.listAllAccounts(user);

			prompt.setLength(0);
			prompt.append("Selected user: ");
			prompt.append(user);
			prompt.append("\nSelect account by Id, or type 'new' for add a new one:");
			for (Account account : accounts) {
				prompt.append("\n");
				prompt.append(account);
			}
			prompt.append("\nor type 'exit' to select new user");

			System.out.println(prompt);

			try {
				command = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (command.equals("new")) {
				prompt.setLength(0);
				facade.addAccount(user);
			} else {
				try {
					Account accountById = facade.getAccountById((Long.valueOf(command)));
					if (accountById != null) {
						transactionMenu(accountById);
					}
				} catch (Exception e) {
				}
			}

		} while (!command.toLowerCase().equals("exit"));
	}

	private void transactionMenu(Account account) {
		System.out.println("transaction level reached");
		

	}

}
