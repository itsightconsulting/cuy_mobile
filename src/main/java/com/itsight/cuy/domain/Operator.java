package com.itsight.cuy.domain;

import com.itsight.cuy.domain.base.AuditingEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Operator extends AuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OperatorId")
    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String name) {
        this.name = name;
    }

    public Operator(){}

    public Operator(String name, boolean flag, String createdBy, Date date)  {
        this.name = name;
        this.setFlagActive(flag); this.setCreatedBy(createdBy); setCreationDate(date);
    }

    public Operator(int id) {
        this.id = id;
    }
}