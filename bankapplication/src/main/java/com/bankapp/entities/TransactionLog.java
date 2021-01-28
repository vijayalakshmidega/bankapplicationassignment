package com.bankapp.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="transactions_table")
public class TransactionLog {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tId;
	private int fromAccount;
	private int toAccount;
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeStamp;
	private int tAmount;
		private String message;
	private String transType;
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn
	private Account account;
	
	public TransactionLog() {
	}
	public TransactionLog(int fromAccount, int toAccount, Date timeStamp, String message,
			int tAmount,String transType) {
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.timeStamp = timeStamp;
		this.tAmount=tAmount;
		this.message = message;
		this.transType=transType;
		
	}
	
	public TransactionLog(int fromAccount, Date timeStamp, int tAmount, String message, String transType) {
		super();
		this.fromAccount = fromAccount;
		this.timeStamp = timeStamp;
		this.tAmount = tAmount;
		this.message = message;
		this.transType = transType;
	}
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public int getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(int fromAccount) {
		this.fromAccount = fromAccount;
	}
	public int getToAccount() {
		return toAccount;
	}
	public void setToAccount(int toAccount) {
		this.toAccount = toAccount;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public int gettAmount() {
		return tAmount;
	}
	public void settAmount(int tAmount) {
		this.tAmount = tAmount;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	
}
