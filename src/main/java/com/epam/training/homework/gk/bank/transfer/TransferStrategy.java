package com.epam.training.homework.gk.bank.transfer;

import java.math.BigDecimal;
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

                Account fromAccount = newAccountToBank(dao);

                dao.setFrom(fromAccount);
                dao.setInterest(BigDecimal.valueOf(2)); 
                
                Account toAccount = dao.getToAccount();
                toAccount.change(dao);
                dao.setBalance(toAccount.getBalance());
                
                

                Transfer newDao = copyDao(dao);
                newDao.setValue(dao.getValue().negate());
                fromAccount.change(newDao);
                newDao.setBalance(toAccount.getBalance());

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
                
                Account toAccount = newAccountToBank(dao);
                
                dao.setTo(toAccount);
                dao.setInterest(BigDecimal.valueOf(1));
                toAccount.change(dao);
                
                dao.setBalance(toAccount.getBalance());

                Transfer newDao = copyDao(dao);
                newDao.setValue(dao.getValue().negate());
                Account fromAccount = newDao.getFromAccount();
                fromAccount.change(newDao);

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
                dao.getToAccount().change(dao);
                dao.setBalance(dao.getToAccount().getBalance());

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
                toAccount.change(dao);
                dao.setBalance(toAccount.getBalance());

                Account fromAccount = dao.getFromAccount();
                Transfer fromDao = copyDao(dao);
                fromDao.setValue(fromDao.getValue().negate());
                fromAccount.change(fromDao);
                fromDao.setBalance(fromAccount.getBalance());

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
                dao.setBalance(dao.getFromAccount().getBalance());

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

}
