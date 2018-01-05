package com.epam.training.homework.gk.bank.jpa;

import java.io.Closeable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.epam.training.homework.gk.bank.Persist;
import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.account.transfer.Transfer;
import com.epam.training.homework.gk.bank.user.User;

public class DbConnector implements Closeable {

	private EntityManagerFactory emf;

	public DbConnector() {

		emf = Persistence.createEntityManagerFactory("homeWork");

	}

	public EntityManager getEm() {
		return emf.createEntityManager();

	}

	public List<User> getUsers() {
		EntityManager em = emf.createEntityManager();
		TypedQuery<User> query = em.createQuery("SELECT u FROM UserDao u", User.class);
		List<User> users = query.getResultList();
		em.close();
		return users;
	}

	public List<Account> getAccounts() {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Account> query = em.createQuery("SELECT a FROM AccountDao a", Account.class);
		List<Account> accounts = query.getResultList();
		em.close();
		return accounts;
	}

	public List<Transfer> getTransfers() {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Transfer> query = em.createQuery("SELECT t FROM TransferDao t", Transfer.class);
		List<Transfer> transfers = query.getResultList();
		em.close();
		return transfers;
	}

	public User saveUser(User user) {
		return saveAny(user);
	}

	public Account saveAccount(Account account) {
		return saveAny(account);
	}

	public Transfer saveTransfer(Transfer transfer) {
		return saveAny(transfer);
	}

	public <T extends Persist> T saveAny(T o) {
		EntityManager em = emf.createEntityManager();
		if (!em.contains(o)) {
			o.setId(null);
		}
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(o);
		transaction.commit();
		em.close();
		return o;
	}

	@Override
	public void close() {
		emf.close();
	}

	public <T extends Persist> void saveMany(T[] args) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		for (T t : args) {
			em.persist(t);
		}
		transaction.commit();
		em.close();
	}
}
