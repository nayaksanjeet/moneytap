package com.moneytap.bitcoinwatcher.controller;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jcabi.aspects.Loggable;
import com.moneytap.bitcoinwatcher.dto.AveragePrice;
import com.moneytap.bitcoinwatcher.dto.MedianPrice;
import com.moneytap.bitcoinwatcher.entity.BitCoinRate;
import com.moneytap.bitcoinwatcher.repository.BitCoinRateRepository;
import com.moneytap.bitcoinwatcher.services.BitCoinRequestService;
import com.moneytap.bitcoinwatcher.util.BitCoinUtil;
import com.moneytap.bitcoinwatcher.util.MoneyTapError;

@RestController
@RequestMapping("/moneytap")
public class BitCoinWatchResource {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	BitCoinRequestService bitCoinRequest;
	
	@Autowired
	BitCoinRateRepository bitCoinRepo;
	
	@GetMapping(value="/bitcoin/avarage")
	
	public ResponseEntity<?> getAvarage(@RequestParam("minutes")String minutes) throws ParseException{
		log.info("average calculation()");
		List<BitCoinRate> bitCoinRateList=bitCoinRequest.getBitCoinRates(Long.parseLong(minutes));
		if(bitCoinRateList.isEmpty()){
			throw new MoneyTapError();
		}

		AveragePrice averagePrice=BitCoinUtil.getAverage(bitCoinRateList);
		
		return new ResponseEntity<AveragePrice>(averagePrice,HttpStatus.OK);
		
	}
	
	@GetMapping(value="/bitcoin/median")
	
	public ResponseEntity<?> getMedian(@RequestParam("minutes")String minutes) throws ParseException{
		log.info("median calculation()");
		List<BitCoinRate> bitCoinRateList=bitCoinRequest.getBitCoinRates(Long.parseLong(minutes));
		if(bitCoinRateList.isEmpty()){
			throw new MoneyTapError();
		}
		MedianPrice medianPrice=BitCoinUtil.getMedian(bitCoinRateList);
		
		return new ResponseEntity<MedianPrice>(medianPrice,HttpStatus.OK);
		
	}
	
	

}
