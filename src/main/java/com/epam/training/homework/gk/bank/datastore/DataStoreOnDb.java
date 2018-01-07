package com.epam.training.homework.gk.bank.datastore;

import java.util.List;

import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.account.transfer.Transfer;
import com.epam.training.homework.gk.bank.jpa.DbConnector;
import com.epam.training.homework.gk.bank.user.User;

public class DataStoreOnDb implements DataStore {
    DbConnector dbConnector;
    
    
    public DataStoreOnDb(DbConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    @Override
    public List<User> getUsers() {

        return dbConnector.getUsers();
    }

    @Override
    public List<Account> getAccounts() {

        return dbConnector.getAccounts();
    }

    @Override
    public List<Transfer> getTransfers() {
        return dbConnector.getTransfers();
    }

}
