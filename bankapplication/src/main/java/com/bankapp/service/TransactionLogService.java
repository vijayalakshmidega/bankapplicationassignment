package com.bankapp.service;

import java.util.Date;
//import java.util.List;
import java.util.List;

import com.bankapp.entities.TransactionLog;

public interface TransactionLogService {

	
	public TransactionLog addCustomerTransactions(int fromAccountId,int toAccountId,Date timeStamp,String message,int tAmount,String txType);
	public TransactionLog addCustomerTransactions(int fromAccountId,Date timeStamp,String message,int tAmount,String txType);
	public TransactionLog findByTransactions(int accountId);
	public List<TransactionLog> getAllTransactionsDetails();
}
