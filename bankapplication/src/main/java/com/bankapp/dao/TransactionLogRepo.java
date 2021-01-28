package com.bankapp.dao;


import java.util.*;


import com.bankapp.entities.TransactionLog;


public interface TransactionLogRepo {

	public TransactionLog addCustomerTransactions(int fromAccountId,int toAccountId,Date timeStamp,String message,int tAmount,String txType);
	
	public TransactionLog addCustomerTransactions(int fromAccountId,Date timeStamp,String message,int tAmount,String txType);
	public TransactionLog findByTransactions(int accountId);
	List<TransactionLog> getAllTransactionsDetails();
}
