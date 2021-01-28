package com.bankapp.exceptions;

public class TransactionDetailsNotFound extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public TransactionDetailsNotFound(String message) {
		super(message);
	}

}
