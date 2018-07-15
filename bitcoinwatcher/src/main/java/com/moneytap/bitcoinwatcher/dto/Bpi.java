package com.moneytap.bitcoinwatcher.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Bpi {

	@JsonProperty("USD")
	private Usd USD;
	@JsonProperty("INR")
	private Inr INR;
	public Usd getUSD() {
		return USD;
	}
	public void setUSD(Usd uSD) {
		USD = uSD;
	}
	public Inr getINR() {
		return INR;
	}
	public void setINR(Inr iNR) {
		INR = iNR;
	}
	
	 
	
}
