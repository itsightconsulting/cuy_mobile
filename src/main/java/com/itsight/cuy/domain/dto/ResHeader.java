package com.itsight.cuy.domain.dto;

import java.io.Serializable;
import java.math.BigInteger;

public class ResHeader implements Serializable {

    private String ecoreTransactionUUID;

    private BigInteger ecoreTransactionDate;

    private int millis;

    public ResHeader(){}

    public String getEcoreTransactionUUID() {
        return ecoreTransactionUUID;
    }

    public void setEcoreTransactionUUID(String ecoreTransactionUUID) {
        this.ecoreTransactionUUID = ecoreTransactionUUID;
    }

    public BigInteger getEcoreTransactionDate() {
        return ecoreTransactionDate;
    }

    public void setEcoreTransactionDate(BigInteger ecoreTransactionDate) {
        this.ecoreTransactionDate = ecoreTransactionDate;
    }

    public int getMillis() {
        return millis;
    }

    public void setMillis(int millis) {
        this.millis = millis;
    }
}
