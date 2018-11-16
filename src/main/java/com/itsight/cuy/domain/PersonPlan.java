package com.itsight.cuy.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.itsight.cuy.domain.base.AuditingEntity;

import javax.persistence.*;
import java.io.Serializable;

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

    public PersonPlan(int personId, int planId) {
        this.person = new Person(personId);
        this.plan = new Plan(planId);
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
