package com.moneytap.bitcoinwatcher.util;

public class MoneyTapError extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMessasge;
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessasge() {
		return errorMessasge;
	}
	public void setErrorMessasge(String errorMessasge) {
		this.errorMessasge = errorMessasge;
	}
	
	
}
