package com.bankapp;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bankapp.entities.Account;
import com.bankapp.entities.TransactionLog;
import com.bankapp.service.AccountService;

@SpringBootApplication
public class BankapplicationApplication implements CommandLineRunner{

	@Autowired
	private AccountService accountService;
	

	
	public static void main(String[] args) {
		SpringApplication.run(BankapplicationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
//Account account1=new Account("vijaya", 67889912, "s@sgmailcom", 
//		"Nellore","Axis", 5000,"SAVINGS");
//Account account2=new Account("Bhargavi", 6786781, "bhar@vgmailcom", 
//		"Nellore","ICIC", 7000,"CURRENT");
//
//Account account3=new Account("Prasanna", 671234567, "prasu@3gmailcom", 
//		"Buchi","SBI", 4000, "SAVINGS");
//
//	Account account4=new Account("Malathi", 675612489, "malto@3gmailcom", 
//		"Nellore","Syndicate", 8000,"SAVINGS");
//
//Account account5=new Account("Nikhitha", 671234567, "nikki@3gmailcom", 
//		"Nellore","Andhra", 5670, "CURRENT");
//
//
//accountService.addCustomerAccount(account1);
//accountService.addCustomerAccount(account2);
//accountService.addCustomerAccount(account3);
//accountService.addCustomerAccount(account4);
//accountService.addCustomerAccount(account5);	

		
	}

}
