package com.moneytap.bitcoinwatcher.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.jcabi.aspects.Loggable;
import com.moneytap.bitcoinwatcher.dto.BitCoinResponseMatcher;
import com.moneytap.bitcoinwatcher.services.BitCoinDetailService;
import com.moneytap.bitcoinwatcher.services.BitCoinStorageService;

@Component
public class BitCoinWatcherScheduler {
	
	@Autowired
	BitCoinDetailService bitCoinDetailService;
	
	@Autowired
	BitCoinStorageService bitCoinStorageService;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Scheduled(fixedRate=60000)
	@Loggable
	public void display(){
		log.info("scheduler is running");
		ResponseEntity<?> response=bitCoinDetailService.saveRecord();
		BitCoinResponseMatcher responseMatcher=(BitCoinResponseMatcher)response.getBody();
		//System.out.println(responseMatcher.getDisclaimer());
		log.info(responseMatcher.getBpi().getUSD().getRate_float());
		log.info(responseMatcher.getBpi().getINR().getRate_float());
		bitCoinStorageService.storeBitCoinDetails(responseMatcher);
		
		
		
	}

}
