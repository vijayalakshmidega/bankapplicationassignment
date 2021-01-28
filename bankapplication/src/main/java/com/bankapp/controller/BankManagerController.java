package com.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.beans.DepositBeans;
import com.bankapp.beans.TransferBeans;
import com.bankapp.beans.WithdrawBeans;
import com.bankapp.entities.Account;
import com.bankapp.entities.TransactionLog;
import com.bankapp.exceptions.TransactionDetailsNotFound;
import com.bankapp.secconfig.AuthResponse;
import com.bankapp.service.AccountService;
import com.bankapp.service.TransactionLogService;

import java.util.*;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@GetMapping("/accounts")
public class BankManagerController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private TransactionLogService transService;
	@GetMapping(path="/accounts",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Account>> getCustomerAccount(){
		List<Account> allAccounts=accountService.getAllCustomerAccounts();
		return new ResponseEntity<List<Account>>(allAccounts,HttpStatus.OK);
	}
	@GetMapping(path="/accounts/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> getCustomerAccountById(@PathVariable(name="id") int accountId){
		Account accountById=accountService.getCustomerAccountById(accountId);
		return new  ResponseEntity<Account>(accountById,HttpStatus.OK);
	}
	
	@PostMapping(path="/accounts",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> addNewCustomerAccount(@RequestBody Account account){
		Account accountAdding=accountService.addCustomerAccount(account);
		return new ResponseEntity<Account>(accountAdding,HttpStatus.CREATED);
	}
	
	@PutMapping(path="/accounts/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public 	ResponseEntity<Account> getUpdatedCustomerAccount(@PathVariable(name="id") int accountId,@RequestBody Account account){
		Account accountToUpdated=accountService.updateCustomerAccount(accountId, account);
		return new ResponseEntity<Account>(accountToUpdated,HttpStatus.CREATED);
	}
	
	@DeleteMapping(path="/accounts/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> getCustomerAccountDeleted(@PathVariable(name="id") int accountId){
		Account accountToDeleted=accountService.deleteCustomerAccount(accountId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping(path="/accounts/transfer",produces=MediaType.APPLICATION_JSON_VALUE)
	public String getTransferDetails(@RequestBody TransferBeans transferBeans) {
	String accountTransfer=accountService.tranferMoney(transferBeans.getFromAccountId(), transferBeans.getToAccountId(),transferBeans.getAmount());
	if(accountTransfer==null)    	 
	return "Not transferred";
	else
	return "successfully transferred";
	
	}
	
	@PostMapping(path="/accounts/deposit",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public Account getDepositDetails(@RequestBody DepositBeans depositBeans) {
		Account accountToBeDeposited=accountService.depositMoney(depositBeans.getDepositaccountId(), depositBeans.getAmountToDeposit());
		return accountToBeDeposited;
	}
	
	@PostMapping(path="/accounts/withdraw",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public Account getWithdrawDetails(@RequestBody WithdrawBeans withdrawBeans) {
		Account accountToBeWithdrawn=accountService.withdrawMoney(withdrawBeans.getWithdrawAccountId(), withdrawBeans.getAmountToWithdraw());
		return accountToBeWithdrawn;
	}
	
	@GetMapping(path="/accounts/transaction",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<TransactionLog> getAlTransaction() {
		List <TransactionLog> allTrans=transService.getAllTransactionsDetails();
		return allTrans;
	}
	
	@GetMapping(path="/accounts/transaction/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public TransactionLog getTransaction(@PathVariable (name="id")int id) {
		 TransactionLog accountTrans=transService.findByTransactions(id);
		return accountTrans;
	}
	
	
	@GetMapping(produces = "application/json")
	@RequestMapping({ "/validateLogin" })
	public AuthResponse validateLogin() {
			return new AuthResponse("User successfully authenticated");
	}
		

	

}
