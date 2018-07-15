package com.moneytap.bitcoinwatcher.dto;

import java.io.Serializable;

public class MedianPrice implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Double MedianBitCoinPriceUSD;
	private Double MedianBitCoinPriceINR;
	
	public Double getMedianBitCoinPriceUSD() {
		return MedianBitCoinPriceUSD;
	}
	public void setMedianBitCoinPriceUSD(Double medianBitCoinPriceUSD) {
		MedianBitCoinPriceUSD = medianBitCoinPriceUSD;
	}
	public Double getMedianBitCoinPriceINR() {
		return MedianBitCoinPriceINR;
	}
	public void setMedianBitCoinPriceINR(Double medianBitCoinPriceINR) {
		MedianBitCoinPriceINR = medianBitCoinPriceINR;
	}
	
	
 
}
