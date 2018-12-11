package com.itsight.cuy.domain.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class InitVisaDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5406840367489412469L;
	
	private String sessionKey;
	private String expirationTime;
	private String keyForm;
	private int transactionId;
	private BigDecimal priceTransaction;
	
	public InitVisaDto() {}
	
	public String getSessionKey() {
		return sessionKey;
	}
	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}
	public String getExpirationTime() {
		return expirationTime;
	}
	public void setExpirationTime(String expirationTime) {
		this.expirationTime = expirationTime;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public BigDecimal getPriceTransaction() {
		return priceTransaction;
	}

	public void setPriceTransaction(BigDecimal priceTransaction) {
		this.priceTransaction = priceTransaction;
	}

	
	public String getKeyForm() {
		return keyForm;
	}

	public void setKeyForm(String keyForm) {
		this.keyForm = keyForm;
	}

	@Override
	public String toString() {
		return "ResponseBatchVisa [sessionKey=" + sessionKey + ", expirationTime=" + expirationTime + "]";
	}
	
	
	
}
