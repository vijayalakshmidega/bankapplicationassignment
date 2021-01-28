package com.bankapp.beans;

public class WithdrawBeans {
	private int withdrawAccountId;
	private int amountToWithdraw;
	public WithdrawBeans() {
		
	}
	public WithdrawBeans(int withdrawAccountId, int amountToWithdraw) {
		this.withdrawAccountId = withdrawAccountId;
		this.amountToWithdraw = amountToWithdraw;
	}
	public int getWithdrawAccountId() {
		return withdrawAccountId;
	}
	public void setWithdrawAccountId(int withdrawAccountId) {
		this.withdrawAccountId = withdrawAccountId;
	}
	public int getAmountToWithdraw() {
		return amountToWithdraw;
	}
	public void setAmountToWithdraw(int amountToWithdraw) {
		this.amountToWithdraw = amountToWithdraw;
	}
	
	
	
	
}
