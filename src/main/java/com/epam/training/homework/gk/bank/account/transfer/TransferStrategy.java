package com.epam.training.homework.gk.bank.account.transfer;

import java.util.HashMap;
import java.util.Map;

import com.epam.training.homework.gk.bank.Services;
import com.epam.training.homework.gk.bank.account.Account;

public interface TransferStrategy {

	void doTransfer(Transfer dao);

	Map<String, Boolean> getFiledsInUse();

	enum Strategies implements TransferStrategy {
		BorrowFromBank {

			@Override
			public void doTransfer(Transfer dao) {
				dao.setInterest(2);

				Account fromAccount = newAccountToBank(dao);
				dao.setFrom(fromAccount);
				Account toAccount = dao.getToAccount();

				Transfer negateDao = negateDao(dao);

				doIt(dao, toAccount);

				doIt(negateDao, fromAccount);

			}

			@Override
			public Map<String, Boolean> getFiledsInUse() {
				Map<String, Boolean> fields = new HashMap<>();
				fields.put("fromAccount", false);
				fields.put("toAccount", true);
				fields.put("reason", false);
				fields.put("value", true);
				fields.put("interest", true);
				return fields;
			}

		},
		LentToBank {

			@Override
			public void doTransfer(Transfer dao) {
				dao.setInterest(1);

				Account toAccount = newAccountToBank(dao);
				Account fromAccount = dao.getFromAccount();

				dao.setTo(toAccount);
				Transfer negateDao = negateDao(dao);

				doIt(dao, toAccount);
				doIt(negateDao, fromAccount);

			}

			@Override
			public Map<String, Boolean> getFiledsInUse() {
				Map<String, Boolean> fields = new HashMap<>();
				fields.put("fromAccount", true);
				fields.put("toAccount", false);
				fields.put("reason", false);
				fields.put("value", true);
				fields.put("interest", true);
				return fields;
			}
		},
		PutMoneyIn {

			@Override
			public void doTransfer(Transfer dao) {
				doIt(dao, dao.getToAccount());

			}

			@Override
			public Map<String, Boolean> getFiledsInUse() {
				Map<String, Boolean> fields = new HashMap<>();
				fields.put("fromAccount", false);
				fields.put("toAccount", true);
				fields.put("reason", true);
				fields.put("value", true);
				fields.put("interest", false);
				return fields;
			}
		},
		SendGift {

			@Override
			public void doTransfer(Transfer dao) {

				Account toAccount = dao.getToAccount();
				Account fromAccount = dao.getFromAccount();

				Transfer negateDao = negateDao(dao);

				doIt(dao, toAccount);
				doIt(negateDao, fromAccount);

			}

			@Override
			public Map<String, Boolean> getFiledsInUse() {
				Map<String, Boolean> fields = new HashMap<>();
				fields.put("fromAccount", true);
				fields.put("toAccount", true);
				fields.put("reason", true);
				fields.put("value", true);
				fields.put("interest", false);
				return fields;
			}
		},
		TakeMoneyOut {

			@Override
			public void doTransfer(Transfer dao) {
				dao.setValue(dao.getValue().negate());

				Account fromAccount = dao.getFromAccount();
				doIt(dao, fromAccount);

			}
		};
		@Override

		public Map<String, Boolean> getFiledsInUse() {
			Map<String, Boolean> fields = new HashMap<>();
			fields.put("fromAccount", true);
			fields.put("toAccount", false);
			fields.put("reason", false);
			fields.put("value", true);
			fields.put("interest", false);
			return fields;
		}
	}

	default Transfer copyDao(Transfer dao) {
		Services service = dao.getService();
		Transfer newDao = service.getTransferService().create(service);
		newDao.setDate(dao.getDate());
		newDao.setFrom(dao.getFromAccount());
		newDao.setInterest(dao.getInterest());
		newDao.setReason(dao.getReason());
		newDao.setService(dao.getService());
		newDao.setStrategy(dao.getStrategy());
		newDao.setTo(dao.getToAccount());
		newDao.setValue(dao.getValue());
		return newDao;
	}

	default Account newAccountToBank(Transfer dao) {
		Account fromAccount = dao.getService().getAccountService().create();
		dao.getService().getUserService().getBank().addNewAccount(fromAccount);
		return fromAccount;
	}

	default void doIt(Transfer dao, Account account) {
		account.change(dao);
		dao.setBalance(dao.getToAccount().getBalance());
	}

	default Transfer negateDao(Transfer dao) {
		Transfer newDao = copyDao(dao);
		newDao.setValue(dao.getValue().negate());
		return newDao;
	}

}
