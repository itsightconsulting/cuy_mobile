package com.itsight.cuy.domain.dto;

import java.io.Serializable;

public class ResDataMap implements Serializable {


    private String CURRENCY;
    private String TRANSACTION_DATE;
    private String TERMINAL;
    private String ACTION_CODE;
    private String TRACE_NUMBER;
    private String ECI_DESCRIPTION;
    private String ECI;
    private String CARD;
    private String MERCHANT;
    private String STATUS;
    private String ADQUIRENTE;
    private String ACTION_DESCRIPTION;
    private String ID_UNICO;
    private String AMOUNT;
    private String PROCESS_CODE;
    private String TRANSACTION_ID;
    private String AUTHORIZATION_CODE;

    public ResDataMap(){}

    public String getCURRENCY() {
        return CURRENCY;
    }

    public void setCURRENCY(String CURRENCY) {
        this.CURRENCY = CURRENCY;
    }

    public String getTRANSACTION_DATE() {
        return TRANSACTION_DATE;
    }

    public void setTRANSACTION_DATE(String TRANSACTION_DATE) {
        this.TRANSACTION_DATE = TRANSACTION_DATE;
    }

    public String getTERMINAL() {
        return TERMINAL;
    }

    public void setTERMINAL(String TERMINAL) {
        this.TERMINAL = TERMINAL;
    }

    public String getACTION_CODE() {
        return ACTION_CODE;
    }

    public void setACTION_CODE(String ACTION_CODE) {
        this.ACTION_CODE = ACTION_CODE;
    }

    public String getTRACE_NUMBER() {
        return TRACE_NUMBER;
    }

    public void setTRACE_NUMBER(String TRACE_NUMBER) {
        this.TRACE_NUMBER = TRACE_NUMBER;
    }

    public String getECI_DESCRIPTION() {
        return ECI_DESCRIPTION;
    }

    public void setECI_DESCRIPTION(String ECI_DESCRIPTION) {
        this.ECI_DESCRIPTION = ECI_DESCRIPTION;
    }

    public String getECI() {
        return ECI;
    }

    public void setECI(String ECI) {
        this.ECI = ECI;
    }

    public String getCARD() {
        return CARD;
    }

    public void setCARD(String CARD) {
        this.CARD = CARD;
    }

    public String getMERCHANT() {
        return MERCHANT;
    }

    public void setMERCHANT(String MERCHANT) {
        this.MERCHANT = MERCHANT;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getADQUIRENTE() {
        return ADQUIRENTE;
    }

    public void setADQUIRENTE(String ADQUIRENTE) {
        this.ADQUIRENTE = ADQUIRENTE;
    }

    public String getACTION_DESCRIPTION() {
        return ACTION_DESCRIPTION;
    }

    public void setACTION_DESCRIPTION(String ACTION_DESCRIPTION) {
        this.ACTION_DESCRIPTION = ACTION_DESCRIPTION;
    }

    public String getID_UNICO() {
        return ID_UNICO;
    }

    public void setID_UNICO(String ID_UNICO) {
        this.ID_UNICO = ID_UNICO;
    }

    public String getAMOUNT() {
        return AMOUNT;
    }

    public void setAMOUNT(String AMOUNT) {
        this.AMOUNT = AMOUNT;
    }

    public String getPROCESS_CODE() {
        return PROCESS_CODE;
    }

    public void setPROCESS_CODE(String PROCESS_CODE) {
        this.PROCESS_CODE = PROCESS_CODE;
    }

    public String getTRANSACTION_ID() {
        return TRANSACTION_ID;
    }

    public void setTRANSACTION_ID(String TRANSACTION_ID) {
        this.TRANSACTION_ID = TRANSACTION_ID;
    }

    public String getAUTHORIZATION_CODE() {
        return AUTHORIZATION_CODE;
    }

    public void setAUTHORIZATION_CODE(String AUTHORIZATION_CODE) {
        this.AUTHORIZATION_CODE = AUTHORIZATION_CODE;
    }
}
