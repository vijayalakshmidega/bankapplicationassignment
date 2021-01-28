package com.bankapp.beans;

public class DepositBeans {

	
	private int depositaccountId;
	private int amountToDeposit;
	public DepositBeans(int  depositaccountId, int amountToDeposit) {
		this. depositaccountId =  depositaccountId;
		this.amountToDeposit = amountToDeposit;
	}
	public DepositBeans() {
	}
	public int getDepositaccountId() {
		return depositaccountId;
	}
	public void setDepositaccountId(int depositaccountId) {
		this.depositaccountId = depositaccountId;
	}
	public int getAmountToDeposit() {
		return amountToDeposit;
	}
	public void setAmountToDeposit(int amountToDeposit) {
		this.amountToDeposit = amountToDeposit;
	}
	
	
	
}
