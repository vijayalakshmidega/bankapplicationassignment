package com.bankapp.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.*;


@Entity
@Table(name="account_user_table")
public class Account {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int accountId;
	private String acoountHolderName;
	private int mobileNum;
	private String email;
	private String address;
	private String bankName;
	private int amount;
	private String accountType;
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn
	List<TransactionLog> transactions=new ArrayList<>();
	public Account(String acoountHolderName, int mobileNum, String email, String address, String bankName,int amount,
			 String accountType) {
		this.acoountHolderName = acoountHolderName;
		this.mobileNum = mobileNum;
		this.email = email;
		this.address = address;
		this.bankName = bankName;
		this.amount=amount;
		this.accountType=accountType;
	}
	public Account() {
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAcoountHolderName() {
		return acoountHolderName;
	}
	public void setAcoountHolderName(String acoountHolderName) {
		this.acoountHolderName = acoountHolderName;
	}
	public int getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(int mobileNum) {
		this.mobileNum = mobileNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public List<TransactionLog> getTransactions() {
		return transactions;
	}
	public void setTansactions(List<TransactionLog> transactions) {
		this.transactions = transactions;
	}
	
	
	
}
