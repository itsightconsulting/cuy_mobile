package com.itsight.cuy.domain.dto;

import java.io.Serializable;
import java.math.BigInteger;

public class ResHeader implements Serializable {

    private String ecoreTransactionUUID;

    private BigInteger ecoreTransactionDate;

    private int milis;

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

    public int getMilis() {
        return milis;
    }

    public void setMilis(int milis) {
        this.milis = milis;
    }
}
