package com.moneytap.bitcoinwatcher.dto;

public class Inr {

	private String code;
	private String rate;
	private String description;
	private String rate_float;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
		public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getRate_float() {
		return rate_float;
	}
	public void setRate_float(String rate_float) {
		this.rate_float = rate_float;
	}
		
}
