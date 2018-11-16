package com.itsight.cuy.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.itsight.cuy.domain.base.AuditingEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class DocumentType extends AuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DocumentTypeId")
    private int id;

    private String name;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "documentType")
    private List<Person> lstPerson;

    public DocumentType(){
    }

    public DocumentType(String name, boolean flag, String createdBy, Date date) {
        this.name = name; this.setFlagActive(flag); this.setCreatedBy(createdBy); setCreationDate(date);
    }

    public DocumentType(int id)
    { this.id = id;}

    
    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getLstPerson() {
        return lstPerson;
    }

    public void setLstPerson(List<Person> lstPerson) {
        this.lstPerson = lstPerson;
    }


}
