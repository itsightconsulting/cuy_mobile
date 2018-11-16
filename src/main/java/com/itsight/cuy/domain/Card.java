package com.itsight.cuy.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.itsight.cuy.domain.base.AuditingEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Card extends AuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CardId")
    private int id;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PersonId", updatable = false)
    private Person person;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CardTypeId", updatable = false)
    private CardType cardType;

    private String digits;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date expirationDate;

    private String cvv;

    private String description;

    private boolean flagFavorite;

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

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(int cardType) {
        this.cardType = new CardType(cardType);
    }

    public String getDigitos() {
        return digits;
    }

    public void setDigitos(String digits) {
        this.digits = digits;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFlagFavorite() {
        return flagFavorite;
    }

    public void setFlagFavorite(boolean flagFavorite) {
        this.flagFavorite = flagFavorite;
    }

    public Card(int personId, int idcardType, String digits, Date expirationDate, String cvv, String description, boolean flag, String createdBy, Date date) {
        this.person = new Person(personId);
        this.cardType = new CardType(idcardType);
        this.digits = digits;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.description = description;
        this.setFlagActive(flag); this.setCreatedBy(createdBy); setCreationDate(date);
    }

    public Card(int id) { this.id = id; }

    public Card() { }
}