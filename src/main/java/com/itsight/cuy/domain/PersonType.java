package com.itsight.cuy.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.itsight.cuy.domain.base.AuditingEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class PersonType extends AuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PersonTypeId")
    private int id;

    private String name;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "personType")
    private List<Person> lstPerson;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Person> getLstPerson() {
        return lstPerson;
    }

    public void setLstPerson(List<Person> lstPerson) {
        this.lstPerson = lstPerson;
    }

    public PersonType(String name, boolean flag, String creador, Date fecha) {
        this.name = name; this.setFlagActive(flag); this.setCreatedBy(creador); setCreationDate(fecha);
    }

    public PersonType(int id) { this.id = id; }
    public PersonType() { }
}