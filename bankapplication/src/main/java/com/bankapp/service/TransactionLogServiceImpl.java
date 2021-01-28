package com.bankapp.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.dao.TransactionLogRepo;
import com.bankapp.entities.TransactionLog;

@Service
@Transactional
public class TransactionLogServiceImpl implements TransactionLogService{

	@Autowired
	private TransactionLogRepo transRepo;

	public TransactionLog addCustomerTransactions(int fromAccountId,int toAccountId,Date timeStamp,String message,int tAmount,String txType) {
		
		return transRepo.addCustomerTransactions(fromAccountId, toAccountId, timeStamp, message, tAmount, txType);
	}

	@Override
	public TransactionLog addCustomerTransactions(int fromAccountId, Date timeStamp, String message, int tAmount,
			String txType) {
		return transRepo.addCustomerTransactions(fromAccountId, timeStamp, message, tAmount, txType);
	}

	@Override
	public TransactionLog findByTransactions(int accountId) {
		return transRepo.findByTransactions(accountId);
	}

	@Override
	public List<TransactionLog> getAllTransactionsDetails() {
		return transRepo.getAllTransactionsDetails();
	}


	
	
	

}
