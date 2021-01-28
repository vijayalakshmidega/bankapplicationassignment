package com.bankapp.service;
import java.util.*;

import com.bankapp.entities.Account;
import com.bankapp.entities.TransactionLog;
public interface AccountService {
	
	List<Account> getAllCustomerAccounts();
	public Account addCustomerAccount(Account account);
	public Account updateCustomerAccount(int accountId,Account account);
	public Account deleteCustomerAccount(int accountId);
	public Account getCustomerAccountById(int accountId);
	public String tranferMoney(int fromAccountId,int toAccountId,int amount);
	public Account depositMoney(int accountId,int amount);
	public Account withdrawMoney(int accountId,int amount);
	
	
}
