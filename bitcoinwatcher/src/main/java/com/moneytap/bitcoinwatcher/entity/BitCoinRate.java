package com.moneytap.bitcoinwatcher.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Sanjeet Nayak
 *  BitCoinRate entity mapped with BitCoin_rate table
 */
@Entity
@Table(name="bitcoin_rate")
public class BitCoinRate implements Serializable{

	private static final long serialVersionUID = 3488685977154101897L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="USD",columnDefinition="Decimal(10,4)")
	private Double usd;
	
	@Column(name="INR",columnDefinition="Decimal(10,4)")
	private Double inr;
	
	@Column(name="recorded_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date recordedTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getUsd() {
		return usd;
	}

	public void setUsd(Double usd) {
		this.usd = usd;
	}

	public Double getInr() {
		return inr;
	}

	public void setInr(Double inr) {
		this.inr = inr;
	}

	public Date getRecordedTime() {
		return recordedTime;
	}

	public void setRecordedTime(Date recordedTime) {
		this.recordedTime = recordedTime;
	}

	
		
	
}
