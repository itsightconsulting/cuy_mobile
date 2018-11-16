package com.itsight.cuy.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.itsight.cuy.domain.base.AuditingEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class CardType extends AuditingEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CardTypeId")
    private int id;

    private String name;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cardType")
    private List<Card> lstCard;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getLstCard() {
        return lstCard;
    }

    public void setLstCard(List<Card> lstCard) {
        this.lstCard = lstCard;
    }

    public CardType(String name, boolean flag, String createdBy, Date date) {
        this.name = name; this.setFlagActive(flag); this.setCreatedBy(createdBy); setCreationDate(date);
    }

    public CardType(int id) { this.id = id; }

    public CardType() { }
}