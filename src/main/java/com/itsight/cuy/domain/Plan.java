package com.itsight.cuy.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.itsight.cuy.domain.base.AuditingEntity;
import com.itsight.cuy.json.JsonMoneySimpleSerializer;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Plan extends AuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PlanId")
    private int id;

    private String name;

    //@JsonSerialize(using = JsonMoneySimpleSerializer.class)
    @Column(nullable = false, precision = 4, scale = 2)
    private double cost;

    //JsonSerialize(using = JsonMoneySimpleSerializer.class)
    @Column(precision = 8, scale = 2)
    private double megaNumber;

    @Column
    private int minuteNumber;
    // Monto
    @JsonSerialize(using = JsonMoneySimpleSerializer.class)
    @Column(precision = 8, scale = 2)
    private BigDecimal amount;

    //@JsonSerialize(using = JsonMoneySimpleSerializer.class)
    @Column(nullable = false, precision = 4, scale = 2)
    private double localMinCost;

    //@JsonSerialize(using = JsonMoneySimpleSerializer.class)
    @Column(nullable = false, precision = 4, scale = 2)
    private double intMinCost;

    //@JsonSerialize(using = JsonMoneySimpleSerializer.class)
    @Column(nullable = false, precision = 4, scale = 2)
    private double localSmsCost;

    //@JsonSerialize(using = JsonMoneySimpleSerializer.class)
    @Column(nullable = false, precision = 4, scale = 2)
    private double intSmsCost;

    //@JsonSerialize(using = JsonMoneySimpleSerializer.class)
    @Column(nullable = false, precision = 4, scale = 2)
    private double localMbCost;

    //@JsonSerialize(using = JsonMoneySimpleSerializer.class)
    @Column(nullable = false, precision = 4, scale = 2)
    private double intMbCost;

    private boolean flagVisible;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PlanTypeId", updatable = false)
    private PlanType planType;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "plan")
    private List<PersonPlan> lstPersonCard;

    public Plan(){}

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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getMegaNumber() {
        return megaNumber;
    }

    public void setMegaNumber(double megaNumber) {
        this.megaNumber = megaNumber;
    }

    public double getMinuteNumber() {
        return minuteNumber;
    }

    public void setMinuteNumber(int minuteNumber) {
        this.minuteNumber = minuteNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean isFlagVisible() {
        return flagVisible;
    }

    public void setFlagVisible(boolean flagVisible) {
        this.flagVisible = flagVisible;
    }

    public PlanType getPlanType() {
        return planType;
    }

    public void setPlanType(PlanType planType) {
        this.planType = planType;
    }

    public double getLocalMinCost() {
        return localMinCost;
    }

    public void setLocalMinCost(double localMinCost) {
        this.localMinCost = localMinCost;
    }

    public double getIntMinCost() {
        return intMinCost;
    }

    public void setIntMinCost(double intMinCost) {
        this.intMinCost = intMinCost;
    }

    public double getLocalSmsCost() {
        return localSmsCost;
    }

    public void setLocalSmsCost(double localSmsCost) {
        this.localSmsCost = localSmsCost;
    }

    public double getIntSmsCost() {
        return intSmsCost;
    }

    public void setIntSmsCost(double intSmsCost) {
        this.intSmsCost = intSmsCost;
    }

    public double getLocalMbCost() {
        return localMbCost;
    }

    public void setLocalMbCost(double localMbCost) {
        this.localMbCost = localMbCost;
    }

    public double getIntMbCost() {
        return intMbCost;
    }

    public void setIntMbCost(double intMbCost) {
        this.intMbCost = intMbCost;
    }

    public List<PersonPlan> getLstPersonCard() {
        return lstPersonCard;
    }

    public void setLstPersonCard(List<PersonPlan> lstPersonCard) {
        this.lstPersonCard = lstPersonCard;
    }

    public Plan(String name, double cost, double megaNumber, int minuteNumber, BigDecimal amount, int planTypeId) {
        this.name = name;
        this.cost = cost;
        this.megaNumber = megaNumber;
        this.minuteNumber = minuteNumber;
        this.amount = amount;
        this.planType = new PlanType(planTypeId);
    }

    public Plan(String name, double megaNumber, int minuteNumber, BigDecimal amount, boolean flagVisible, PlanType planType) {
        this.name = name;
        this.megaNumber = megaNumber;
        this.minuteNumber = minuteNumber;
        this.amount = amount;
        this.flagVisible = flagVisible;
        this.planType = planType;
    }

    public Plan(int id) { this.id = id; }

}