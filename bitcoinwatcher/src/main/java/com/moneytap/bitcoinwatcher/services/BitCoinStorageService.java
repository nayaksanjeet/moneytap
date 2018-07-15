package com.moneytap.bitcoinwatcher.services;

import com.moneytap.bitcoinwatcher.dto.BitCoinResponseMatcher;
import com.moneytap.bitcoinwatcher.entity.BitCoinRate;

public interface BitCoinStorageService {

	public BitCoinRate storeBitCoinDetails(BitCoinResponseMatcher response);
}
