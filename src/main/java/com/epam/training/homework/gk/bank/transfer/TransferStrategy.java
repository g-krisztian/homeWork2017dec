package com.epam.training.homework.gk.bank.transfer;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.epam.training.homework.gk.bank.Services;
import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.history.History;
import com.epam.training.homework.gk.bank.history.HistoryService;

public interface TransferStrategy {

	void doTransfer(Transfer dao);

	Map<String, Boolean> getFiledsInUse();


	enum Strategies implements TransferStrategy {
		BorrowFromBank {

			@Override
			public void doTransfer(Transfer dao) {
				Account fromAccount = dao.getService().getAccountService().create();
				dao.setFrom(fromAccount);
				dao.setInterest(BigDecimal.valueOf(2));
				Account toAccount = dao.getTo();
				toAccount.change(dao);

				dao.setValue(dao.getValue().negate());
				fromAccount.change(dao);
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
				Account toAccount = dao.getService().getAccountService().create();
				dao.setTo(toAccount);
				dao.setInterest(BigDecimal.valueOf(1));
				toAccount.change(dao);
				dao.setValue(dao.getValue().negate());
				Account fromAccount = dao.getFromAccount();
				fromAccount.change(dao);

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
				dao.getTo().change(dao);
				BigDecimal balance = dao.getTo().getBalance();
				HistoryService hs = dao.getHistoryService();
				History history = hs.create(dao, balance);
				hs.store(history);
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
				HistoryService historyService = dao.getService().getHistoryService();
				Account toAccount = dao.getTo();
				toAccount.change(dao);
				BigDecimal toBalance = toAccount.getBalance();
				History toHistory = historyService.create(dao, toBalance);
				historyService.store(toHistory);

				Account fromAccount = dao.getFromAccount();
				Transfer fromDao = copyDao(dao, dao.getService());
				fromDao.setValue(fromDao.getValue().negate());
				fromAccount.change(fromDao);
				BigDecimal fromBalance = fromAccount.getBalance();
				History fromHistory = historyService.create(fromDao, fromBalance);
				historyService.store(fromHistory);

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
				dao.getFromAccount().change(dao);
				BigDecimal balance = dao.getFromAccount().getBalance();
				History history = dao.getService().getHistoryService().create(dao, balance);
				dao.getService().getHistoryService().store(history);

			}
		};
		@Override
		
		public Map<String, Boolean> getFiledsInUse() {
			Map<String,Boolean> fields = new HashMap<>();
			fields.put("fromAccount", true);
			fields.put("toAccount", false);
			fields.put("reason", false);
			fields.put("value", true);
			fields.put("interest", false);
			return fields;
		}	}

	default Transfer copyDao(Transfer dao, Services service) {
		Transfer newDao = service.getTransferService().create(dao.getHistoryService());
		newDao.setDate(dao.getDate());
		newDao.setFrom(dao.getFromAccount());
		newDao.setInterest(dao.getInterest());
		newDao.setReason(dao.getReason());
		newDao.setService(dao.getService());
		newDao.setStrategy(dao.getStrategy());
		newDao.setTo(dao.getTo());
		newDao.setValue(dao.getValue());
		return newDao;
	}

}
