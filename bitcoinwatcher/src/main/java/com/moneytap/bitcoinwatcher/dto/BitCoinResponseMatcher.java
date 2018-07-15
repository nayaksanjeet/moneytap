package com.moneytap.bitcoinwatcher.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BitCoinResponseMatcher {

	@JsonProperty("time")
	private Time time;
	private String disclaimer;
	@JsonProperty("bpi")
	private Bpi bpi;
	
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public String getDisclaimer() {
		return disclaimer;
	}
	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}
	public Bpi getBpi() {
		return bpi;
	}
	public void setBpi(Bpi bpi) {
		this.bpi = bpi;
	}
	
	
}
