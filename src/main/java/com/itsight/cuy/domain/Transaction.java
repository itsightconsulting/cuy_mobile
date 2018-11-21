package com.itsight.cuy.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.itsight.cuy.domain.base.AuditingEntity;
import com.itsight.cuy.json.JsonDateSimpleDeserializer;
import com.itsight.cuy.json.JsonDateSimpleSerializer;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@NamedEntityGraphs({
        @NamedEntityGraph(name = "transaction",
                attributeNodes = {}),
        @NamedEntityGraph(name = "transaction.all",
                attributeNodes = {
                        @NamedAttributeNode(value = "person"),
                }),
})
@Entity
public class Transaction  extends AuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TransactionId")
    private int id;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(nullable = false, updatable = false, name = "PersonId")
    private Person person;

    private String codeTransaction;

    private double amount;

    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(using = JsonDateSimpleSerializer.class)
    @JsonDeserialize(using = JsonDateSimpleDeserializer.class)
    private Date dateOperation;

    private boolean flagCorrect;

    private int transactionType; // enum eTransactionType


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = new Person(person);
    }

    public int getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(int transactionType) {
        this.transactionType = transactionType;
    }

    public String getCodeTransaction() {
        return codeTransaction;
    }

    public void setCodeTransaction(String codeTransaction) {
        this.codeTransaction = codeTransaction;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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

    public Transaction() {
    }

    public Transaction(int person, String codeTransaction, double amount, String description, Date dateOperation, boolean flagCorrect, int transactionType) {
        this.person =  new Person(person);
        this.codeTransaction = codeTransaction;
        this.amount = amount;
        this.description = description;
        this.dateOperation = dateOperation;
        this.flagCorrect = flagCorrect;
        this.transactionType = transactionType;
    }

}
