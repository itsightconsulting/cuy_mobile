package com.itsight.cuy.domain.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.itsight.cuy.json.JsonDateSimpleDeserializer;
import com.itsight.cuy.json.JsonDateSimpleSerializer;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class TransactionDTO {

    private String personDni;

    private String personName;

    private double amount;

    private String transactionType;

    private String codeTransaction;

    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(using = JsonDateSimpleSerializer.class)
    @JsonDeserialize(using = JsonDateSimpleDeserializer.class)
    private Date dateOperation;

    private boolean flagCorrect;

    public TransactionDTO() {
    }


    public String getPersonDni() {
        return personDni;
    }

    public void setPersonDni(String personDni) {
        this.personDni = personDni;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCodeTransaction() {
        return codeTransaction;
    }

    public void setCodeTransaction(String codeTransaction) {
        this.codeTransaction = codeTransaction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public boolean isFlagCorrect() {
        return flagCorrect;
    }

    public void setFlagCorrect(boolean flagCorrect) {
        this.flagCorrect = flagCorrect;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

}
