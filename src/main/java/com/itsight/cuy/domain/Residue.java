package com.itsight.cuy.domain;

import com.itsight.cuy.domain.base.AuditingEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
// Saldo
public class Residue extends AuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ResidueId")
    private int id;

    private String name;

    private String description;

    // Monto
    private String amount;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Residue(String name, String description, String amount) {
        this.name = name;
        this.description = description;
        this.amount = amount;
    }

    public Residue() { }

}
