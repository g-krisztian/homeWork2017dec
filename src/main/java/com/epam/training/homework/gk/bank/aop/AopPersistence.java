package com.epam.training.homework.gk.bank.aop;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.LoggerFactory;

import com.epam.training.homework.gk.bank.Persist;
import com.epam.training.homework.gk.bank.account.Account;
import com.epam.training.homework.gk.bank.jpa.DbConnector;
import com.epam.training.homework.gk.bank.transfer.Change;
import com.epam.training.homework.gk.bank.transfer.Transfer;
import com.epam.training.homework.gk.bank.user.User;

public class AopPersistence {
	DbConnector dbConnector;
	public AopPersistence(DbConnector dbConnector) {
		this.dbConnector = dbConnector;
		LoggerFactory.getLogger(this.getClass());
	}

	public <T extends Persist> T saveCreated(ProceedingJoinPoint pjp) throws Throwable {

		@SuppressWarnings("unchecked")
		T created = (T) pjp.proceed();
		created.setId(null);
		dbConnector.saveNew(created);
		return created;
	}

	public <T extends Persist> T update(ProceedingJoinPoint pjp) throws Throwable {
	    @SuppressWarnings("unchecked")
        T t= (T) pjp.proceed();
		System.out.println("\npj: " + pjp.getKind());
		Object[] objArgs = pjp.getArgs();

		for (Object object : objArgs) {

			System.out.println("\n\tIn update: " + object);
		}

		List<T> listArgs = tryConvert(objArgs);

		dbConnector.saveMany(listArgs);
		return t;
	}

	
	@SuppressWarnings("unchecked")
    public <T extends Persist> List<Change> updateTransfer(ProceedingJoinPoint pjp) throws Throwable {
	    System.out.println("\n\tUpdateTransfer:" + pjp);
	    
		ArrayList<Change> changes = (ArrayList<Change>) pjp.proceed();
		
		for (Change change : changes) {
            System.out.println(change);
        }
		
		System.out.println("\n\tupdateTranferben: ");

		List<T> listArgs = new ArrayList<>();
		
		for (Change change : changes) {
		    System.out.println(change);
		    
		    Account account;
            Transfer transfer;
            try {
                account = change.getAccount();
                transfer = change.getTransfer();
                listArgs.add((T) transfer);
                listArgs.add((T) account);
                
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
		
		listArgs = tryConvert(listArgs.toArray());

		dbConnector.saveMany(listArgs);
		return changes;


	}

	public <T extends Persist> T markDelete(ProceedingJoinPoint pjp) throws Throwable {
		Object[] objArgs = pjp.getArgs();
		List<T> listArgs = tryConvert(objArgs);

		@SuppressWarnings("unchecked")
		T t = (T) pjp.proceed();
		t.setActive(false);
		dbConnector.saveMany(listArgs);
		return t;
	}

	public Account getAccountById(ProceedingJoinPoint pjp) throws Throwable {

		Long id = (Long) pjp.getArgs()[0];

		return dbConnector.getAccountById(id);
	}

	public List<Account> getAccounts(ProceedingJoinPoint pjp) {
		;
		return dbConnector.getAccounts();
	}

	public List<Transfer> getTransfers(ProceedingJoinPoint pjp) {

		return dbConnector.getTransfers();
	}

	public User getUserById(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println(pjp.getSourceLocation());

		Long id = (Long) pjp.getArgs()[0];
		System.out.println(id);
		return dbConnector.getUserById(id);
	}

	public List<User> getUsers(ProceedingJoinPoint pjp) {

		return dbConnector.getUsers();
	}

	public User findByName(ProceedingJoinPoint pjp) {

		String name = (String) pjp.getArgs()[0];
		return dbConnector.getUserByName(name);
	}
	
	public List<Transfer> getHistory(ProceedingJoinPoint pjp){
	    Account account = (Account) pjp.getArgs()[0];
	    System.out.println(account);
	            
        return dbConnector.getHistory(account.getId());
      
	}
	
//	
//	SELECT e 
//	FROM Employee e 
//	WHERE e IN (SELECT emp
//	              FROM Project p JOIN p.employees emp 
//	             WHERE p.name = :project)
	

	@SuppressWarnings("unchecked")
	private <T extends Persist> List<T> tryConvert(Object[] args) {
		List<T> args1 = new ArrayList<T>();

		try {
			for (int i = 0; i < args.length; i++) {
				args1.add((T) args[i]);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return args1;
	}

}
