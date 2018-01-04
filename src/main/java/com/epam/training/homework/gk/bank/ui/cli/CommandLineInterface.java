package com.epam.training.homework.gk.bank.ui.cli;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.facade.Facade;
import com.epam.training.homework.gk.bank.history.History;
import com.epam.training.homework.gk.bank.transfer.Transfer;
import com.epam.training.homework.gk.bank.transfer.TransferStrategy;
import com.epam.training.homework.gk.bank.ui.UserInterface;
import com.epam.training.homework.gk.bank.user.User;

public class CommandLineInterface implements UserInterface {

	private StringBuilder prompt;

	private BufferedReader br;
	private String command;

	private Facade facade;

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

		User[] users = facade.listAllUsers();

		userPrompt(users);

		try {
			command = br.readLine();

			if (command.equals("new")) {
				createNewUser();
			} else {

				User userById = facade.getUserById(idFromCommand());
				if (userById != null) {
					accountSelectionMenu(userById);
				}
			}
		} catch (Exception e) {
		}

	}

	private Long idFromCommand() {
		Long ret = null;
		try {
			ret = Long.valueOf(command);
		} catch (NumberFormatException e) {
		}
		return ret;
	}

	private void createNewUser() {
		newUserPrompt();
		String name;
		try {
			name = br.readLine();
			facade.addUser(name);
		} catch (Exception e) {

		}
	}

	private void accountSelectionMenu(User user) {
		command = "";
		do {
			try {

				List<Account> accounts = facade.listUserAccounts(user);

				accountSelectionPrompt(accounts);

				command = br.readLine();
				if (command.equals("new")) {
					facade.addAccount(user);
				} else {

					Account accountById = facade.getAccountById(idFromCommand());
					if (accountById != null) {
						historyOrTransactionMenu(accountById);
					}
				}
			} catch (Exception e) {

			}
		} while (!command.toLowerCase().equals("exit"));
		command = "";
	}

	private void historyOrTransactionMenu(Account account) {

		do {
			try {
				historyOrTransactionPath(account);

				command = br.readLine();

				if (command.toLowerCase().equals("history")) {
					historyMenu(account);
				} else if (command.toLowerCase().equals("transfer")) {
					transactionMenu(account);
				}
			} catch (Exception e) {

			}

		} while (!command.toLowerCase().equals("exit"));
		command = "";
	}

	private void transactionMenu(Account account) {

		do {
			try {

				TransferStrategy[] strategies = facade.listAllStrategies();

				transferSelectionPrompt(account, strategies);

				command = br.readLine();

				if (command.toLowerCase().equals("history")) {
					historyMenu(account);
				} else {

					Integer strategyId = null;
					strategyId = Integer.valueOf(command);
					TransferStrategy strategy = strategies[strategyId];
					System.out.println(strategies[strategyId]);

					Transfer dao = facade.addTransfer();

					dao.setStrategy(strategy);
					dao.setDate(new Date());

					Map<String, Boolean> filedsInUse = strategy.getFiledsInUse();

					Iterator<Entry<String, Boolean>> it = filedsInUse.entrySet().iterator();
					while (it.hasNext()) {
						Map.Entry field = (Map.Entry) it.next();
						if ((boolean) field.getValue()) {
							switch ((String) field.getKey()) {
							case "fromAccount": {
								System.out.print("From which account? : ");
								command = br.readLine();
								Long id = idFromCommand();
								Account from = facade.getAccountById(id);
								dao.setFrom(from);
							}
								break;
							case "toAccount": {
								System.out.print("To which account? : ");
								command = br.readLine();
								Long id = idFromCommand();
								Account to = facade.getAccountById(id);
								dao.setTo(to);
							}
								break;
							case "reason": {
								System.out.print("What reason? : ");
								command = br.readLine();
								dao.setReason(command);
							}

								break;
							case "value": {
								System.out.print("What amount? : ");
								command = br.readLine();
								Long value = idFromCommand();
								dao.setValue(value);
							}
							}
						}
					}

					facade.doTransfer(dao);

				}
			} catch (Exception e) {

			}
		} while (!command.toLowerCase().equals("exit"));
		command = "";
	}

	private void historyMenu(Account account) {

		do {
			try {
				historyPrompt(account);
				command = br.readLine();
				if (command.toLowerCase().equals("full")) {
					
					History[] history = facade.listHistory(account);
					printHistory(history);
				} else if (command.toLowerCase().equals("to")) {
					History[] history = facade.listHistoryTo(account);
					printHistory(history);

				} else if (command.toLowerCase().equals("from")) {
					History[] history = facade.listHistoryFrom(account);
					printHistory(history);
				}


			} catch (Exception e) {

			}
		} while (!command.toLowerCase().equals("exit"));
		command = "";
	}

	private void printHistory(History[] history) {
		if (history != null) {
			if (history.length > 0) {
				for (History history2 : history) {
					System.out.println(history2);
				}
			} else {
				System.out.print("There is no history record for account\n");
			}
		}
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

	private void accountSelectionPrompt(List<Account> accounts) {
		prompt.setLength(0);
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
		prompt.append("\nor type 'exit' to select new account");

		System.out.println(prompt);
	}

	private void historyOrTransactionPath(Account account) {
		prompt.setLength(0);
		prompt.append("Selected account: ");
		prompt.append(account);
		prompt.append("\ntype 'history' to view account history, or 'transfer' to make a transfer");
		System.out.println(prompt);
	}

}
