package com.moneytap.bitcoinwatcher.services;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moneytap.bitcoinwatcher.entity.BitCoinRate;
import com.moneytap.bitcoinwatcher.repository.BitCoinRateRepository;
import com.moneytap.bitcoinwatcher.util.BitCoinUtil;

@Service
public class BitCoinRequestServiceImpl implements BitCoinRequestService {

	@Autowired
	BitCoinRateRepository bitCoinRateRepository;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Override
	public List<BitCoinRate> getBitCoinRates(Long minutes) {
		log.info("getBitCoinRates()");
		Instant instant = Instant.now();
		LocalDateTime currentISO = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
		LocalDateTime resultCurrentISO=BitCoinUtil.convertStringToTimestampFormat(currentISO.toString());
		Timestamp resultCurrentISOTimestamp=Timestamp.valueOf(resultCurrentISO);
		LocalDateTime resultPreviousISO=resultCurrentISO.minusMinutes(minutes);
		Timestamp resultPreviousISOTimestamp=Timestamp.valueOf(resultPreviousISO);
		Date resultPreviousISODate=new Date(resultPreviousISOTimestamp.getTime());
		Date resultCurrentISODate=new Date(resultCurrentISOTimestamp.getTime());
		//Long count=bitCoinRepo.countOfMinutes(resultCurrentISODate,resultPreviousISODate);
		List<BitCoinRate> bitCoinRate=bitCoinRateRepository.getBitCoinRates(resultCurrentISODate, resultPreviousISODate);
		return bitCoinRate;
	}

}
