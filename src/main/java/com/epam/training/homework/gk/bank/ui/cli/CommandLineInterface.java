package com.epam.training.homework.gk.bank.ui.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.account.transfer.Transfer;
import com.epam.training.homework.gk.bank.account.transfer.TransferStrategy;
import com.epam.training.homework.gk.bank.facade.Facade;
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
		userSelectionMenu();
	}

	private void userSelectionMenu() {

		do {
			List<User> users = facade.listAllUsers();

			userPrompt(users);

			try {
				command = br.readLine();
				if (command.equals("new")) {
					createNewUser();
				} else {
					User userById = facade.getUserById(idFromCommand(command));
					System.out.println(userById);
					if (userById != null) {
						accountSelectionMenu(userById);
					}
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		} while (!command.toLowerCase().equals("quit"));

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
					facade.addAccountUser(user);
				} else {

					Account accountById = facade.getAccountById(idFromCommand(command));
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

				Transfer transfer = createTransfer(account, strategies);

				facade.doTransfer(transfer);

			} catch (Exception e) {
				System.out.println(e);
			}

		} while (!command.toLowerCase().equals("exit"));
		command = "";
	}

	private Transfer createTransfer(Account account, TransferStrategy[] strategies) throws IOException {

		Transfer transfer = facade.addTransfer(account);
		command = br.readLine();
		Integer strategyId = null;
		strategyId = Integer.valueOf(command);
		command="";
		TransferStrategy strategy = strategies[strategyId];
		transfer.setStrategy(strategy);

		transfer.setDate(new Date());

		Map<String, Boolean> filedsInUse = transfer.getStrategy().getFiledsInUse();

		Iterator<Entry<String, Boolean>> it = filedsInUse.entrySet().iterator();

		transfer.getStrategy().setOwner(transfer, account);
		if (transfer.getStrategy().needsBank()) {
			transfer.getStrategy().setBank(transfer, facade.addBankAccount());
		}
		while (it.hasNext()) {
			Entry<String, Boolean> field = it.next();
			if (field.getValue()) {
				switch (field.getKey()) {
				case "fromAccount":
					if (transfer.getFromAccount() == null) {
						System.out.print("From which account? : ");
						command = br.readLine();
						Long id = idFromCommand(command);
						Account from = facade.getAccountById(id);
						transfer.setFrom(from);
					}
					break;
				case "toAccount":
					if (transfer.getToAccount() == null) {
						System.out.print("To which account? : ");
						command = br.readLine();
						Long id = idFromCommand(command);
						Account to = facade.getAccountById(id);
						transfer.setTo(to);
					}
					break;
				case "reason": {
					System.out.print("What reason? : ");
					command = br.readLine();
					transfer.setReason(command);
				}

					break;
				case "value": {
					System.out.print("What amount? : ");
					command = br.readLine();
					Long value = idFromCommand(command);
					transfer.setValue(value);
				}
				}
			}
		}
		return transfer;
	}

	private void historyMenu(Account account) {

		do {
			try {
				historyPrompt(account);
				command = br.readLine();
				if (command.toLowerCase().equals("full")) {

					List<Transfer> history = facade.listHistory(account);
					printHistory(history);
				} else if (command.toLowerCase().equals("to")) {
					List<Transfer> history = facade.listHistoryTo(account);
					printHistory(history);

				} else if (command.toLowerCase().equals("from")) {
					List<Transfer> history = facade.listHistoryFrom(account);
					printHistory(history);
				}

			} catch (Exception e) {

			}
		} while (!command.toLowerCase().equals("exit"));
		command = "";
	}

	private void printHistory(List<Transfer> history) {
		if (history != null) {
			if (history.size() > 0) {
				for (Transfer history2 : history) {
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

	private void userPrompt(List<User> users) {
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

	private Long idFromCommand(String command) {
		Long ret = null;
		try {
			ret = Long.valueOf(command);
		} catch (NumberFormatException e) {
		}
		return ret;
	}
}
