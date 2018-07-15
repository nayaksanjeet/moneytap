package com.moneytap.bitcoinwatcher.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;

import com.jcabi.aspects.Loggable;
import com.moneytap.bitcoinwatcher.dto.AveragePrice;
import com.moneytap.bitcoinwatcher.dto.BitCoinResponseMatcher;
import com.moneytap.bitcoinwatcher.dto.MedianPrice;
import com.moneytap.bitcoinwatcher.entity.BitCoinRate;

public class BitCoinUtil {

	@Loggable
	public static BitCoinRate mapBitCoin(BitCoinResponseMatcher response) {
		BitCoinRate rate=new BitCoinRate();
		rate.setInr(Double.parseDouble(response.getBpi().getINR().getRate_float()));
		rate.setUsd(Double.parseDouble(response.getBpi().getUSD().getRate_float()));
		rate.setRecordedTime(Timestamp.valueOf(BitCoinUtil.convertStringToTimestamp(response.getTime().getUpdatedISO())));
		return rate;
	}

	@Loggable
	public static LocalDateTime convertStringToTimestamp(String time){
		String inputTime=time.replace("T", " ");
		String input1[]=inputTime.split("\\+");
		DateTimeFormatter datetime=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime localTime=LocalDateTime.parse(input1[0],datetime);
		String localReqiredTime=localTime.toLocalDate()+" "+localTime.toLocalTime()+":00";
		LocalDateTime resultTime=LocalDateTime.parse(localReqiredTime,datetime);
		
		return resultTime;
		
	}
	
	public static LocalDateTime convertStringToTimestampFormat(String time){
		String inputTime=time.replace("T", " ");
		String input1[]=inputTime.split("\\+");
		DateTimeFormatter datetime=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		LocalDateTime localTime=LocalDateTime.parse(input1[0],datetime);
		//System.out.println(localTime);
		String localReqiredTime=null;
		//System.out.println("Get Hour ="+localTime.getHour());
		if(localTime.getHour()<10){
			localReqiredTime=localTime.toLocalDate()+" "+"0"+localTime.getHour()+":"+localTime.getMinute()+":00";
		}
		if(localTime.getMinute()<10){
			localReqiredTime=localTime.toLocalDate()+" "+localTime.getHour()+":0"+localTime.getMinute()+":00";
		}
		if(localTime.getHour()<10 && localTime.getMinute()<10){
			localReqiredTime=localTime.toLocalDate()+" "+"0"+localTime.getHour()+":0"+localTime.getMinute()+":00";
		}
		if(localTime.getHour()>=10 && localTime.getMinute()>=10)
		 localReqiredTime=localTime.toLocalDate()+" "+localTime.getHour()+":"+localTime.getMinute()+":00";
		DateTimeFormatter datetimeWithoutMilli=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		//System.out.println("^^^^^^^^^^^^^^^^^^^^^6"+localReqiredTime);
		LocalDateTime resultTime=LocalDateTime.parse(localReqiredTime,datetimeWithoutMilli);
		//System.out.println(resultTime);
		return resultTime;
		
	}

	public static AveragePrice getAverage(List<BitCoinRate> bitCoinRateList){
		Double avarageUSD=new Double(0);
		Double sumUSD=new Double(0);
		Double sumINR=new Double(0);
		Double avarageINR=new Double(0);
		for(BitCoinRate bitCoin:bitCoinRateList){
			sumINR+=bitCoin.getInr();
			sumUSD+=bitCoin.getUsd();
		}
		avarageINR=sumINR/bitCoinRateList.size();
		avarageUSD=sumUSD/bitCoinRateList.size();
		AveragePrice averagePrice=new AveragePrice();
		averagePrice.setAverageBitCoinPriceINR(avarageINR);
		averagePrice.setAverageBitCoinPriceUSD(avarageUSD);
		return averagePrice;
	}

	public static MedianPrice getMedian(List<BitCoinRate> bitCoinRateList) {
	
	
		DoubleStream sortedPriceINR= bitCoinRateList.stream().mapToDouble(BitCoinRate::getInr).sorted();
		double medianPriceINR = bitCoinRateList.size()%2 == 0?
				sortedPriceINR.skip(bitCoinRateList.size()/2-1).limit(2).average().getAsDouble():        
				sortedPriceINR.skip(bitCoinRateList.size()/2).findFirst().getAsDouble();
		DoubleStream sortedPriceUSD=bitCoinRateList.stream().mapToDouble(BitCoinRate::getUsd).sorted();
		double medianPriceUSD = bitCoinRateList.size()%2 == 0?
				sortedPriceUSD.skip(bitCoinRateList.size()/2-1).limit(2).average().getAsDouble():        
				sortedPriceUSD.skip(bitCoinRateList.size()/2).findFirst().getAsDouble();
				
		MedianPrice medianPrice = new MedianPrice();
		medianPrice.setMedianBitCoinPriceINR(medianPriceINR);
		medianPrice.setMedianBitCoinPriceUSD(medianPriceUSD);
		return medianPrice;
	}
}
