package com.moneytap.bitcoinwatcher.dto;

import java.io.Serializable;

public class AveragePrice implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Double averageBitCoinPriceUSD;
	private Double averageBitCoinPriceINR;
	
	public Double getAverageBitCoinPriceUSD() {
		return averageBitCoinPriceUSD;
	}
	public void setAverageBitCoinPriceUSD(Double averageBitCoinPriceUSD) {
		this.averageBitCoinPriceUSD = averageBitCoinPriceUSD;
	}
	public Double getAverageBitCoinPriceINR() {
		return averageBitCoinPriceINR;
	}
	public void setAverageBitCoinPriceINR(Double averageBitCoinPriceINR) {
		this.averageBitCoinPriceINR = averageBitCoinPriceINR;
	}
	
	

	
}
