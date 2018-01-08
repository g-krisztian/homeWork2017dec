package com.epam.training.homework.gk.bank.account.transfer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epam.training.homework.gk.bank.account.Account;

public enum Strategies implements TransferStrategy {

	BorrowFromBank {
		@Override
		public List<Change> getChanges(Transfer dao) {
			List<Change> changes = new ArrayList<>();
			
			dao.setInterest(2);

			Account fromAccount = dao.getFromAccount();
			Account toAccount = dao.getToAccount();

			Transfer negateDao = negateDao(dao);

			changes.add(new Change(toAccount, dao));

			changes.add(new Change(fromAccount, negateDao));

			return changes;

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
		public List<Change> getChanges(Transfer dao) {
			List<Change> changes = new ArrayList<>();
			dao.setInterest(1);

			Account toAccount = dao.getToAccount();
			Account fromAccount = dao.getFromAccount();

			dao.setTo(toAccount);
			Transfer negateDao = negateDao(dao);

			changes.add(new Change(toAccount, dao));

			changes.add(new Change(fromAccount, negateDao));

			return changes;

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
		public List<Change> getChanges(Transfer dao) {
			List<Change> changes = new ArrayList<>();
			changes.add(new Change(dao.getToAccount(), dao));

			return changes;

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
		public List<Change> getChanges(Transfer dao) {
			List<Change> changes = new ArrayList<>();
			Account toAccount = dao.getToAccount();
			Account fromAccount = dao.getFromAccount();

			Transfer negateDao = negateDao(dao);

			changes.add(new Change(toAccount, dao));

			changes.add(new Change(fromAccount, negateDao));

			return changes;

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
		public List<Change> getChanges(Transfer dao) {
			List<Change> changes = new ArrayList<>();
			dao.setValue(dao.getValue().negate());

			Account fromAccount = dao.getFromAccount();


			changes.add(new Change(fromAccount, dao));

			return changes;

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
	};

}