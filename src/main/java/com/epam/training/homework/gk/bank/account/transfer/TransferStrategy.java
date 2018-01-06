package com.epam.training.homework.gk.bank.account.transfer;

import java.util.HashMap;
import java.util.Map;

import com.epam.training.homework.gk.bank.Services;
import com.epam.training.homework.gk.bank.account.Account;

public interface TransferStrategy {

	void doTransfer(Transfer dao);

	Map<String, Boolean> getFiledsInUse();

	void setOwner(Transfer dao, Account account);

	boolean needsBank();

	void setBank(Transfer transfer, Account account);

	enum Strategies implements TransferStrategy {
		BorrowFromBank {

			@Override
			public void doTransfer(Transfer dao) {
				dao.setInterest(2);

				Account fromAccount = dao.getFromAccount();
				Account toAccount = dao.getToAccount();

				Transfer negateDao = negateDao(dao);

				doIt(dao, toAccount);

				doIt(negateDao, fromAccount);

			}

			@Override
			public void setOwner(Transfer dao, Account account) {
				dao.setTo(account);
			}
			@Override
			public boolean needsBank() {
				return true;
			}

			@Override
			public void setBank(Transfer transfer, Account account) {
				transfer.setFrom(account);
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

				Account toAccount = dao.getToAccount();
				Account fromAccount = dao.getFromAccount();

				dao.setTo(toAccount);
				Transfer negateDao = negateDao(dao);

				doIt(dao, toAccount);
				doIt(negateDao, fromAccount);

			}

			@Override
			public void setOwner(Transfer dao, Account account) {
				dao.setFrom(account);
			}
			@Override
			public boolean needsBank() {
				return true;
			}

			
			@Override
			public void setBank(Transfer transfer, Account account) {
				transfer.setTo(account);
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
			public void setOwner(Transfer dao, Account account) {
				dao.setTo(account);
			}
			@Override
			public boolean needsBank() {
				return false;
			}

			
			@Override
			public void setBank(Transfer transfer, Account account) {
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
			public void setOwner(Transfer dao, Account account) {
				dao.setFrom(account);
			}
			@Override
			public boolean needsBank() {
				return false;
			}

			
			@Override
			public void setBank(Transfer transfer, Account account) {

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

			@Override
			public void setOwner(Transfer dao, Account account) {
				dao.setFrom(account);
			}
			@Override
			public boolean needsBank() {
				return false;
			}

			
			@Override
			public void setBank(Transfer transfer, Account account) {

			}

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

	default void doIt(Transfer dao, Account account) {
		System.out.println("I'm doing it with: " + account + ", " + dao);
		account.change(dao);
		dao.setBalance(account.getBalance());
	}

	default Transfer negateDao(Transfer dao) {
		Transfer newDao = copyDao(dao);
		newDao.setValue(dao.getValue().negate());
		return newDao;
	}

	

}
