package com.moneytap.bitcoinwatcher.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moneytap.bitcoinwatcher.dto.BitCoinResponseMatcher;
import com.moneytap.bitcoinwatcher.entity.BitCoinRate;
import com.moneytap.bitcoinwatcher.repository.BitCoinRateRepository;
import com.moneytap.bitcoinwatcher.util.BitCoinUtil;

@Service
public class BitCoinStorageServiceImpl implements BitCoinStorageService{

	@Autowired
	BitCoinRateRepository bitCoinRepository;
	
	@Override
	public BitCoinRate storeBitCoinDetails(BitCoinResponseMatcher response) {
		BitCoinRate bitCoin=BitCoinUtil.mapBitCoin(response);
		BitCoinRate bitCoinRate=bitCoinRepository.save(bitCoin);
		return bitCoinRate;
	}

}
