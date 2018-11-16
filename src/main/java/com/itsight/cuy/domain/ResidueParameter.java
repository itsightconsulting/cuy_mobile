package com.itsight.cuy.domain;

import com.itsight.cuy.util.Enums;

import javax.persistence.*;

@Entity
public class ResidueParameter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated
    @Column(columnDefinition = "smallint")
    private Enums.ResidueRanges range;

    private int amount;

    public ResidueParameter(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Enums.ResidueRanges getRange() {
        return range;
    }

    public void setRange(Enums.ResidueRanges range) {
        this.range = range;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
