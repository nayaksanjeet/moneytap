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
	
	/**
	 * @param minutes
	 * @return Average price in USD as well as INR in json
	 * @throws ParseException
	 */
	@GetMapping(value="/bitcoin/avarage")
	
	public ResponseEntity<?> getAvarage(@RequestParam("minutes")String minutes) throws ParseException{
		log.info("average calculation()");
		if(Long.parseLong(minutes)<=0){
			log.error("invalid input");
			throw new MoneyTapError();
		}
		List<BitCoinRate> bitCoinRateList=bitCoinRequest.getBitCoinRates(Long.parseLong(minutes));
		if(bitCoinRateList.isEmpty()){
			log.error("Empty result");
			throw new MoneyTapError();
		}

		AveragePrice averagePrice=BitCoinUtil.getAverage(bitCoinRateList);
		
		return new ResponseEntity<AveragePrice>(averagePrice,HttpStatus.OK);
		
	}
	
	/**
	 * @param minutes
	 * @return Medianprice in USD as well as MedianPrice in INR in json
	 * @throws ParseException
	 */
	@GetMapping(value="/bitcoin/median")
	
	public ResponseEntity<?> getMedian(@RequestParam("minutes")String minutes) throws ParseException{
		log.info("median calculation()");
		if(Long.parseLong(minutes)<=0){
			log.error("invalid input");
			throw new MoneyTapError();
		}

		List<BitCoinRate> bitCoinRateList=bitCoinRequest.getBitCoinRates(Long.parseLong(minutes));
		if(bitCoinRateList.isEmpty()){
			log.error("Emppty result");
			throw new MoneyTapError();
		}
		MedianPrice medianPrice=BitCoinUtil.getMedian(bitCoinRateList);
		
		return new ResponseEntity<MedianPrice>(medianPrice,HttpStatus.OK);
		
	}
	
	

}
