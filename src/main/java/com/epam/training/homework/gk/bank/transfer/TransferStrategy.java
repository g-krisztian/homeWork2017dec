package com.epam.training.homework.gk.bank.transfer;

import java.util.List;
import java.util.Map;

import com.epam.training.homework.gk.bank.Services;
import com.epam.training.homework.gk.bank.account.Account;

public interface TransferStrategy {

	List<Change> getChanges(Transfer dao);

	Map<String, Boolean> getFiledsInUse();

	void setOwner(Transfer dao, Account account);

	boolean needsBank();

	void setBank(Transfer transfer, Account account);

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

	default Transfer negateDao(Transfer dao) {
		Transfer newDao = copyDao(dao);
		newDao.setValue(dao.getValue().negate());
		return newDao;
	}

}
