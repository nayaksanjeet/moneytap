package com.moneytap.bitcoinwatcher.services;

import java.util.List;

import com.moneytap.bitcoinwatcher.entity.BitCoinRate;

public interface BitCoinRequestService {
	
  public List<BitCoinRate> getBitCoinRates(Long minutes);
 
 
}
