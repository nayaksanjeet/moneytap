package com.moneytap.bitcoinwatcher.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.moneytap.bitcoinwatcher.entity.BitCoinRate;

public interface BitCoinRateRepository extends JpaRepository<BitCoinRate, Long> {
	
	@Query("select b from BitCoinRate b where  b.recordedTime <= :resultCurrentISOTimestamp and b.recordedTime>=:resultPreviousISOTimestamp")
	List<BitCoinRate> getBitCoinRates(@Param("resultCurrentISOTimestamp")Date resultCurrentISODate,@Param("resultPreviousISOTimestamp") Date resultPreviousISODate);
	
	}
