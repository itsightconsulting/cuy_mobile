package com.itsight.cuy.domain.dto;

import java.io.Serializable;

public class ResponseVisaFailDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	private String errorMessage;
	private String millis;
	private String transactionUUID;
	private String transactionDate;
	private String operationDate;
	private DetailVisaDto data;
	
	public ResponseVisaFailDto() {
		this.data = new DetailVisaDto();
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getMillis() {
		return millis;
	}

	public void setMillis(String millis) {
		this.millis = millis;
	}

	public String getTransactionUUID() {
		return transactionUUID;
	}

	public void setTransactionUUID(String transactionUUID) {
		this.transactionUUID = transactionUUID;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ResponseVisaFailDto [errorCode=" + errorCode + ", errorMessage=" + errorMessage + ", millis=" + millis
				+ ", transactionUUID=" + transactionUUID + ", transactionDate=" + transactionDate + "]";
	}

	public String getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(String operationDate) {
		this.operationDate = operationDate;
	}

	public DetailVisaDto getData() {
		return data;
	}

	public void setData(DetailVisaDto data) {
		this.data = data;
	}
	
	
	
	
	
	
	
}
