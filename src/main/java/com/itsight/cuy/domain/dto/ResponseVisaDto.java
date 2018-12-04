package com.itsight.cuy.domain.dto;

import java.io.Serializable;

public class ResponseVisaDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1270822692117732344L;
	
	private String errorCode;
	private String errorMessage;
	private String transactionUUID;
	private String externalTransactionId;
	private String transactionDateTime;
	private String transactionDuration;
	private String merchantId;
	private String userTokenId;
	private String aliasName;
	private DetailVisaDto data;
	
	public ResponseVisaDto() {
		// TODO Auto-generated constructor stub
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

	public String getTransactionUUID() {
		return transactionUUID;
	}

	public void setTransactionUUID(String transactionUUID) {
		this.transactionUUID = transactionUUID;
	}

	public String getExternalTransactionId() {
		return externalTransactionId;
	}

	public void setExternalTransactionId(String externalTransactionId) {
		this.externalTransactionId = externalTransactionId;
	}

	public String getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(String transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	public String getTransactionDuration() {
		return transactionDuration;
	}

	public void setTransactionDuration(String transactionDuration) {
		this.transactionDuration = transactionDuration;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getUserTokenId() {
		return userTokenId;
	}

	public void setUserTokenId(String userTokenId) {
		this.userTokenId = userTokenId;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public DetailVisaDto getData() {
		return data;
	}

	public void setData(DetailVisaDto data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseVisaDto [errorCode=" + errorCode + ", errorMessage=" + errorMessage + ", transactionUUID="
				+ transactionUUID + ", externalTransactionId=" + externalTransactionId + ", transactionDateTime="
				+ transactionDateTime + ", transactionDuration=" + transactionDuration + ", merchantId=" + merchantId
				+ ", userTokenId=" + userTokenId + ", aliasName=" + aliasName + "]";
	}
	
}
