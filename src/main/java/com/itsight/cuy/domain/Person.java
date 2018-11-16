package com.itsight.cuy.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.itsight.cuy.domain.base.AuditingEntity;
import com.itsight.cuy.domain.jsonb.Preferences;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@TypeDefs({
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class),
})
public class Person extends AuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PersonId")
    private int id;

    private String name;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PersonTypeId", updatable = false)
    private PersonType personType;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DocumentTypeId", updatable = false)
    private DocumentType documentType;

    private String documentNumber;

    // Tarjeta
    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
    private List<Card> lstCard;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
    private List<PersonPlan> lstPersonCard;

    @Type(type = "jsonb")
    @Column(name = "preferences", columnDefinition = "jsonb")
    private Preferences preferences;

    public Person() { }

    public Preferences getPreferences() {
        return preferences;
    }

    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }

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

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public List<Card> getLstCard() {
        return lstCard;
    }

    public void setLstCard(List<Card> lstCard) {
        this.lstCard = lstCard;
    }

    public List<PersonPlan> getLstPersonCard() {
        return lstPersonCard;
    }

    public void setLstPersonCard(List<PersonPlan> lstPersonCard) {
        this.lstPersonCard = lstPersonCard;
    }

    public Person(String name, int personTypeId, int documentTypeId, String documentNumber, boolean flag, String createdBy, Date date, Preferences preferences) {
        this.name = name;
        this.personType = new PersonType(personTypeId);
        this.documentType = new DocumentType(documentTypeId);
        this.documentNumber = documentNumber;
        this.setFlagActive(flag); this.setCreatedBy(createdBy); setCreationDate(date);
        this.preferences = preferences;
    }

    public Person(int id) { this.id = id; }

}