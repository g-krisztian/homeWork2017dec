package com.epam.training.homework.gk.bank.jpa;

import java.io.Closeable;
import java.lang.reflect.Field;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.epam.training.homework.gk.bank.Persist;
import com.epam.training.homework.gk.bank.Services;
import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.account.transfer.Transfer;
import com.epam.training.homework.gk.bank.account.transfer.TransferDao;
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

	public User getBank() {
		EntityManager em = emf.createEntityManager();

		TypedQuery<User> query = em.createQuery("SELECT u FROM UserDao u WHERE u.name=Bank", User.class);
		User user = query.getSingleResult();
		if (user == null) {

		}
		em.close();
		return user;
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
		return saveNew(user);
	}

	public Account saveAccount(Account account) {
		return saveNew(account);
	}

	public Transfer saveTransfer(Transfer transfer) {
		return saveNew(transfer);
	}

	public <T extends Persist> T saveNew(T o) {
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

	public <T extends Persist> void update(T t) {

		System.out.println("\nUpdating: +" + t + "\n");

		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.find(t.getClass(), t.getId());
		if (em.contains(t)) {
			em.merge(t);
		} else {
			em.persist(t);
		}
		transaction.commit();
		em.close();
	}

	public <T extends Persist> void saveMany(List<T> args) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		for (T t : args) {
			em.find(t.getClass(), t.getId());
			em.merge(t);
		}
		transaction.commit();
		em.close();
	}

	public User getUserById(Long id) {
		EntityManager em = emf.createEntityManager();
		TypedQuery<User> query = em.createQuery("SELECT u FROM UserDao u WHERE id=:id", User.class);
		query.setParameter("id", id);
		User user = query.getSingleResult();
		em.close();
		return user;
	}

	public Account getAccountById(Long id) {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Account> query = em.createQuery("SELECT a FROM AccountDao a WHERE id=:id", Account.class);
		query.setParameter("id", id);
		Account account = query.getSingleResult();
		em.close();
		return account;
	}

	// select * from AccountDao where id IN (select Accounts_id from
	// UserDao_AccountDao where UserDao_id=1);

	public List<Transfer> getHistory(Long id) {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Transfer> query = em.createQuery(
				"SELECT t FROM TransferDao t WHERE id IN (SELECT history_id WHERE AccountDao_id=:id)", Transfer.class);
		query.setParameter("id", id);
		List<Transfer> resultList = query.getResultList();
		em.close();
		return resultList;
	}

	public User getUserByName(String name) {
		EntityManager em = emf.createEntityManager();
		TypedQuery<User> query = em.createQuery("SELECT u FROM UserDao u WHERE name=:name", User.class);
		query.setParameter("name", name);
		User result = query.getSingleResult();
		em.close();
		return result;
	}

	public void updateTransfer(Transfer transfer) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Transfer persisted = em.find(transfer.getClass(), transfer.getId());
		copyTransfer(transfer, persisted);
		em.getTransaction().commit();
		em.close();
	}

	public void updateAccount(Account account) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Account persisted = em.find(account.getClass(), account.getId());
		copyAccount(account, persisted);
		em.getTransaction().commit();
		em.close();
	}

	private void copyAccount(Account fromAccount, Account toAccount) {
		toAccount.setInterest(fromAccount.getInterest());
		toAccount.setBalance(fromAccount.getBalance());
		fromAccount.setActive(fromAccount.isActive());
	}

	private void copyTransfer(Transfer fromDao, Transfer toDao) {
		toDao.setBalance(fromDao.getBalance());
		toDao.setDate(fromDao.getDate());
		toDao.setInterest(fromDao.getInterest());
		toDao.setReason(fromDao.getReason());
		toDao.setValue(fromDao.getValue());
		toDao.setFrom(fromDao.getFromAccount());
		toDao.setTo(fromDao.getToAccount());
		toDao.setStrategy(fromDao.getStrategy());
		toDao.setService(fromDao.getService());
		toDao.setActive(fromDao.getActive());
	}

}
