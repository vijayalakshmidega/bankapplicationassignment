package com.bankapp.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankapp.entities.Account;
import com.bankapp.entities.TransactionLog;

@Repository
public class TransactionLogRepoImpl implements TransactionLogRepo{

	@Autowired
	private EntityManager em;
	
	

@Override
public TransactionLog addCustomerTransactions(int fromAccountId, int toAccountId, Date timeStamp, String message,
		int tAmount, String txType) {
	TransactionLog trasnsactions=new TransactionLog(fromAccountId, toAccountId, timeStamp, message, tAmount, txType);
	em.persist(trasnsactions);
	return trasnsactions;
}
@Override
public TransactionLog addCustomerTransactions(int fromAccountId, Date timeStamp, String message, int tAmount,
		String txType) {
	TransactionLog alltrasnsactions=new TransactionLog(fromAccountId, timeStamp, tAmount, message, txType);
	em.persist(alltrasnsactions);
	return alltrasnsactions;
	
}
@Override
public TransactionLog findByTransactions(int accountId) {
	TransactionLog tansById=em.find(TransactionLog.class, accountId);
	return  tansById;
}
@Override
public List<TransactionLog> getAllTransactionsDetails() {
	return em.createQuery("from TransactionLog").getResultList();
}

	}