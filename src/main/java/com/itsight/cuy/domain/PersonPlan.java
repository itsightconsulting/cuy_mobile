package com.itsight.cuy.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.itsight.cuy.domain.base.AuditingEntity;

import javax.persistence.*;
import java.io.Serializable;

@NamedEntityGraphs({
    @NamedEntityGraph(name = "personPlan")
})
@Entity
public class PersonPlan extends AuditingEntity implements Serializable {

    @Id
    @Column(name = "PersonPlanId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(nullable = false, updatable = false, name = "PersonId")
    private Person person;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(nullable = false, updatable = false, name = "PlanId")
    private Plan plan;

    @Column(nullable = false, updatable = false)
    private String phoneNumber;

    @Column(nullable = false, precision = 8, scale = 2)
    //@JsonSerialize(using = JsonMoneySimpleSerializer.class)
    private double residue;

    @Column(nullable = false, precision = 8, scale = 2)
    //@JsonSerialize(using = JsonMoneySimpleSerializer.class)
    private double consumption;

    @Column(nullable = false)
    private int remainingSms;

    @Column(nullable = false, precision = 8, scale = 2)
    //@JsonSerialize(using = JsonMoneySimpleSerializer.class)
    private double remainingMbs;

    @Column(nullable = false)
    private int remainingMinutes;

    public PersonPlan(){}

    public PersonPlan(int personId, int planId, String phoneNumber) {
        this.person = new Person(personId);
        this.plan = new Plan(planId);
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getResidue() {
        return residue;
    }

    public void setResidue(double residue) {
        this.residue = residue;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public int getRemainingSms() {
        return remainingSms;
    }

    public void setRemainingSms(int remainingSms) {
        this.remainingSms = remainingSms;
    }

    public double getRemainingMbs() {
        return remainingMbs;
    }

    public void setRemainingMbs(double remainingMbs) {
        this.remainingMbs = remainingMbs;
    }

    public int getRemainingMinutes() {
        return remainingMinutes;
    }

    public void setRemainingMinutes(int remainingMinutes) {
        this.remainingMinutes = remainingMinutes;
    }
}
