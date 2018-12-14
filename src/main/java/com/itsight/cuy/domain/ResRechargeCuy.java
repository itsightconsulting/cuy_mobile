package com.itsight.cuy.domain;

import java.io.Serializable;

public class ResRechargeCuy implements Serializable {

    private String subscriptionType;
    private String accountID;
    private String adjustmentTypeID;
    private String agent;
    private String amount;
    private String balance;
    private String identifier;
    private String receiveDate;
    private String transactionDate;
    private String generateCode;

    public ResRechargeCuy(){}

    public String getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getAdjustmentTypeID() {
        return adjustmentTypeID;
    }

    public void setAdjustmentTypeID(String adjustmentTypeID) {
        this.adjustmentTypeID = adjustmentTypeID;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(String receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getGenerateCode() {
        return generateCode;
    }

    public void setGenerateCode(String generateCode) {
        this.generateCode = generateCode;
    }
}
