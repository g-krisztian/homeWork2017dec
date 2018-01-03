package com.epam.training.homework.gk.bank.jpa;

import java.io.Closeable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DbConnector implements Closeable {

    private EntityManagerFactory emf;

    public DbConnector() {

        emf = Persistence.createEntityManagerFactory("homeWork");

    }

    public EntityManager getEm() {
        return emf.createEntityManager();

    }

    @Override
    public void close()  {
        emf.close();
    }
}
