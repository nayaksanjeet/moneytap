package com.moneytap.bitcoinwatcher.services;

import org.springframework.http.ResponseEntity;

public interface BitCoinDetailService {

	public ResponseEntity<?> saveRecord();
}
