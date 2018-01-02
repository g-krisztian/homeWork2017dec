package com.epam.training.homework.gk.bank.ui.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.facade.Facade;
import com.epam.training.homework.gk.bank.history.History;
import com.epam.training.homework.gk.bank.transfer.Transfer;
import com.epam.training.homework.gk.bank.transfer.TransferStrategy;
import com.epam.training.homework.gk.bank.ui.UserInterface;
import com.epam.training.homework.gk.bank.user.User;

public class CommandLineInterface implements UserInterface {

	StringBuilder prompt;

	private BufferedReader br;
	String command;

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

			userPrompt(users);

			command = br.readLine();

			if (command.equals("new")) {
				newUserPrompt();
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
		command = null;
		do {

			Account[] accounts = facade.listAllAccounts(user);

			accountSelectionPrompt(user, accounts);

			try {
				command = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (command.equals("new")) {
				facade.addAccount(user);
			} else {
				try {
					Account accountById = facade.getAccountById((Long.valueOf(command)));
					if (accountById != null) {
						historyOrTransactionMenu(accountById);
					}
				} catch (Exception e) {
				}
			}

		} while (!command.toLowerCase().equals("exit"));
	}

	private void historyOrTransactionMenu(Account account) {
		command = null;
		do {
			prompt.setLength(0);
			prompt.append("Selected account: ");
			prompt.append(account);
			prompt.append("\ntype 'history' to view account history, or 'transfer' to make a transfer");
			System.out.println(prompt);
			
			
			try {
				command = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (command.toLowerCase().equals("history")) {
				historyMenu(account);
			} else  if (command.toLowerCase().equals("transfer")){
				transactionMenu(account);
			}

		} while (!command.toLowerCase().equals("exit"));
	}

	private void transactionMenu(Account account) {
		command = null;
		do {

			TransferStrategy[] strategies = facade.listAllStrategies();

			transferSelectionPrompt(account, strategies);

			try {
				command = br.readLine();

			} catch (IOException e) {
				e.printStackTrace();
			}
			if (command.toLowerCase().equals("history")) {
				historyMenu(account);
			} else {
				try {
					Integer strategyId = Integer.valueOf(command);
					TransferStrategy strategy = strategies[strategyId];
					System.out.println(strategies[strategyId]);

					Transfer dao = facade.addTransfer();
					dao.setStrategy(strategy);

					strategies[strategyId].doTransfer(dao);
				} catch (Exception e) {
				}
			}
		} while (!command.toLowerCase().equals("exit"));

	}

	private void historyMenu(Account account) {
		command = null;

		do {
			History[] history = null;
			historyPrompt(account);
			try {
				command = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (command.toLowerCase().equals("full")) {
				history = facade.listHistory(account);
			} else if (command.toLowerCase().equals("to")) {
				history = facade.listHistoryTo(account);
			} else if (command.toLowerCase().equals("from")) {
				history = facade.listHistoryFrom(account);
			}
			if (history.length > 0) {
				System.out.println(history);
			} else {
				System.out.print("There is no history record for account\n");
			}

		} while (!command.toLowerCase().equals("exit"));

	}

	private void historyPrompt(Account account) {
		prompt.setLength(0);
		prompt.append("Selected account: ");
		prompt.append(account);
		prompt.append("\n");
		prompt.append("To full history type 'full'\n");
		prompt.append("To incoming history type 'to'\n");
		prompt.append("To outgoing history type 'from'\n");
		System.out.println(prompt);
	}

	private void userPrompt(User[] users) {
		prompt.setLength(0);
		prompt.append("Select user by Id, or type 'new' for create one: \n");
		for (User user : users) {
			prompt.append(user);
		}
		prompt.append("\ntype 'quit' for exit");
		System.out.println(prompt);
	}

	private void newUserPrompt() {
		prompt.setLength(0);
		prompt.append("Add name to user:");
		System.out.println(prompt);
	}

	private void accountSelectionPrompt(User user, Account[] accounts) {
		prompt.setLength(0);
		prompt.append("Selected user: ");
		prompt.append(user);
		prompt.append("\n\nSelect account by Id, or type 'new' for add a new one:");
		for (Account account : accounts) {
			prompt.append("\n");
			prompt.append(account);
		}
		prompt.append("\nor type 'exit' to select new user");

		System.out.println(prompt);
	}

	private void transferSelectionPrompt(Account account, TransferStrategy[] strategies) {
		prompt.setLength(0);
		prompt.append("Selected account: ");
		prompt.append(account);
		prompt.append("\nSelect an option by Id:");
		for (int i = 0; i < strategies.length; i++) {
			TransferStrategy str = strategies[i];
			prompt.append("\n");
			prompt.append("id: " + i + ": ");
			prompt.append(str);
		}
		// prompt.append("\ntype 'history' for get account history");
		prompt.append("\nor type 'exit' to select new account");

		System.out.println(prompt);
	}

}
