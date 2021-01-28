package com.bankapp.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.dao.AccountRepo;
import com.bankapp.entities.Account;
import com.bankapp.exceptions.AccountNotFound;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountRepo accountRepo;
	
	@Autowired
	private TransactionLogService transService;
	
	@Override
	public List<Account> getAllCustomerAccounts() {
		return accountRepo.findAll();
	}

	@Override
	public Account addCustomerAccount(Account account) {
		accountRepo.save(account);
		return account;
	}

	@Override
	public Account updateCustomerAccount(int accountId, Account account) {
		Account accountToUpdate=getCustomerAccountById(accountId);
		accountToUpdate.setAddress(account.getAddress());
		accountToUpdate.setEmail(account.getEmail());
		accountToUpdate.setAmount(account.getAmount());
		accountRepo.save(accountToUpdate);
		return accountToUpdate;
	}

	@Override
	public Account deleteCustomerAccount(int accountId) {
		Account accountToDelete=getCustomerAccountById(accountId);
		accountRepo.delete(accountToDelete);
		return accountToDelete;
	}

	@Override
	public Account getCustomerAccountById(int accountId) {
		return accountRepo.findById(accountId).orElseThrow(()->new  AccountNotFound("Account details not found"));
	}

	@Override
	public String tranferMoney(int fromAccountId, int toAccountId, int amount) {

		Account accountFrom=withdrawMoney(fromAccountId,amount);
		Account accountTo=depositMoney(toAccountId,amount);	
		accountRepo.save(accountFrom);
		accountRepo.save(accountTo);
	transService.addCustomerTransactions(fromAccountId, toAccountId, new Date(), "Success", amount,"debited");
		return "transferred";
		
	}

	@Override
	public Account depositMoney(int accountId, int amount) {
		Account amountToDeposit=getCustomerAccountById(accountId);
		amountToDeposit.setAmount(amountToDeposit.getAmount()+amount);
		accountRepo.save(amountToDeposit);
		transService.addCustomerTransactions(accountId, new Date(), "Deposited",amount, "credited");
		return amountToDeposit;
		
		
	}

	@Override
	public Account withdrawMoney(int accountId, int amount) {
		Account amountToWithdraw=getCustomerAccountById(accountId);
		amountToWithdraw.setAmount(amountToWithdraw.getAmount()-amount);
		accountRepo.save(amountToWithdraw);
		transService.addCustomerTransactions(accountId, new Date(), "withdrawn", amount, "debited");
		return amountToWithdraw;
	}

	

}
