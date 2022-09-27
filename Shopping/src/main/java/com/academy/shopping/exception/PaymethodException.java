package com.academy.shopping.exception;

public class PaymethodException extends RuntimeException{
	
	public PaymethodException(String msg) {
		super(msg);
	}
	
	public PaymethodException(String msg, Throwable e) {
		super(msg,e);
	}
	
	public PaymethodException(Throwable e) {
		super(e);
	}
}
